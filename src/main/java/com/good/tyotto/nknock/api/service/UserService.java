package com.good.tyotto.nknock.api.service;

import com.good.tyotto.nknock.api.domain.User;
import com.good.tyotto.nknock.api.domain.UserSelector;

/**
 * Userドメインオブジェクトに関する処理を行うモジュールを表すインタフェース
 */
public interface UserService {

    /**
     * クエリパラメータ(email)によるユーザ参照処理
     *
     * @param selector 検索条件
     * @return 条件に合致したUserデータ
     */
    public User find(UserSelector selector);

    public void add(User user);
}
