package com.cryptrade.application.domain;

import com.vaadin.flow.router.HasUrlParameter;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import com.vaadin.flow.component.HasValue;


@NoArgsConstructor
@Getter
@AllArgsConstructor
@Entity(name = "cryptocurrencies")
public abstract class Cryptocurrency implements HasUrlParameter<String> {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "symbol")
    private String symbol;

    @Column(name = "price")
    private Long price;

    @Column(name = "market_cap")
    private Long marketCap;

    @Column(name = "other_info")
    private String otherInfo;

    public boolean isNewProduct() {
        return false;
    }
}

