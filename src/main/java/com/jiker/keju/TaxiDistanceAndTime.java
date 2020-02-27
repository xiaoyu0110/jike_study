package com.jiker.keju;

import lombok.Getter;

import java.math.BigDecimal;
import java.util.List;

/**
 * @ProjectName: my-test
 * @Author: xwy
 * @Description:
 * @Date: 2020/2/26
 * @Version: 1.0
 */
public class TaxiDistanceAndTime {

    private List<Pair<BigDecimal,BigDecimal>> distanceAndTime;

    public TaxiDistanceAndTime(List<Pair<BigDecimal, BigDecimal>> distanceAndTime) {
        this.distanceAndTime = distanceAndTime;
    }

    public List<Pair<BigDecimal, BigDecimal>> getDistanceAndTime() {
        return distanceAndTime;
    }

    public void setDistanceAndTime(List<Pair<BigDecimal, BigDecimal>> distanceAndTime) {
        this.distanceAndTime = distanceAndTime;
    }
}
