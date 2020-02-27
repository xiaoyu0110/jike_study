package com.jiker.keju;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileAnalys {

    public static List<String> getFileContent(String filePath)  {
        List<String> fileLines = null;
        try (
            Stream<String> stream = Files.lines(Paths.get(filePath))) {
            fileLines = stream.collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return fileLines;
    }

}
