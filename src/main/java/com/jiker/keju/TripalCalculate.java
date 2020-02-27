package com.jiker.keju;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

public class TripalCalculate {
    private static final BigDecimal TAXI_START_DISTENCE = new BigDecimal("2");
    private static final BigDecimal TAXI_FARE = new BigDecimal("6");
    private static final BigDecimal UNIT_PRICE = new BigDecimal("0.8");
    private static final BigDecimal TAXI_OVER__DISTENCE = new BigDecimal("8");
    private static final BigDecimal OVERTIME_FARE = new BigDecimal("1.2");
    private static final BigDecimal WAITING_UNIT_PRICE = new BigDecimal("0.25");

    public String calculateTaxiFree(String filePath) throws NoSuchFieldException, IOException {
        final List<String> fileContent = FileAnalys.getFileContent(filePath);
        final List<Pair<BigDecimal, BigDecimal>> distanceAndTime = TaxiDistanceAndTime.getDistanceAndTimeInString(fileContent);
        String totalFree = "";
        String reduce = distanceAndTime.stream().reduce(totalFree,
                (string, pair) -> {
                    BigDecimal free = calculate(pair.getLeft()).add(calculateWaitingFree(pair.getRight())).setScale(0, BigDecimal.ROUND_HALF_UP);
                    return string + "收费" + free.toString() + "元\n";
                }, (s1, s2) -> { return "";});
        return reduce;
    };

    public BigDecimal calculate(BigDecimal distance) {
        if(distance == null ) return BigDecimal.ZERO;
        BigDecimal free = TAXI_FARE;
        if (distance.compareTo(TAXI_START_DISTENCE) > 0){
            BigDecimal calculateDistence = distance.compareTo(TAXI_OVER__DISTENCE)<=0 ? distance : TAXI_OVER__DISTENCE;
            free = free.add(calculateDistence.subtract(TAXI_START_DISTENCE).multiply(UNIT_PRICE));
        }
        if (distance.compareTo(TAXI_OVER__DISTENCE) > 0){
            free = free.add(distance.subtract(TAXI_OVER__DISTENCE).multiply(OVERTIME_FARE));
        }
        return free;
    }

    public BigDecimal calculateWaitingFree(BigDecimal waitingTime) {
        if(waitingTime == null ) return BigDecimal.ZERO;
        return WAITING_UNIT_PRICE.multiply(waitingTime);
    }
}
