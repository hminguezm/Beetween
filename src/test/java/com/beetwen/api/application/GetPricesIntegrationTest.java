package com.beetwen.api.application;

import com.beetwen.api.application.useCase.GetPricesUseCase;
import com.beetwen.api.domain.dto.PricesResponseDTO;
import com.beetwen.api.domain.repository.PriceRepository;
import com.beetwen.shared.domain.utils.DateFormatter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class GetPricesIntegrationTest {

    @Autowired
    private GetPricesUseCase getPricesUseCase;

    @Autowired
    private PriceRepository priceRepository;

    @BeforeEach
    void setUp() {}

    @Test
    @DisplayName("Integration Test with Database")
    void integrationTestWithDatabase() throws ParseException {

    }

    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Test
    @DisplayName("Test 1: 10:00 del día 14")
    void testAt10AMOnDay14() throws ParseException {
        Date start = formatter.parse("2020-06-14 00:00:00");
        Date end = formatter.parse("2020-12-31 23:59:59");
        PricesResponseDTO expectedResult = new PricesResponseDTO(
                35455L,
                1L,
                1,
                start,
                end,
                35.5
        );
        performTest("2020-06-14T10:00:00", expectedResult);
    }

    @Test
    @DisplayName("Test 2: 16:00 del día 14")
    void testAt4PMOnDay14() throws ParseException {
        Date start = formatter.parse("2020-06-14 15:00:00");
        Date end = formatter.parse("2020-06-14 18:30:00");
        PricesResponseDTO expectedResult = new PricesResponseDTO(
                35455L,
                1L,
                2,
                start,
                end,
                25.45
        );
        performTest("2020-06-14T16:00:00", expectedResult);
    }

    @Test
    @DisplayName("Test 3: 21:00 del día 14")
    void testAt9PMOnDay14() throws ParseException {
        Date start = formatter.parse("2020-06-14 00:00:00");
        Date end = formatter.parse("2020-12-31 23:59:59");
        PricesResponseDTO expectedResult = new PricesResponseDTO(
                35455L,
                1L,
                1,
                start,
                end,
                35.5
        );
        performTest("2020-06-14T21:00:00", expectedResult);
    }

    @Test
    @DisplayName("Test 4: 10:00 del día 15")
    void testAt10AMOnDay15() throws ParseException {
        Date start = formatter.parse("2020-06-15 00:00:00");
        Date end = formatter.parse("2020-06-15 11:00:00");
        PricesResponseDTO expectedResult = new PricesResponseDTO(
                35455L,
                1L,
                3,
                start,
                end,
                30.5
        );
        performTest("2020-06-15T10:00:00", expectedResult);
    }

    @Test
    @DisplayName("Test 5: 21:00 del día 16")
    void testAt9PMOnDay16() throws ParseException {
        Date start = formatter.parse("2020-06-15 16:00:00");
        Date end = formatter.parse("2020-12-31 23:59:59");
        PricesResponseDTO expectedResult = new PricesResponseDTO(
                35455L,
                1L,
                4,
                start,
                end,
                38.95
        );
        performTest("2020-06-16T21:00:00", expectedResult);
    }

    @Test
    @DisplayName("Integration Test with Database - Missing Data")
    void testMissingData() throws ParseException {
        String applyDate = "2021-08-13T10:00:00";
        String dateFormatter = DateFormatter.formatter(applyDate);

        PricesResponseDTO result = getPricesUseCase.getPrices(null, null, dateFormatter);

        assertThat(result).isNull();
    }


    private void performTest (String date, PricesResponseDTO expectedResult) throws ParseException {
        Long brandId = 1L;
        Long productId = 35455L;
        String dateFormatter = DateFormatter.formatter(date);
        PricesResponseDTO result = getPricesUseCase.getPrices(brandId, productId, dateFormatter);

        assertEquals(expectedResult, result);
    }
}
