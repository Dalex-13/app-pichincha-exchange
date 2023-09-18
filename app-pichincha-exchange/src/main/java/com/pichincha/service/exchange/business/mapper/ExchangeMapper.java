package com.pichincha.service.exchange.business.mapper;

import com.pichincha.service.exchange.model.entity.CurrencyExchange;
import com.pichincha.service.exchange.util.enums.CurrencyEnum;
import com.pichincha.service.expose.dto.request.ExchangeRequest;
import com.pichincha.service.expose.dto.request.ExchangeUpdateRequest;
import com.pichincha.service.expose.dto.response.ExchangeResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.time.LocalDateTime;

@Mapper(componentModel = "spring", imports = {LocalDateTime.class, CurrencyEnum.class})
public interface ExchangeMapper {

    @Mapping(target = "createdAt", expression = "java(LocalDateTime.now())")
    CurrencyExchange toEntity(ExchangeRequest request);

    @Mapping(target = "amount", source = "request.amount")
    @Mapping(target = "sourceCurrency", source = "request.sourceCurrency")
    @Mapping(target = "targetCurrency", source = "request.targetCurrency")
    @Mapping(target = "convertedAmount", source = "request.convertedAmount")
    @Mapping(target = "exchangeRate", source = "request.exchangeRate")
    CurrencyExchange toUpdate(@MappingTarget CurrencyExchange currencyExchange, ExchangeUpdateRequest request);
    ExchangeResponse toResponse(CurrencyExchange currencyExchange);
}
