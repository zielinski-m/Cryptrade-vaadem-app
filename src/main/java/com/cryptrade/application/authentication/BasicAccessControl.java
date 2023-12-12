package com.cryptrade.application.authentication;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.server.VaadinServletRequest;
import com.vaadin.flow.server.VaadinSession;
public class BasicAccessControl implements AccessControl {

    @Override
    public boolean signIn(String username, String password) {
        if (username == null || username.isEmpty()) {
            return false;
        }

        if (!username.equals(password)) {
            return false;
        }

        VaadinServletRequest.getCurrent().getHttpServletRequest()
                .changeSessionId();
        CurrentUser.set(username);
        return true;
    }

    @Override
    public boolean isUserSignedIn() {
        return !CurrentUser.get().isEmpty();
    }

    @Override
    public String getName() {
        return CurrentUser.get();
    }

    @Override
    public void signOut() {
        VaadinSession.getCurrent().getSession().invalidate();
        UI.getCurrent().navigate("http://localhost:8080");
    }
}
