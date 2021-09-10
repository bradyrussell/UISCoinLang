/* (C) Brady Russell 2021 */
package com.bradyrussell.uiscoin.lang.compiler.filesystem;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StandardCompilerFileSystem implements CompilerFileSystem {
    private final String rootDirectory;

    public StandardCompilerFileSystem(String rootDirectory) {
        this.rootDirectory = rootDirectory;
    }

    @Override
    public String getFileAsString(String path) {
        try {
            return Files.readString(Path.of(rootDirectory,path));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public byte[] getFileAsBytes(String path) {
        try {
            return Files.readAllBytes(Path.of(rootDirectory,path));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<String> listDirectory(String path) {
        try {
            return Files.list(Path.of(rootDirectory,path)).map((p)-> Path.of(rootDirectory).relativize(p).toString()).collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    @Override
    public boolean isDirectory(String path) {
        return exists(path) && Files.isDirectory(Path.of(rootDirectory,path));
    }

    @Override
    public boolean isFile(String path) {
        return exists(path) && !isDirectory(path);
    }

    @Override
    public boolean exists(String path) {
        return Files.exists(Path.of(rootDirectory,path));
    }
}
