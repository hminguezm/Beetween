package com.beetwen.api.application.useCase.interfaces;

import com.beetwen.api.domain.dto.PricesResponseDTO;

import java.text.ParseException;

public interface IGetPrices {
    PricesResponseDTO getPrices(Long brandId, Long productId, String applyDate) throws ParseException;
}
