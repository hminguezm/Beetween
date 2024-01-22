package com.beetwen.api.application;

import com.beetwen.api.application.useCase.GetPricesUseCase;
import com.beetwen.api.domain.dto.PricesResponseDTO;
import com.beetwen.api.domain.entity.Price;
import com.beetwen.api.domain.repository.PriceRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.*;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class GetPricesUseCaseTest {
    @InjectMocks
    private GetPricesUseCase getPricesUseCase;

    @Mock
    private PriceRepository priceRepository;

    @BeforeEach
    void setUp() {
        priceRepository = mock(PriceRepository.class);
        getPricesUseCase = new GetPricesUseCase(priceRepository);

    }

    @Test
    @DisplayName("Expected value equal to actual value")
    void valueEqualToValue() throws ParseException {
        UUID id = UUID.fromString("45fd4e72-a659-49c7-8c5a-a65098966e92");
        Long brandId = 1L;
        Long productId = 35455L;
        String applyDate = "2020-06-14T10:00:00";

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date start = formatter.parse("2020-06-14 00:00:00");
        Date end = formatter.parse("2020-12-31 23:59:59");

        List<Price> prices = List.of(
                new Price(id, brandId, productId, 1, start, end, 35.5)
        );

        when(priceRepository.getPrices(brandId, productId, LocalDateTime.parse(applyDate))).thenReturn(prices);

        PricesResponseDTO result = getPricesUseCase.getPrices(brandId, productId, applyDate);
        PricesResponseDTO expectedResult = new PricesResponseDTO(
                productId,
                brandId,
                1,
                start,
                end,
                35.5
        );
        assertEquals(expectedResult, result);
    }

    @Test
    public void testGetPrices_NoPrices() throws ParseException {
        Mockito.when(priceRepository.getPrices(any(), any(), any()))
                .thenReturn(List.of());
        PricesResponseDTO result = getPricesUseCase.getPrices(1L, 2L, String.valueOf(LocalDateTime.parse("2022-01-21T12:00:00")));
        assertNull(result);
    }
}