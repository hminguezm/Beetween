package com.beetwen.api.application.useCase;

import com.beetwen.api.application.useCase.interfaces.IGetPrices;
import com.beetwen.api.domain.dto.PricesResponseDTO;
import com.beetwen.api.domain.entity.Price;
import com.beetwen.api.domain.repository.PriceRepository;
import com.beetwen.api.domain.utils.PriceMostNearby;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.time.LocalDateTime;
import java.util.List;

@Service

public class GetPricesUseCase implements IGetPrices {
    private final PriceRepository priceRepository;
    public GetPricesUseCase(PriceRepository priceRepository){
        this.priceRepository = priceRepository;
    }

    @Override
    public PricesResponseDTO getPrices(Long brandId, Long productId, String applyDate) throws ParseException {

        List<Price> prices = this.priceRepository.getPrices(brandId, productId, LocalDateTime.parse(applyDate));

        if (prices.isEmpty()) {
            return null;
        }

        Price price = PriceMostNearby.priceMostNearby(applyDate, prices);

        return new PricesResponseDTO(
                price.getProductId(),
                price.getBrandId(),
                price.getPriceList(),
                price.getStartDate(),
                price.getEndDate(),
                price.getPrice()
        );
    }
}
