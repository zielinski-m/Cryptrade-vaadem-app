package com.cryptrade.application.controller;

import com.cryptrade.application.domain.Cryptocurrency;
import com.cryptrade.application.domain.CryptocurrencyDto;
import com.cryptrade.application.mapper.CryptocurrencyMapper;
import com.cryptrade.application.service.DbService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin("*")
@RequestMapping("/v1/crypto")
@RequiredArgsConstructor
public class CryptocurrencyController {

    @Autowired
    private final DbService dbService;
    private final CryptocurrencyMapper cryptocurrencyMapper;

    @GetMapping
    public ResponseEntity<List<CryptocurrencyDto>> getCryptocurrencies() {
        List<Cryptocurrency> cryptocurrencies = dbService.getAllCryptocurrencies();
        return ResponseEntity.ok(cryptocurrencyMapper.mapToCryptocurrencyDtoList(cryptocurrencies));
    }

    @GetMapping(value = "/{cryptocurrencyId}")
    public ResponseEntity<CryptocurrencyDto> getCryptocurrency(@PathVariable Long cryptocurrencyId) throws CryptocurrencyNotFoundException {
        return ResponseEntity.ok(cryptocurrencyMapper.mapToCryptocurrencyDto(dbService.getCryptocurrency(cryptocurrencyId)));
    }

    @PutMapping
    public ResponseEntity<CryptocurrencyDto> updateCryptocurrency(@RequestBody CryptocurrencyDto cryptocurrencyDto) {
        Cryptocurrency cryptocurrency = cryptocurrencyMapper.mapToCryptocurrency(cryptocurrencyDto);
        Cryptocurrency savedCryptocurrency = dbService.saveCryptocurrency(cryptocurrency);
        return ResponseEntity.ok(cryptocurrencyMapper.mapToCryptocurrencyDto(savedCryptocurrency));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CryptocurrencyDto> postCryptocurrency(@RequestBody CryptocurrencyDto cryptocurrencyDto) {
        Cryptocurrency cryptocurrency = cryptocurrencyMapper.mapToCryptocurrency(cryptocurrencyDto);
        dbService.saveCryptocurrency(cryptocurrency);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping(value = "/{cryptocurrencyId}")
    public ResponseEntity<CryptocurrencyDto> deleteCryptocurrency(@PathVariable Long cryptocurrencyId) {
        dbService.deleteCryptocurrency(cryptocurrencyId);
        return ResponseEntity.ok().build();
    }
}