package com.beetwen.api.application.useCase.interfaces;

import com.beetwen.api.domain.entity.Price;
import lombok.NonNull;

public interface IPricesAdd {
    Price add(@NonNull  Price price);
}
