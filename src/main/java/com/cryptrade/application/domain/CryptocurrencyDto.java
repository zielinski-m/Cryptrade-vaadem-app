package com.cryptrade.application.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CryptocurrencyDto {

    private Long id;
    private String name;
    private String symbol;
    private Long price;
    private Long marketCap;
    private String otherInfo;

    public static CryptocurrencyDto fromCryptocurrency(Cryptocurrency cryptocurrency) {
        return new CryptocurrencyDto(
                cryptocurrency.getId(),
                cryptocurrency.getName(),
                cryptocurrency.getSymbol(),
                cryptocurrency.getPrice(),
                cryptocurrency.getMarketCap(),
                cryptocurrency.getOtherInfo()
        );
    }

    public static List<CryptocurrencyDto> fromCryptocurrencies(List<Cryptocurrency> cryptocurrencies) {
        return cryptocurrencies.stream()
                .map(CryptocurrencyDto::fromCryptocurrency)
                .toList();
    }
}
