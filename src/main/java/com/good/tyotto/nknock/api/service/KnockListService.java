package com.good.tyotto.nknock.api.service;

import com.good.tyotto.nknock.api.domain.KnockList;
import com.good.tyotto.nknock.api.domain.KnockListGroup;
import com.good.tyotto.nknock.api.domain.KnockListSelector;
import com.good.tyotto.nknock.api.domain.TagList;

public interface KnockListService {

    /**
     * ノックリスト全件参照処理
     * @return 全てのノックリスト
     */
    KnockListGroup findAll();

    /**
     * 条件指定による複数件参照処理
     * @param selector 検索条件
     * @return 条件に合致したノックリスト
     */
    KnockListGroup find(KnockListSelector selector);

    /**
     * タグを全件取得する
     * @return 全てのタグ名とID
     */
    TagList findTag();

    /**
     * 最新のノックリストIDを取得する
     * @return 最新ノックリストID
     */
    int getLatestId();

    /**
     * ノックリストを追加
     * @param knockList 追加するノックリスト
     */
    void add(KnockList knockList);

    /**
     * ノックリストを編集
     * @param knockList 編集するノックリスト
     */
    void set(KnockList knockList);

    /**
     * ノックリストを削除
     * @param knockListId 削除するノックリストのID
     */
    void remove(int knockListId);
}
