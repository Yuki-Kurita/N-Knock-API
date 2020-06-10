package com.good.tyotto.nknock.api.repository;

import com.good.tyotto.nknock.api.domain.Knock;

public interface KnockRepository {

    /**
     * ノック
     * @param knock 追加するノック
     */
    void add(Knock knock);
}
