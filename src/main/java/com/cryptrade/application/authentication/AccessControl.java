package com.cryptrade.application.authentication;

import java.io.Serializable;

public interface AccessControl extends Serializable {

    String ADMIN_USERNAME = "admin";

    boolean signIn(String username, String password);

    boolean isUserSignedIn();

    String getName();

    void signOut();
}
