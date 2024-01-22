package com.beetwen.api.domain.repository;

import com.beetwen.api.domain.entity.Price;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Repository
public interface PriceRepository extends JpaRepository<Price, UUID> {
    @Query("SELECT p FROM Price p " +
            "WHERE p.brandId = ?1 " +
            "AND p.productId = ?2 " +
            "AND ?3 BETWEEN p.startDate AND p.endDate"
    )
    List<Price> getPrices(Long brandId, Long productId, LocalDateTime applyDate);
}
