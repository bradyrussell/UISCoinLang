/* (C) Brady Russell 2021 */
package com.bradyrussell.uiscoin.lang;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import com.bradyrussell.uiscoin.lang.compiler.ASMUtil;
import com.bradyrussell.uiscoin.lang.compiler.filesystem.CompilerFileSystem;
import com.bradyrussell.uiscoin.lang.compiler.filesystem.StandardCompilerFileSystem;
import com.bradyrussell.uiscoin.script.ScriptParser;

import org.junit.jupiter.api.Test;


public class CompilerFileSystemTest {
    @Test
    public void Test_StandardFileSystem() {
        CompilerFileSystem cfs = new StandardCompilerFileSystem("test/com/bradyrussell/uiscoin/lang");
        cfs.listDirectory("").forEach(System.out::println);
    }
}
