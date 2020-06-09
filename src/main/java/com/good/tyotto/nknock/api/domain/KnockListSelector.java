package com.good.tyotto.nknock.api.domain;

/**
 * ノックリストの検索条件を格納するドメインオブジェクト
 */
public class KnockListSelector {

    private String fireId;

    private int tagId;

    private String knockListName;

    public String getFireId() {
        return fireId;
    }

    public void setFireId(String fireId) {
        this.fireId = fireId;
    }

    public int getTag() {
        return tagId;
    }

    public void setTagId(int tagId) {
        this.tagId = tagId;
    }

    public String getKnockListName() {
        return knockListName;
    }

    public void setKnockListName(String knockListName) {
        this.knockListName = knockListName;
    }
}
