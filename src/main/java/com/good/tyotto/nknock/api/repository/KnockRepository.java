package com.good.tyotto.nknock.api.repository;

import com.good.tyotto.nknock.api.domain.Knock;
import com.good.tyotto.nknock.api.domain.KnockSelector;
import java.util.List;

public interface KnockRepository {

    /**
     * ノックリストIDからノックを取得する
     * @param selector ノックの検索条件
     * @return 条件にマッチするノック
     */
    List<Knock> find(KnockSelector selector);

    /**
     * ノックを追加する
     * @param knock 追加するノック
     */
    void add(Knock knock);

    /**
     * ノックを編集する
     * @param knock 編集するノック
     */
    void set(Knock knock);

    /**
     * ノックを削除する
     * @param knockListId 削除するノックのノックリストID
     */
    void remove(int knockListId);
}
