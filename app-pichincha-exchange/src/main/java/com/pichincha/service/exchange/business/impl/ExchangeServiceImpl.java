package com.pichincha.service.exchange.business.impl;

import com.pichincha.service.exchange.business.ExchangeService;
import com.pichincha.service.exchange.business.mapper.ExchangeMapper;
import com.pichincha.service.exchange.repository.ExchangeRepository;
import com.pichincha.service.expose.dto.request.ExchangeRequest;
import com.pichincha.service.expose.dto.request.ExchangeUpdateRequest;
import com.pichincha.service.expose.dto.response.ExchangeResponse;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.Single;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class ExchangeServiceImpl implements ExchangeService {

    private final ExchangeRepository exchangeRepository;
    private final ExchangeMapper exchangeMapper;

    @Override
    public Completable createExchange(ExchangeRequest exchangeRequest) {
        return exchangeRepository.save(exchangeMapper.toEntity(exchangeRequest)).ignoreElement();
    }

    @Override
    public Completable updateExchange(Long id, ExchangeUpdateRequest exchangeUpdateRequest) {
        return exchangeRepository.findById(id)
                .switchIfEmpty(Maybe.defer(() -> {
                    throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No se encontró registro");
                }))
                .flatMapCompletable(currencyExchange ->
                        exchangeRepository
                                .save(exchangeMapper.toUpdate(currencyExchange, exchangeUpdateRequest))
                                .ignoreElement());
    }

    @Override
    public Flowable<ExchangeResponse> listExchangeByUserId(Integer userId) {
        return exchangeRepository.findByUserId(userId)
                .switchIfEmpty(Flowable.defer(() -> {
                    throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No se encontró registro");
                }))
                .map(exchangeMapper::toResponse);
    }

    @Override
    public Single<ExchangeResponse> getExchangeById(Long id) {
        return exchangeRepository.findById(id)
                .switchIfEmpty(Single.defer(() -> {
                    throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No se encontró registro");
                }))
                .map(exchangeMapper::toResponse);
    }
}