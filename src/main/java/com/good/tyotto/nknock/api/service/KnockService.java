package com.good.tyotto.nknock.api.service;

import com.good.tyotto.nknock.api.domain.Knock;

public interface KnockService {

    /**
     * ノックを追加
     * @param knock 追加するノック
     */
    void add(Knock knock);
}
