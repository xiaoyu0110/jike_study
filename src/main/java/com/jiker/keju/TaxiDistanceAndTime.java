package com.jiker.keju;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaxiDistanceAndTime {

    private static final Pattern pattern = Pattern.compile("\\d+");

    public static List<Pair<BigDecimal,BigDecimal>> getDistanceAndTimeInString(List<String> strings){
        List<Pair<BigDecimal,BigDecimal>> listPair = new ArrayList<>();
        strings.stream().forEach(text -> {
            listPair.add(getJourneyAndTime(text));
        } );
        return listPair;
    }

    private static Pair<BigDecimal, BigDecimal> getJourneyAndTime(String textLine){
        Matcher matcher = pattern.matcher(textLine);
        BigDecimal left = getBigDecimal(matcher);;
        BigDecimal right = getBigDecimal(matcher);;
        return new Pair<>(left,right);
    }

    private static BigDecimal getBigDecimal(Matcher matcher) {
        if (matcher.find()) {
            return new BigDecimal(matcher.group());
        }
        return null;
    }

}
