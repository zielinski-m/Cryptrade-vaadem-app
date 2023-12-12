package com.cryptrade.application.repository;

import com.cryptrade.application.domain.Cryptocurrency;

import jakarta.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CryptocurrencyRepository extends CrudRepository<Cryptocurrency, Long> {

    @Override
    List<Cryptocurrency> findAll();

    @Override
    Optional<Cryptocurrency> findById(Long id);

    @Override
    Cryptocurrency save(Cryptocurrency cryptocurrency);

    @Transactional
    Cryptocurrency deleteCryptocurrencyById(Long id);
}
