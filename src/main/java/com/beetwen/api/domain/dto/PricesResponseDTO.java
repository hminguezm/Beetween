package com.beetwen.api.domain.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Setter;

import java.util.Date;
import java.util.Objects;

@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PricesResponseDTO {
    @JsonProperty("productId")
    private Long productId;
    @JsonProperty("brandId")
    private Long brandId;
    @JsonProperty("priceList")
    private Integer priceList;
    @JsonProperty("startDate")
    private Date startDate;
    @JsonProperty("endDate")
    private Date endDate;
    @JsonProperty("price")
    private double price;

    public PricesResponseDTO(
            Long productId,
            Long brandId,
            Integer priceList,
            Date startDate,
            Date endDate,
            double price) {
        this.productId = productId;
        this.brandId = brandId;
        this.priceList = priceList;
        this.startDate = startDate;
        this.endDate = endDate;
        this.price = price;
    }

    @Override
    public String toString() {
        return "PricesResponseDTO{" +
                "productId=" + productId +
                ", brandId=" + brandId +
                ", priceList=" + priceList +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", price=" + price +
                '}';
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PricesResponseDTO that = (PricesResponseDTO) o;
        return Double.compare(that.price, price) == 0 &&
                Objects.equals(productId, that.productId) &&
                Objects.equals(brandId, that.brandId) &&
                Objects.equals(priceList, that.priceList) &&
                Objects.equals(startDate, that.startDate) &&
                Objects.equals(endDate, that.endDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId, brandId, priceList, startDate, endDate, price);
    }
}
