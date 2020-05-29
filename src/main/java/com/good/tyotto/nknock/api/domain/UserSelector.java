package com.good.tyotto.nknock.api.domain;

/**
 * ユーザの検索条件を格納するドメインオブジェクト
 */
public class UserSelector {

    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
