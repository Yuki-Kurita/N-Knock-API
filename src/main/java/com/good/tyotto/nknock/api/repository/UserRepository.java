package com.good.tyotto.nknock.api.repository;

import com.good.tyotto.nknock.api.domain.User;
import com.good.tyotto.nknock.api.domain.UserSelector;

/**
 * Userドメインオブジェクトをデータストアに格納、検索するモジュールを表すインタフェース。
 */
public interface UserRepository {

    /**
     * クエリパラメータによる1件参照処理
     *
     * @param selector 検索条件
     * @return 指定されたemailのUserデータ
     */
    User find(UserSelector selector);

    /**
     * Userの新規登録処理。
     *
     * @param user 登録内容
     */
    void insert(User user);
}
