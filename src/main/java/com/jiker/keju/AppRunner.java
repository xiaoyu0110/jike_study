package com.jiker.keju;

import java.io.IOException;

public class AppRunner {

    public static void main(String[] args) throws NoSuchFieldException, IOException {
        String testDataFile = args[0];
        TripalCalculate tripalCalculate = new TripalCalculate();
        String receipt = "";
        receipt = tripalCalculate.calculateTaxiFree("src/main/resources/"+testDataFile);
        System.out.println(receipt);
    }
}
