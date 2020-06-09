package com.good.tyotto.nknock.api.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import java.time.LocalDateTime;

/**
 * ノックリストを表すドメインオブジェクト
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class KnockList {

    /**
     * ノックリストID
     */
    private int knockListId;

    /**
     * ノックリスト名
     */
    private String knockListName;

    /**
     * 概要
     */
    private String overview;

    /**
     * タグ
     */
    private String tag;

    /**
     * Fire id
     */
    private String fireId;

    /**
     * 最終更新日時
     */
    private LocalDateTime updatedAt;

    /**
     * 削除フラグ
     */
    private Boolean deleteFlag;

    public int getKnockListId() {
        return knockListId;
    }

    public void setKnockListId(int knockListId) {
        this.knockListId = knockListId;
    }

    public String getKnockListName() {
        return knockListName;
    }

    public void setKnockListName(String knockListName) {
        this.knockListName = knockListName;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getFireId() {
        return fireId;
    }

    public void setFireId(String fireId) {
        this.fireId = fireId;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Boolean getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Boolean deleteFlag) {
        this.deleteFlag = deleteFlag;
    }
}
