package com.pichincha.service.expose.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ExchangeResponse {
    private Integer userId;
    private Double amount;
    private String sourceCurrency;
    private String targetCurrency;
    private Double convertedAmount;
    private Double exchangeRate;
    private LocalDateTime createdAt;
}
