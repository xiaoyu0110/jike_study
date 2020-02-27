package com.jiker.keju;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileAnalys {

    public static List<String> getFileContent(String filePath) throws NoSuchFieldException,IOException {
        File file = new File(filePath);
        if(file.exists() && file.isFile()){
            List<String> fileLines = readFile(file);
            return fileLines;
        }else {
            throw new NoSuchFieldException("找不到文件");
        }
    }

    private static List<String> readFile(File file) throws FileNotFoundException {
        List<String> lines = new ArrayList<>() ;
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(file))){
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }


}
