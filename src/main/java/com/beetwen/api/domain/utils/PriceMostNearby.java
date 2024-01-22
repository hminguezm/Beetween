package com.beetwen.api.domain.utils;

import com.beetwen.api.domain.entity.Price;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class PriceMostNearby {

    public static Price priceMostNearby(String search, List<Price> prices) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        Date searchDate = dateFormat.parse(search);

        Price bestMatch = null;
        long minorDifference = Long.MAX_VALUE;

        for (Price fila : prices) {
            Date startDate = fila.getStartDate();
            Date endDate = fila.getEndDate();

            long startDifference = Math.abs(startDate.getTime() - searchDate.getTime());
            long endDifference = Math.abs(endDate.getTime() - searchDate.getTime());

            if (startDifference < minorDifference || endDifference < minorDifference) {
                minorDifference = Math.min(startDifference, endDifference);
                bestMatch = fila;
            }
        }

        return bestMatch;
    }
}

