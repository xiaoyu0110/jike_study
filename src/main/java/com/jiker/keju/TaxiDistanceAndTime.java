package com.jiker.keju;

import java.math.BigDecimal;
import java.util.List;

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
