package com.jiker.keju;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @ProjectName: tdd-taxi
 * @Author: xwy
 * @Description:
 * @Date: 2020/2/27
 * @Version: 1.0
 */
public class TaxiDistanceAndTimeTest {

    @Test
    public void test_get_number_from_string(){
        String str = "aaa234dadaf456";
        ArrayList<String> strings = new ArrayList<>();
        strings.add(str);
        final List<Pair<BigDecimal, BigDecimal>> distanceAndTimeInString = TaxiDistanceAndTime.getDistanceAndTimeInString(strings);
        Assert.assertEquals("234",distanceAndTimeInString.get(0).getLeft().toString());
        Assert.assertEquals("456",distanceAndTimeInString.get(0).getRight().toString());
    }

    @Test
    public void test_get_no_number_from_string(){
        String str = "aaadada";
        ArrayList<String> strings = new ArrayList<>();
        strings.add(str);
        final List<Pair<BigDecimal, BigDecimal>> distanceAndTimeInString = TaxiDistanceAndTime.getDistanceAndTimeInString(strings);
        Assert.assertEquals(null,distanceAndTimeInString.get(0).getLeft());
        Assert.assertEquals(null,distanceAndTimeInString.get(0).getRight());
    }



}