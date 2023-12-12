package com.cryptrade.application.ui;

import com.cryptrade.application.domain.Cryptocurrency;
import com.cryptrade.application.service.DbService;
import com.helger.commons.system.CryptoPolicy;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.data.provider.ListDataProvider;
import com.vaadin.flow.router.Route;
import lombok.Getter;

import java.util.Arrays;

@Getter
@Route(value = "/dash")
public class Dashboard extends HorizontalLayout {

    private LoginScreen login;
    private DbService dbService;

    public Dashboard() {
        initializeUI();
    }

    public Dashboard(LoginScreen login) {
        this.login = login;
        initializeUI();
    }

    private void initializeUI() {
        setSizeFull();

        final HorizontalLayout topLayout = createTopBar();
        final VerticalLayout gridLayout = createGridLayout();

        add(topLayout, gridLayout);
    }

    private HorizontalLayout createTopBar() {
        final HorizontalLayout topLayout = new HorizontalLayout();
        topLayout.setWidth("100%");

        final Span title = new Span("Dashboard");
        title.setWidth("100%");
        topLayout.add(title);

        return topLayout;
    }

    private VerticalLayout createGridLayout() {
        final VerticalLayout gridLayout = new VerticalLayout();
        gridLayout.setSizeFull();

        final Grid<String> grid = new Grid<>();
        grid.setItems("Cryptocurrencies");
        grid.addColumn(String::toString).setHeader("Column Header");
        gridLayout.add(grid);
        return gridLayout;
    }
}