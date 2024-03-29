/* (C) Brady Russell 2021 */
package com.bradyrussell.uiscoin.lang;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

import com.bradyrussell.uiscoin.lang.compiler.ASMUtil;
import com.bradyrussell.uiscoin.lang.compiler.filesystem.StandardCompilerFileSystem;
import com.bradyrussell.uiscoin.script.ScriptExecution;
import com.bradyrussell.uiscoin.script.ScriptParser;
import com.bradyrussell.uiscoin.script.exception.*;

import org.junit.jupiter.api.Test;


public class CompilerTest {
    @Test
    public void Test_BasicMathExpression() {
        String Script =
                "int32 x = 500 * 700 + 200 * 900 / 400 + 120;\n" +
                        "int32 y = x * x;";

        performStandardTests(ASMUtil.compileHLLToASM(Script), "[0, 5, 89, 106] [-99, 94, -33, -28]");
    }

    @Test
    public void Test_TypeInferredCast() {
        String Script =
                                "int64 x = 600;\n" +
                                "x = (auto)3.14159265;\n" +
                                "x = (auto)(((auto)true));\n" +
                                "int32 z(byte g) {\n" +
                                "\treturn (auto)g;\n" +
                                "}\n" +
                                "auto y = z((auto)x);\n" +
                                "byte r[] = {(auto)y};\n" +
                                "auto s[] = {500, 600, 700};\n" +
                                "float a = (auto)z((auto)(y));\n";

        performStandardTests(ASMUtil.compileHLLToASM(Script), null);
    }

    @Test
    public void Test_ArraySize() {
        String Script =
                                "auto x[] = {300, 400, 500};\n" +
                                "auto y[] = {(int64)3, -2};\n" +
                                "auto z[] = {50, -60, 70, 80};\n" +
                                "int32 xlen = _len(x)/_sizeof(x);\n" +
                                "int32 ylen = _len(y)/_sizeof(y);\n" +
                                "int32 zlen = _len(z)/_sizeof(z);\n";

        performStandardTests(ASMUtil.compileHLLToASM(Script), "[0, 0, 1, 44, 0, 0, 1, -112, 0, 0, 1, -12] [0, 0, 0, 0, 0, 0, 0, 3, -1, -1, -1, -1, -1, -1, -1, -2] [50, -60, 70, 80] [0, 0, 0, 3] [0, 0, 0, 2] [0, 0, 0, 4]");
    }

    @Test
    public void Test_NestedIf() {
        String Script =
                        "int32 x() {\n" +
                                "\tauto z = 365;\n" +
                                "\tif(z > 1) {\n" +
                                "\t\tif(z % 2 == 0) {\n" +
                                "\t\t\treturn -1;\n" +
                                "\t\t} else {\n" +
                                "\t\t\treturn -2;\n" +
                                "\t\t}\n" +
                                "\t} else if(z > 2) {\n" +
                                "\t\treturn 2;\n" +
                                "\t} else {\n" +
                                "\t\tint64 a = 1;\n" +
                                "\t\treturn 3;\n" +
                                "\t}\n" +
                                "\tasm(\" nop \");\n" + // todo if statement jump needs this
                                "}\n" +
                                "auto y = x();";

        performStandardTests(ASMUtil.compileHLLToASM(Script), null);
    }

    @Test
    public void Test_TypeInferredCastReturnedValue() {
        String Script =
                "int64 y = 100;\n" +
                        "int32 x(int64 y) {\n" +
                        "return (int32)y * -2;\n" +
                        "}\n" +
                        "byte z = (auto)x(y);";

        performStandardTests(ASMUtil.compileHLLToASM(Script), null);
    }

    @Test
    public void Test_Main() { // allocator problem?
        String Script =
                "int32 x(int64 y) {\n" +
                        "\treturn (auto)_pow((auto)y, (auto)2);\n" +
                        "}\n" +
                        "\n" +
                        "void main[]() {\n" +
                        "\treturn x(2);\n" +
                        "}";

        //performStandardTests(ASMUtil.compileHLLToASM(Script), null);
    }

    @Test
    public void Test_Include() {
        String Script =
                        "include(\"demo.uisc\");\n";

        ASMUtil.defaultFileSystem = new StandardCompilerFileSystem("test/com/bradyrussell/uiscoin/lang/include");
        performStandardTests(ASMUtil.compileHLLToASM(Script), "[0, 0, 0, 42]");
    }

    @Test
    public void Test_IncludeBinary() throws IOException {
        String script = "int32 x = 123;";
        Files.write(Path.of("test/com/bradyrussell/uiscoin/lang/include", "demo.uiscb"), ScriptParser.CompileScriptTokensToBytecode(ScriptParser.GetTokensFromString(ASMUtil.compileHLLToASM(script), true)));

        String Script =
                        "include(\"demo.uiscb\");\n";

        ASMUtil.defaultFileSystem = new StandardCompilerFileSystem("test/com/bradyrussell/uiscoin/lang/include");
        performStandardTests(ASMUtil.compileHLLToASM(Script), "[0, 0, 0, 123]");
        Files.delete(Path.of("test/com/bradyrussell/uiscoin/lang/include", "demo.uiscb"));
    }

    @Test
    public void Test_PointerArray() {
        String Script =
                "void@ x[] = {(void@)1, (void@)2, (void@)3, (void@)4};";

        performStandardTests(ASMUtil.compileHLLToASM(Script), null);
    }

    @Test
    public void Test_FunctionReturnsPointer() {
        String Script =
                "int32@ x(int32 a) {\n" +
                        "\treturn $a;\n" +
                        "}\n" +
                        "int32@ y = x(1);";

        performStandardTests(ASMUtil.compileHLLToASM(Script), null);
    }

    @Test
    public void Test_TypeInference() {
        String Script =
                        "auto x = 32;\n" +
                        "auto y = 256;\n" +
                        "auto z = x + y;\n"+
                        "auto w = (float)4;\n"+
                        "assert(z == 288);";

        performStandardTests(ASMUtil.compileHLLToASM(Script), null);
    }

    @Test
    public void Test_TypeInferenceNeedsBiggerTypeThanExpressionMembers() {
        String Script =
                        "auto x = 2147483640;\n" +
                        "auto y = 2147483641;\n" +
                        "auto z = x + y;\n"+
                        "assert(z == 4294967281);";

        //performStandardTests(ASMUtil.compileHLLToASM(Script), null); //todo fix
    }

    @Test
    public void Test_BooleanLogic() {
        String Script =
                        "byte t = 1;\n" +
                        "byte f = 0;\n" +
                        "assert(t || f);\n" +
                        "assert(!(!t || f));\n" +
                        "assert(t && !f);\n" +
                        "assert(t ^^ f);\n" +
                        "\n" +
                        "assert(t || false);\n" +
                        "assert(!(!t || false));\n" +
                        "assert(t && !false);\n" +
                        "assert(t ^^ false);\n" +
                        "\n" +
                        "assert(true || f);\n" +
                        "assert(!(!true || f));\n" +
                        "assert(true && !false);\n" +
                        "assert(true ^^ f);\n" +
                        "\n" +
                        "assert(true || false);\n" +
                        "assert(!(!true || false));\n" +
                        "assert(true && !false);\n" +
                        "assert(true ^^ false);\n"+
                        "assert(true && true && true && true);";

        System.out.println(ASMUtil.compileHLLToASM(Script));
        performStandardTests(ASMUtil.compileHLLToASM(Script), "[1] [0]");
    }

    @Test
    public void Test_EqualityOperators() {
        String Script =
                "int32 x = (int32)30 * 10;\n" + // todo : this needs to be made int32s BEFORE multiplication otherwise this results in an error!
                        "int32 y = (int32)60 * 5;\n" +
                        "byte z = x == y;\n" +
                        "byte w = x != y;\n" +
                        "assert(z ^^ w);";

        performStandardTests(ASMUtil.compileHLLToASM(Script), "[0, 0, 1, 44] [0, 0, 1, 44] [1] [0]");
    }

    @Test
    public void Test_Functions() { // todo optimized code returns different function, but same output, how to fix test case, maybe array of possible results, or wildcard??
        String Script =
                "int32 square(int32 x) {\n" +
                        "\treturn x*x;\n" +
                        "}\n" +
                        "\n" +
                        "int32 a = 10;\n" +
                        "int32 b = square(a);\n" +
                        "asm(\"shiftdown drop\");"; //drop function as optimization will mangle the function code

        performStandardTests(ASMUtil.compileHLLToASM(Script), "[0, 0, 0, 10] [0, 0, 0, 100]");
    }

    @Test
    public void Test_Functions2() {
        String Script = //  true pick    true put  push [2] pick    push [2] put  depth  false pick call verify push [3] put  // todo why  true pick    true put  push [2] pick    push [2] put, those pits dont make sense
                "int64 test(int32 x, int32 y) {\n" +
                        "\tasm(\"append null swap\");\n" +
                        "\treturn (void)x;\n" +
                        "}\n" +
                        "\n" +
                        "int32 a = 123;\n" +
                        "int32 b = 321;\n" +
                        "int64 z = test(a, b);";
        performStandardTests(ASMUtil.compileHLLToASM(Script), null);
    }

    @Test
    public void Test_Ternary() {
        String Script =
                        "auto x = true;\n" +
                        "assert((x ? 45 : 46) == 45);";

        System.out.println(ASMUtil.compileHLLToASM(Script));
        performStandardTests(ASMUtil.compileHLLToASM(Script), "[1]");
    }

    @Test
    public void Test_Flag() {
        String Script =
                        "int32 x = 12;\n" +
                        "int32 y = 38;\n" +
                        "flag(5);\n" +
                        "flagdata(0x52,0x0535);\n" +
                        "flagdata(0x01,\"string\");\n" +
                        "assert(x+y == 50);";

        System.out.println(ASMUtil.compileHLLToASM(Script));
        performStandardTests(ASMUtil.compileHLLToASM(Script), "[0, 0, 0, 12] [0, 0, 0, 38]");
    }

    @Test
    public void Test_ArrayAccess() {
        String Script =
                "byte a[] = {1, 2, 3, 4};\n" +
                        "byte b = a[3];";

        System.out.println(ASMUtil.compileHLLToASM(Script));
        performStandardTests(ASMUtil.compileHLLToASM(Script), "[1, 2, 3, 4] [4]");
    }

    @Test
    public void Test_ArrayElementAssignment() {
        String Script =
                "byte z = 6;\n" +
                        "byte a[] = {1, 2, 3, 4};\n" +
                        "a[2] = z;";

        performStandardTests(ASMUtil.compileHLLToASM(Script), "[6] [1, 2, 6, 4]");
    }

    @Test
    public void Test_AutoWidening() {
        String Script =
                "byte a = 64;\n" +
                        "int32 b = a;\n" +
                        "float c = b;\n" +
                        "int64 d = b;\n";

        performStandardTests(ASMUtil.compileHLLToASM(Script), "[64] [0, 0, 0, 64] [66, -128, 0, 0] [0, 0, 0, 0, 0, 0, 0, 64]");
    }

    @Test
    public void Test_Casting() {
        String Script =
                "int64 a = 64;\n" +
                        "int32 b = (int32)a;\n" +
                        "float c = b;\n" +
                        "byte d = (byte)b;\n";

        performStandardTests(ASMUtil.compileHLLToASM(Script), "[0, 0, 0, 0, 0, 0, 0, 64] [0, 0, 0, 64] [66, -128, 0, 0] [64]");
    }

    @Test
    public void Test_Exponent() {
        String Script =
                "float x = 1.e+2;\n";

        //performStandardTests(ASMUtil.compileHLLToASM(Script), "[0, 0, 0, 0, 0, 0, 0, 64] [0, 0, 0, 64] [66, -128, 0, 0] [64]"); //todo fix
    }

    @Test
    public void Test_StructElementAssign() { //todo negate requires 32 bit? impl byte negate
        String Script =
                "struct test {\n" +
                        "    int32 a;\n" +
                        "    int64 b;\n" +
                        "    int32 c[4];\n" +
                        "    byte d[12];\n" +
                        "}\n" +
                        "\n" +
                        "test myTest;\n" +
                        "\n" +
                        "myTest.a = 6;\n" +
                        "myTest.b = 12;\n" +
                        "myTest.c[0] = 1;\n" +
                        "myTest.c[1] = 2;\n" +
                        "myTest.c[2] = 3;\n" +
                        "myTest.c[3] = 4;\n" +
                        "myTest.d[0] = -1;\n" +
                        "myTest.d[1] = -2;\n" +
                        "myTest.d[2] = -3;\n" +
                        "myTest.d[3] = -4;\n" +
                        "myTest.d[4] = -5;\n" +
                        "myTest.d[5] = -6;\n" +
                        "myTest.d[6] = -7;\n" +
                        "myTest.d[7] = -8;\n" +
                        "myTest.d[8] = -9;\n" +
                        "myTest.d[9] = -10;\n" +
                        "myTest.d[10] = -11;\n" +
                        "myTest.d[11] = -12;\n";
        performStandardTests(ASMUtil.compileHLLToASM(Script), "[0, 0, 0, 6, 0, 0, 0, 0, 0, 0, 0, 12, 0, 0, 0, 1, 0, 0, 0, 2, 0, 0, 0, 3, 0, 0, 0, 4, -1, -2, -3, -4, -5, -6, -7, -8, -9, -10, -11, -12]");
    }

    @Test
    public void Test_StructElemAccess() {
        String Script =
                "struct test {\n" +
                        "    int32 a;\n" +
                        "    int64 b;\n" +
                        "    int32 c[4];\n" +
                        "}\n" +
                        "\n" +
                        "test myTest;\n" +
                        "\n" +
                        "myTest.a = 10;\n" +
                        "myTest.b = myTest.a * 5;\n" +
                        "ufori(4 as int32 i){\n" +
                        "    myTest.c[i] = ((int32)myTest.b) + i;\n" +
                        "}";

        performStandardTests(ASMUtil.compileHLLToASM(Script), null);
    }

    @Test
    public void Test_OpAndAssignment() {
        String Script =
                "int32 a = 123;\n" +
                        "int32 b = 6;\n" +
                        "a += b;\n" +
                        "a -= b;\n" +
                        "a *= b;\n" +
                        "a /= b;\n" +
                        "a &= b;\n" +
                        "a |= b;\n" +
                        "//a ^= b;";

        performStandardTests(ASMUtil.compileHLLToASM(Script), "[0, 0, 0, 6] [0, 0, 0, 6]");
    }

    @Test
    public void Test_Natives() { // todo fix void casts
        String Script =
                        "byte m[] = \"Hello world!\";\n" +
                        "byte k[] = \"encryptionKey\";\n" +
                        "void o = (void)_encrypt(m, k);\n" +
                        "asm(\"/* my asm comment */\");\n" +
                        "o = (void)_decrypt(_encrypt(m, k), k);\n" +
                        "o = (void)_zip(_decrypt(_encrypt(m, k), k));\n" +
                        "o = (void)_unzip(_zip(_decrypt(_encrypt(m, k), k)));\n" +
                        "_copy($m, (int32)0, $k, (int32)0, (int32)2);\n"+
                        "int32 len = _len(o);\n"+
                        "int32 sizeof = _sizeof(len);\n"+
                        "flagdata(0x01, 0x05);";

        performStandardTests(ASMUtil.compileHLLToASM(Script), "[72, 101, 108, 108, 111, 32, 119, 111, 114, 108, 100, 33] [72, 101, 99, 114, 121, 112, 116, 105, 111, 110, 75, 101, 121] [72, 101, 108, 108, 111, 32, 119, 111, 114, 108, 100, 33] [0, 0, 0, 12] [0, 0, 0, 4]");
    }

    @Test
    public void Test_MathNatives() {
        String Script =
                                "float x = 42.6;\n" +
                                "float y = (auto)-2;\n" +
                                "float fabs = _fabs(y);\n" +
                                "float log = _log(x);\n" +
                                "float logn = _logn(x, y);\n" +
                                "float sin = _sin(x);\n" +
                                "float cos = _cos(x);\n" +
                                "float tan = _tan(x);\n" +
                                "float asin = _asin(x);\n" +
                                "float acos = _acos(x);\n" +
                                "float atan = _atan(x);\n" +
                                "float pow = _pow(x, y);\n" +
                                "float root = _root(x, y);\n" +
                                "float floor = _floor(x);\n" +
                                "float ceil = _ceil(x);\n" +
                                "float round = _round(x);\n" +
                                "byte isnan = _isnan(x);\n" +
                                "byte isinf = _isinf(x);\n" +
                                "byte isfin = _isfin(x);\n";

        performStandardTests(ASMUtil.compileHLLToASM(Script), "[66, 42, 102, 102] [-64, 0, 0, 0] [64, 0, 0, 0] [64, 112, 30, 97] [127, -64, 0, 0] [-65, 123, 119, 39] [62, 63, -31, 109] [-64, -89, -65, 123] [127, -64, 0, 0] [127, -64, 0, 0] [63, -58, 14, -53] [58, 16, 115, 121] [62, 28, -29, -43] [66, 40, 0, 0] [66, 44, 0, 0] [66, 44, 0, 0] [0] [0] [1]");
    }

    @Test
    public void Test_SyntaxMarkup() {
        String Script =
                "struct test {\n" +
                        "    int32 a;\n" +
                        "    int64 b;\n" +
                        "    int32 c[4];\n" +
                        "}\n" +
                        "\n" +
                        "test myTest;\n" +
                        "\n" +
                        "myTest.a = 10;\n" +
                        "myTest.b = myTest.a * 5;\n" +
                        "ufori(4 as int32 i){\n" +
                        "    myTest.c[i] = ((int32)myTest.b) + i;\n" +
                        "}\n" +
                        "int64 square(int64 a) {\n\treturn a * a;\n}\nconst int64 b = @square((int64)2);\n" +
                        "byte m[] = \"Hello world!\";\n" +
                        "byte k[] = \"encryptionKey\";\n" +
                        "void o = (void)_encrypt(m, k);\n" +
                        "asm(\"/* my asm comment */\");\n" +
                        "o = (void)_decrypt(_encrypt(m, k), k);\n" +
                        "o = (void)_zip(_decrypt(_encrypt(m, k), k));\n" +
                        "o = (void)_unzip(_zip(_decrypt(_encrypt(m, k), k)));\n" +
                        "_copy($m, (int32)0, $k, (int32)0, (int32)2);\n";
        String syntaxMarkup = ASMUtil.compileHLLToSyntaxMarkup(Script);
        System.out.println(syntaxMarkup);
        try {
            Files.writeString(Path.of("syntax.html"), syntaxMarkup);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void performStandardTests(String allocation, String expectedOutput) {
        ASMUtil.bNoComments = true;

        String optimized = ASMUtil.performBasicOptimizations(allocation);
        System.out.println("Optimized ASM: \n" + optimized);
        byte[] originalBytecode = ScriptParser.CompileScriptTokensToBytecode(ScriptParser.GetTokensFromString(allocation, true));
        byte[] optimizedBytecode = ScriptParser.CompileScriptTokensToBytecode(ScriptParser.GetTokensFromString(optimized, true));
        byte[] optimizedZippedBytecode = ScriptParser.CompileScriptTokensToBytecode(ScriptParser.GetTokensFromString(ASMUtil.generateExecuteZippedASM(optimized), true));

        System.out.println(Arrays.toString(optimizedBytecode));
        System.out.println(Arrays.toString(optimizedZippedBytecode));

        boolean bNoOptimization = Arrays.equals(originalBytecode, optimizedBytecode);

        ScriptExecution originalScriptExecution = new ScriptExecution();
        ScriptExecution optimizedScriptExecution = new ScriptExecution();
        ScriptExecution optimizedZippedScriptExecution = new ScriptExecution();

        originalScriptExecution.bThrowExceptionOnFailure = true;
        optimizedScriptExecution.bThrowExceptionOnFailure = true;
        optimizedZippedScriptExecution.bThrowExceptionOnFailure = true;

        originalScriptExecution.initialize(originalBytecode);
        optimizedScriptExecution.initialize(optimizedBytecode);
        optimizedZippedScriptExecution.initialize(optimizedZippedBytecode);

        try {
            while (originalScriptExecution.step()) ;
        } catch (ScriptInvalidException | ScriptEmptyStackException | ScriptInvalidParameterException | ScriptUnsupportedOperationException | ScriptFailedException e) {
            fail(e);
        }

        System.out.println("Original script execution: " + (originalScriptExecution.bScriptFailed ? "FAIL" : "PASS"));
        assertFalse(originalScriptExecution.bScriptFailed);

        if (!bNoOptimization) {
            try {
                while (optimizedScriptExecution.step()) ;
            } catch (ScriptInvalidException | ScriptEmptyStackException | ScriptInvalidParameterException | ScriptUnsupportedOperationException | ScriptFailedException e) {
                fail(e);
            }

            System.out.println("Optimized script execution: " + (optimizedScriptExecution.bScriptFailed ? "FAIL" : "PASS"));
            assertFalse(optimizedScriptExecution.bScriptFailed);
        }

        try {
            while (optimizedZippedScriptExecution.step()) ;
        } catch (ScriptInvalidException | ScriptEmptyStackException | ScriptInvalidParameterException | ScriptUnsupportedOperationException | ScriptFailedException e) {
            fail(e);
        }

        System.out.println("Optimized / Zipped script execution: " + (optimizedZippedScriptExecution.bScriptFailed ? "FAIL" : "PASS"));
        assertFalse(optimizedZippedScriptExecution.bScriptFailed);

        System.out.println("Original script output: " + originalScriptExecution.getStackContents().replace("\n", " "));
        if (!bNoOptimization)
            System.out.println("Optimized script output: " + optimizedScriptExecution.getStackContents().replace("\n", " "));
        System.out.println("Optimized / Zipped script output: " + optimizedZippedScriptExecution.getStackContents().replace("\n", " "));

        if (!bNoOptimization)
            System.out.println("Original & Optimized output matches: " + (originalScriptExecution.getStackContents().equals(optimizedScriptExecution.getStackContents())));
        System.out.println("Original & Zipped / Optimized output matches: " + (originalScriptExecution.getStackContents().equals(optimizedZippedScriptExecution.getStackContents())));

/*        if (!bNoOptimization)
            assertEquals(optimizedScriptExecution.getStackContents(), originalScriptExecution.getStackContents());
        assertEquals(optimizedZippedScriptExecution.getStackContents(), originalScriptExecution.getStackContents());*/

        if (expectedOutput != null) {
            assertEquals(expectedOutput, originalScriptExecution.getStackContents().replace("\n", " ").trim());
            if (!bNoOptimization)
                assertEquals(optimizedScriptExecution.getStackContents().replace("\n", " ").trim(), expectedOutput);
            assertEquals(expectedOutput, optimizedZippedScriptExecution.getStackContents().replace("\n", " ").trim());
        }

        System.out.println();
        System.out.println("Original Bytecode: " + originalBytecode.length + " bytes.");
        if (!bNoOptimization) System.out.println("Optimized Bytecode: " + optimizedBytecode.length + " bytes.");
        else
            System.out.println("Optimized bytecode was the same as original.");
        System.out.println("Optimized & Zipped Bytecode: " + optimizedZippedBytecode.length + " bytes.");
    }

}
