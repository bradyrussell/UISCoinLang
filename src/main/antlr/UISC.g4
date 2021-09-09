grammar UISC;
@header {
package com.bradyrussell.uiscoin.lang.generated;
}
@lexer::members {
    private static final int WHITESPACE = 1;
    private static final int COMMENTS = 2;
}

file:   (functionDeclaration | varDeclaration | statement)+ ;

pointer
    : '@';

varDeclaration
    :   constant='const'? type ID ('=' expression)? ';' #varInitialization    // int32@ myPtr = 7; //read as: there is an int32 at (address) 7
    |   type ID '[]' '=' arrayInitializer ';' #arrayValueInitialization
    |   type ID '[]' '=' STRING ';' #arrayStringInitialization
    |   type ID '[' size=INT ']' ('=' expression)? ';' #arrayAssignmentInitialization  // todo const arrays? // cant make int optional....
    ;

structDeclaration
    :   'struct' ID '{' varDeclaration+ '}'
    ;

type:   (primitiveType | structType | inferredType) pointer?;

primitiveType:
    'void' | 'byte' | 'int32' | 'int64' | 'float'
    ;

structType:
    ID
    ;

inferredType:
    'var' | 'auto'
    ;

booleanLiteral: trueliteral='true' | falseliteral='false' | nullliteral='null';

arrayInitializer
    : '{' exprList? '}'
    ;

functionDeclaration
    :   type ID array='[]'? '(' formalParameters? ')' block // "void f(int x) {...}"
    ;
formalParameters
    :   formalParameter (',' formalParameter)*
    ;
formalParameter
    :   type ID
    ;

block:  '{' statement* '}' ;   // possibly empty statement block

statement:   block                                                                                                      #blockStatement
    |   varDeclaration                                                                                                  #varDeclarationStatement
    |   structDeclaration                                                                                               #structDeclarationStatement
    |   'if' conditional=expression '{' ifbody=statement+ '}' elseifStatement* elseStatement?                           #ifStatement
    |   'ufori' '(' iterations=INT (',' iterationsEnd=INT)? as='as' type ID ')' forbody=statement+                         #uforiStatement
    |   'uforeach' '(' arrayToLoop=ID as='as' varDeclaration ')' forbody=statement+                                        #uforeachStatement
    |   'while' '(' expression ')' whilebody=statement+                                                                 #whileStatement // EFC code
    |   'for' '(' varDeclaration conditional=expression ';' afterEach=statement ')' forbody=statement+                  #forStatement // EFC code
    |   'return' retval=expression? ';'                                                                                 #returnStatement
    |   (lhs=ID|lhs_struct=structField) ('[' arrayIndex=expression ']')? '=' rhs=expression ';'                         #assignmentStatement
    |   (lhs=ID|lhs_struct=structField) ('[' arrayIndex=expression ']')? op=('+='|'-='|'*='|'/='|'%='|'&='|'|='|'^=') rhs=expression ';'      #opAndAssignmentStatement
    |   tryStatement catchStatement?                                                                                    #tryCatchStatement
    |   expression ';'                                                                                                  #functionCallStatement
    |   assembly                                                                                                        #assemblyStatement
    |   assertion                                                                                                       #assertionStatement
    |   exception                                                                                                       #exceptionStatement
    |   include                                                                                                         #includeStatement
    |   flag                                                                                                            #flagStatement
    |   flagData                                                                                                        #flagDataStatement
    |   'break' ';'                                                                                                     #breakStatement
    |   'continue' ';'                                                                                                  #continueStatement
    ;

elseifStatement:
    'else' 'if' '(' conditional=expression ')' '{' statement+ '}';

elseStatement:
    'else' '{' statement+ '}';

tryStatement:
    'try' '{' statement+ '}';

catchStatement:
    'catch' '(' exprList? ')' '{' statement+ '}';

number:
        INT
    | FLOAT
    ;

assembly:
    'asm' '(' STRING ')' ';'
    ;

assertion:
    'assert' '(' expression ')' ';'
    ;

exception:
    'throw' '(' exprList? ')' ';' // pushes these values on the stack then OP return
    ;

include:
    'include' '(' STRING ')' ';'
    ;

flag:
    'flag' '(' INT ')' ';'
    ;

flagData:
    'flagdata' '(' STRING ')' ';'
    ;

structField:
    structname=ID ('[' structArrayIndex=expression ']')? ('.' fieldname=ID ('[' fieldArrayIndex=expression ']')?)+
    ;

// expressions should push a single value on to the stack (net +1, temp variables are fine)
expression:
        '(' type ')' expression                                             #castExpression // cast like (byte) getInteger()
    |  '_' ID '(' exprList? ')'                                             #nativeCallExpression // wrapper around native functions like encryptAES
    |   ID '(' exprList? ')'                                                #functionCallExpression  // func call like f(), f(x), f(1,2)
    |   ID '[' expression ']'                                               #arrayAccessExpression   // array index like a[i], a[i][j]
    |   '$' ID                                                              #addressOfVariableExpression     // push variable location
    |   '@' expression                                                      #valueAtVariableExpression     // push variable at (expression as location)
    |   '#' expression                                                      #lengthOfExpression     // return length of variable (op COUNT)
    |   '#' type                                                            #sizeOfExpression     // return sizeof(type)
    |   '-' expression                                                      #negateExpression   // unary minus
    |   '!' expression                                                      #notExpression  // boolean not
    |   op=('--'|'++') expression                                           #prefixOpExpression   // --x or ++x;
    |   expression op=('--'|'++')                                           #postfixOpExpression   // x-- or x++;
    |   lhs=expression ('%') rhs=expression                                 #moduloExpression
    |   lhs=expression op=('*'|'/') rhs=expression                          #multDivExpression
    |   lhs=expression op=('+'|'-') rhs=expression                          #addSubExpression
    |   lhs=expression op=('&'|'|'|'^'|'~') rhs=expression                  #bitwiseExpression
    |   lhs=expression op=('&&'|'||'|'^^') rhs=expression                   #andOrXorExpression
    |   lhs=expression op=('<'|'<='|'>'|'>=') rhs=expression                #comparisonExpression     //  comparison
    |   lhs=expression op=('=='|'!=') rhs=expression                        #equalityExpression     // equality comparison (lowest priority op)
    |   ID                                                                  #variableReferenceExpression     // variable reference
    |   structField                                                         #structFieldReferenceExpression     // struct field reference // todo array as struct field?
    |   number                                                              #numberLiteralExpression
    |   booleanLiteral                                                      #booleanLiteralExpression
    |   STRING                                                              #stringLiteralExpression        // strings are byte arrays
    |   CHAR                                                                #charLiteralExpression
    |   '(' expression ')'                                                  #parenExpression
    | condition=expression '?' iftrue=expression ':' iffalse=expression     #ternaryExpression
    ;
exprList : expression (',' expression)* ;   // arg list




//have to reserve keywords here so they arent parsed as struct names?
CONST:
    'const'
    ;

ID  :   LETTER (LETTER | [0-9] | '_')* ;
fragment
LETTER : [a-zA-Z] ;

//NUMBER: (INT | FLOAT) ; better as production rule

INT :   [0-9]+ ;
fragment HEXDIGIT : 'a'..'f' | 'A'..'F' | [0-9]; // todo implement
fragment EXPONENT : ('e' | 'E') ('+' | '-')? [0-9]+; // todo implement   implement ternary and asm();

FLOAT: (INT) '.' (INT)? (EXPONENT)? /*'f'?*/; // since there are no doubles just use . to indicate floats

STRING
    :   '"' StringCharSequence? '"'
    ;

CHAR
    : '\'' StringChar '\''  ;

fragment
StringCharSequence
    :   StringChar+
    ;
fragment
StringChar
    :   ~["\\\r\n]
//    |   EscapeSequence
    |   '\\\n'   // Added line
    |   '\\\r\n' // Added line
    ;

WS  :   [ \t\n\r]+ -> channel(1);

SL_COMMENT
    :   '//' .*? '\n' -> channel(2)
    ;

ML_COMMENT
    : '/*' .*? '*/' -> channel(2)
    ;

INVALID
    : . -> channel(2)
    ;