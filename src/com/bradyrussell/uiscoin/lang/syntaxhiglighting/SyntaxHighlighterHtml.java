/* (C) Brady Russell 2021 */
package com.bradyrussell.uiscoin.lang.syntaxhiglighting;

import java.util.Map;

public class SyntaxHighlighterHtml extends SyntaxHighlighterBase {
    public static String style =
            "<style>\n" +
                    "body {background-color: #2b2b2b;}\n" +
                    "span {color: #a9b7c6;}\n" +
                    ".PrimitiveType {\n" +
                    "\tcolor:#ffb86c;\n" +
                    "}\n" +
                    ".StructType {\n" +
                    "\tcolor:#ae8abe;\n" +
                    "}\n" +
                    ".StringLiteral {\n" +
                    "\tcolor:#379c1a;\n" +
                    "}\n" +
                    ".Comment {\n" +
                    "\tcolor:#808080;\n" +
                    "}\n" +
                    ".NativeCall {\n" +
                    "\tcolor:#5394ec;\n" +
                    "}\n" +
                    ".NumberLiteral {\n" +
                    "\tcolor:#299999;\n" +
                    "}\n" +
                    ".Keyword {\n" +
                    "\tcolor:#eeeeee;\n" +
                    "\tfont-weight:bold;\n" +
                    "}\n" +
                    ".Function {\n" +
                    "\tcolor:#dcc457;\n" +
                    "}\n" +
                    ".Variable {\n" +
                    "\tcolor:#bd93f9;\n" +
                    "}\n" +
                    ".AddressOf {\n" +
                    "\tcolor:#50fa7b;\n" +
                    "}\n" +
                    ".ValueAt {\n" +
                    "\tcolor:#50fa7b;\n" +
                    "}\n" +
                    ".Const {\n" +
                    "\tcolor:#eeeeee;\n" +
                    "\tfont-weight:bold;\n" +
                    "}\n" +
                    "</style>";

    @Override
    public String getOpenTag(SyntaxHighlight type) {
        return "<span class=\""+type.name()+"\">";
    }

    @Override
    public String getCloseTag(SyntaxHighlight type) {
        return "</span>";
    }

    @Override
    public String getGlobalOpenTag() {
        return style.replace("\n", "").replace("\t", "")+"<span class=\"code\">";
    }

    @Override
    public String getGlobalCloseTag() {
        return "</span>";
    }

    @Override
    public Map<String, String> getReplacements() {
        return Map.of("\n", "<br/>", "\t","&emsp;");
    }
}
