DROP TABLE IF EXISTS currency_exchange;

CREATE TABLE Currency_exchange
(
    exchange_id      INT AUTO_INCREMENT PRIMARY KEY,
    user_id          INT                      NOT NULL,
    amount           DECIMAL(10, 2)           NOT NULL, -- monto
    source_currency  VARCHAR(3)               NOT NULL, -- moneda de origen
    target_currency  VARCHAR(3)               NOT NULL, -- moneda de destino
    converted_amount DECIMAL(10, 2),                    -- monto con el tipo de campo
    exchange_rate    DECIMAL(10, 4)           NOT NULL, -- el tipo de cambio
    created_at       TIMESTAMP WITH TIME ZONE NOT NULL
);