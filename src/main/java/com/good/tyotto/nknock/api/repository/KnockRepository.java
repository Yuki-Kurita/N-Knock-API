package com.good.tyotto.nknock.api.repository;

import com.good.tyotto.nknock.api.domain.Knock;
import com.good.tyotto.nknock.api.domain.KnockGroup;
import com.good.tyotto.nknock.api.domain.KnockSelector;

public interface KnockRepository {

    /**
     * ノックリストIDからノックを取得する
     * @param selector ノックの検索条件
     * @return 条件にマッチするノック
     */
    KnockGroup find(KnockSelector selector);

    /**
     * ノックを追加する
     * @param knock 追加するノック
     */
    void add(Knock knock);
}
