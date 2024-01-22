package com.beetwen.api.infrastructure.controller;

import com.beetwen.api.application.useCase.GetPricesUseCase;
import com.beetwen.api.domain.dto.PricesResponseDTO;
import com.beetwen.shared.domain.utils.DateFormatter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.HashMap;

@RestController
public class GetPricesController {

    private final GetPricesUseCase useCase;

    public GetPricesController(GetPricesUseCase useCase) {
        this.useCase = useCase;
    }

    @GetMapping(value = "/prices", produces = { "application/json", "application/xml" })
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public ResponseEntity<Object> getPrices(@RequestParam Long brandId, @RequestParam Long productId, @RequestParam String applyDate) {
        try {
            String dateFormatter = DateFormatter.formatter(applyDate);
            PricesResponseDTO useCaseResponse = this.useCase.getPrices(brandId, productId, dateFormatter);

            return ResponseEntity.ok(useCaseResponse == null ? new HashMap<>() : useCaseResponse);
        } catch (RuntimeException e) {
            System.out.println("Error: " + e.getMessage());
            throw e;
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
}
