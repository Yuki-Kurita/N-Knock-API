package com.good.tyotto.nknock.api.domain;

/**
 * ノックリストの検索条件を格納するドメインオブジェクト
 */
public class KnockListSelector {

    private String fireId;

    private String tag;

    private String knockListName;

    public String getFireId() {
        return fireId;
    }

    public void setFireId(String fireId) {
        this.fireId = fireId;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getKnockListName() {
        return knockListName;
    }

    public void setKnockListName(String knockListName) {
        this.knockListName = knockListName;
    }
}
