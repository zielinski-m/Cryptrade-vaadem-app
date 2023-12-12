package com.cryptrade.application.service;

import com.cryptrade.application.controller.CryptocurrencyNotFoundException;
import com.cryptrade.application.domain.Cryptocurrency;
import com.cryptrade.application.repository.CryptocurrencyRepository;
import com.vaadin.flow.data.provider.DataProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DbService {

    private final CryptocurrencyRepository cryptocurrencyRepository;

    public List<Cryptocurrency> getAllCryptocurrencies() {
        return cryptocurrencyRepository.findAll();
    }

    public Cryptocurrency getCryptocurrency(final Long cryptocurrencyId) throws CryptocurrencyNotFoundException {
        return cryptocurrencyRepository.findById(cryptocurrencyId).orElseThrow(CryptocurrencyNotFoundException::new);
    }

    public Cryptocurrency saveCryptocurrency(final Cryptocurrency cryptocurrency) {
        return cryptocurrencyRepository.save(cryptocurrency);
    }

    public void deleteCryptocurrency(final Long cryptocurrencyId) {
        cryptocurrencyRepository.deleteCryptocurrencyById(cryptocurrencyId);
    }
}
