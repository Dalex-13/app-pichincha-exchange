package com.pichincha.service.exchange.repository;

import com.pichincha.service.exchange.model.entity.CurrencyExchange;
import io.reactivex.rxjava3.core.Flowable;
import org.springframework.data.repository.reactive.RxJava3CrudRepository;

public interface ExchangeRepository extends RxJava3CrudRepository<CurrencyExchange, Long> {
    Flowable<CurrencyExchange> findByUserId(Integer userId);
}
