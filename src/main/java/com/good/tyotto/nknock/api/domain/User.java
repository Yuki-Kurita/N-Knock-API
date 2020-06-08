package com.good.tyotto.nknock.api.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import java.time.LocalDateTime;

/**
 * ユーザを表すドメインオブジェクト
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class User {

    /**
     * ユーザID
     */
    private int userId;

    /**
     * メールアドレス
     */
    private String email;

    /**
     * Firebaseでのユーザ固有ID
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

    /**
     * 管理者フラグ
     */
    private Boolean adminFlag;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFireId() {
        return fireId;
    }

    public void setFireId(String fireId) {
        this.fireId= fireId;
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

    public Boolean getAdminFlag() {
        return adminFlag;
    }

    public void setAdminFlag(Boolean adminFlag) {
        this.adminFlag = adminFlag;
    }
}
