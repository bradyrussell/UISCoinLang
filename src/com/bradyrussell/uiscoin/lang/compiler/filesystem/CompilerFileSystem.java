/* (C) Brady Russell 2021 */
package com.bradyrussell.uiscoin.lang.compiler.filesystem;

import java.util.List;

public interface CompilerFileSystem {
    String getFileAsString(String path);
    byte[] getFileAsBytes(String path);
    List<String> listDirectory(String path);
    boolean isDirectory(String path);
    boolean isFile(String path);
    boolean exists(String path);
}
