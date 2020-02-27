package com.jiker.keju;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.math.BigDecimal;

public class TripalCalculateTest {

    @Test
    public void test_distance_less_than_2(){
        TripalCalculate tripalCalculate = new TripalCalculate();
        BigDecimal calculate = tripalCalculate.calculate(new BigDecimal("2"));
        Assert.assertEquals("6",calculate.toString());
    }

    @Test
    public void test_distance_more_than_2_and_less_than_8(){
        TripalCalculate tripalCalculate = new TripalCalculate();
        BigDecimal calculate = tripalCalculate.calculate(new BigDecimal("4"));
        Assert.assertEquals("7.6",calculate.toString());
    }

    @Test
    public void test_distance_more_than_8(){
        TripalCalculate tripalCalculate = new TripalCalculate();
        BigDecimal calculate = tripalCalculate.calculate(new BigDecimal("10"));
        Assert.assertEquals("13.2",calculate.toString());//6+6*0.8+2*1.2=13.2
    }

    /*停车等待，每分钟0.25元*/
    @Test
    public void test_waiting_free(){
        TripalCalculate tripalCalculate = new TripalCalculate();
        BigDecimal bigDecimal = tripalCalculate.calculateWaitingFree(new BigDecimal("3"));
        Assert.assertEquals("0.75",bigDecimal.toString());
    }

    @Test
    public void analysisFile(){
        TripalCalculate tripalCalculate = new TripalCalculate();
        String s = null;
        try {
            s = tripalCalculate.calculateTaxiFree("src/main/resources/testData.txt");
        } catch (NoSuchFieldException | IOException e) {
            e.printStackTrace();
        }
        System.out.println(s);
    }

}
