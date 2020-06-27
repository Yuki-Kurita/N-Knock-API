package com.good.tyotto.nknock.api.repository;

import com.good.tyotto.nknock.api.domain.Knock;
import com.good.tyotto.nknock.api.domain.KnockList;
import com.good.tyotto.nknock.api.domain.KnockListSelector;
import com.good.tyotto.nknock.api.domain.Tag;
import java.util.List;

/**
 * KnockListドメインオブジェクトをデータストアに格納、検索するモジュールを表すインタフェース。
 */
public interface KnockListRepository {

    /**
     * 全件取得
     * @return 全てのノックリスト
     */
    List<KnockList> findAll();

    /**
     * 条件に一致するノックリストを取得
     * @param selecor FireId
     * @return 条件に合致するノックリスト
     */
    List<KnockList> find(KnockListSelector selecor);

    /**
     * 全てのタグを取得
     * @return 全てのタグ
     */
    List<Tag> findTag();

    /**
     * 最新のノックリストIDを取得する
     * @return
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
     * @param knockListId 削除するノックリストのId
     */
    void remove(int knockListId);
}
