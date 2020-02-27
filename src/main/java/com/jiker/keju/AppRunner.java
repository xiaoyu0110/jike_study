package com.jiker.keju;

import java.io.IOException;

public class AppRunner {

    public static void main(String[] args) {
        String testDataFile = args[0];
        String receipt = getstr(testDataFile);
        System.out.println(receipt);
    }

    private static String getstr(String arg){
        TripalCalculate tripalCalculate = new TripalCalculate();
        String receipt = "";
        try {
            receipt = tripalCalculate.calculateTaxiFree("src/main/resources/"+arg);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return receipt ;
    }
}
