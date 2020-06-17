package com.good.tyotto.nknock.api.service;

import com.good.tyotto.nknock.api.domain.Knock;
import com.good.tyotto.nknock.api.domain.KnockGroup;
import com.good.tyotto.nknock.api.domain.KnockSelector;

public interface KnockService {

    /**
     * ノックを検索
     * @param selector 検索条件
     * @return 対象のノック
     */
    KnockGroup find(KnockSelector selector);

    /**
     * ノックを追加
     * @param knock 追加するノック
     */
    void add(Knock knock);

    /**
     * ノックを更新
     * @param knock 更新するノック
     */
    void set(Knock knock);

    /**
     * ノックを削除
     * @param knockListId 削除する対象のノックのノックリストID
     */
    void remove(int knockListId);
}
