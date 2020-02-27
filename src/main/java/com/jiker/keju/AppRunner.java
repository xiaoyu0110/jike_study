package com.jiker.keju;

import java.io.IOException;

public class AppRunner {

    public static void main(String[] args) {
        String testDataFile = args[0];
        TripalCalculate tripalCalculate = new TripalCalculate();
        String receipt = "";
        try {
            receipt = tripalCalculate.calculateTaxiFree("src/main/resources/"+testDataFile);
        } catch (NoSuchFieldException | IOException e) {
            e.printStackTrace();
        }
        System.out.println(receipt);
    }
}
