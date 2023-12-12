package com.cryptrade.application.mapper;

import com.cryptrade.application.domain.Cryptocurrency;
import com.cryptrade.application.domain.CryptocurrencyDto;
import com.vaadin.flow.router.BeforeEvent;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CryptocurrencyMapper {

    public Cryptocurrency mapToCryptocurrency(final CryptocurrencyDto cryptocurrencyDto) {
        return new Cryptocurrency(
                cryptocurrencyDto.getId(),
                cryptocurrencyDto.getName(),
                cryptocurrencyDto.getSymbol(),
                cryptocurrencyDto.getPrice(),
                cryptocurrencyDto.getMarketCap(),
                cryptocurrencyDto.getOtherInfo()
        ) {
            @Override
            public void setParameter(BeforeEvent event, String parameter) {

            }
        };
    }

    public CryptocurrencyDto mapToCryptocurrencyDto(final Cryptocurrency cryptocurrency) {
        return new CryptocurrencyDto(
                cryptocurrency.getId(),
                cryptocurrency.getName(),
                cryptocurrency.getSymbol(),
                cryptocurrency.getPrice(),
                cryptocurrency.getMarketCap(),
                cryptocurrency.getOtherInfo()
        );
    }

    public List<CryptocurrencyDto> mapToCryptocurrencyDtoList(List<Cryptocurrency> cryptocurrencies) {
        return cryptocurrencies.stream()
                .map(this::mapToCryptocurrencyDto)
                .toList();
    }
}
