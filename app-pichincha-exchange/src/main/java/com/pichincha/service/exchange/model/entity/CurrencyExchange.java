package com.pichincha.service.exchange.model.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@Table(name = "Currency_exchange")
@Getter
@Setter
@Builder
public class CurrencyExchange {
    @Id
    @Column("exchange_id")
    private Long id;
    @Column
    private Integer userId;
    @Column
    private Double amount;
    @Column
    private String sourceCurrency;
    @Column
    private String targetCurrency;
    @Column
    private Double convertedAmount;
    @Column
    private Double exchangeRate;
    @Column
    private LocalDateTime createdAt;
}
