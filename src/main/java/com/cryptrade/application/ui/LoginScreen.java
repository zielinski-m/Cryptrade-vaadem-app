package com.cryptrade.application.ui;

import com.cryptrade.application.authentication.AccessControl;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.login.LoginForm;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.FlexLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.cryptrade.application.authentication.AccessControlFactory;


@Route("")
@PageTitle("Login")
public class LoginScreen extends FlexLayout {

    private final AccessControl accessControl;

    public LoginScreen() {
        accessControl = AccessControlFactory.getInstance().createAccessControl();
        buildUI();
    }

    private void buildUI() {
        setSizeFull();
        setClassName("login-screen");

        LoginForm loginForm = new LoginForm();
        loginForm.addLoginListener(this::login);
        loginForm.addForgotPasswordListener(
                event -> Notification.show("username: admin, password: admin"));

        FlexLayout centeringLayout = new FlexLayout();
        centeringLayout.setSizeFull();
        centeringLayout.setJustifyContentMode(JustifyContentMode.CENTER);
        centeringLayout.setAlignItems(Alignment.CENTER);
        centeringLayout.add(loginForm);

        Component loginInformation = buildLoginInformation();
        add(loginInformation);
        add(centeringLayout);
    }

    private Component buildLoginInformation() {
        VerticalLayout loginInformation = new VerticalLayout();
        FlexLayout centerInfo = new FlexLayout();
        loginInformation.setClassName("login-information");

        H1 loginInfoHeader = new H1("Login Information");
        centerInfo.add(loginInfoHeader);
        loginInfoHeader.setWidth("80%");
        Span loginInfoText = new Span(
                "Log in as \"admin\" to have an access. The password is same as the username.");
        loginInfoText.setWidth("80%");
        loginInformation.add(loginInfoHeader);
        loginInformation.add(loginInfoText);

        return loginInformation;
    }

    private void login(LoginForm.LoginEvent event) {
        if (accessControl.signIn(event.getUsername(), event.getPassword())) {
            getUI().get().navigate("http://localhost:8080/dash");
        }
    }
}
