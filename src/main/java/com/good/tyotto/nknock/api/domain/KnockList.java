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
    private String tagName;

    /**
     * タグID
     */
    private int tagId;

    /**
     * Firebase id
     */
    private String fireId;

    /**
     * ユーザ名
     */
    private String userName;

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

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    public int getTagId() {
        return tagId;
    }

    public void setTagId(int tagId) {
        this.tagId = tagId;
    }

    public String getFireId() {
        return fireId;
    }

    public void setFireId(String fireId) {
        this.fireId = fireId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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
