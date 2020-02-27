package com.jiker.keju;

import java.io.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileAnalys {
    private static final Pattern pattern = Pattern.compile("\\d+");

    public static TaxiDistanceAndTime analysFiles(String filePath) throws NoSuchFieldException {
        List<String> fileLines = getFileContent(filePath);
        List<Pair<BigDecimal,BigDecimal>> listPair = new ArrayList<>();
;        fileLines.stream().forEach(text -> {
            listPair.add(getJourneyAndTime(text));
        } );
        return new TaxiDistanceAndTime(listPair);
    }
    public static List<String> getFileContent(String filePath) throws NoSuchFieldException {
        File file = new File(filePath);
        if(file.exists() && file.isFile()){
            try {
                List<String> fileLines = readFile(file);
                return fileLines;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else {
            throw new NoSuchFieldException("找不到文件");
        }
        return null;
    }

    private static List<String> readFile(File file) throws FileNotFoundException {
        List<String> lines = null ;
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(file))){
            lines = new ArrayList<>();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }

    public static Pair<BigDecimal, BigDecimal> getJourneyAndTime(String textLine){
        Matcher matcher = pattern.matcher(textLine);
        BigDecimal left = null;
        BigDecimal right = null;
        if(matcher.find()){
            left = new BigDecimal(matcher.group());
        }
        if(matcher.find()){
            right = new BigDecimal(matcher.group());
        }
        return new Pair<>(left,right);
    }
}
