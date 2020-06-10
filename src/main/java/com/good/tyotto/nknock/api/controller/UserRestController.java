package com.good.tyotto.nknock.api.controller;

import com.good.tyotto.nknock.api.domain.User;
import com.good.tyotto.nknock.api.domain.UserSelector;
import com.good.tyotto.nknock.api.service.UserService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Userに関する操作を行うRestful Web APIコントローラー実装
 */
@RestController
@RequestMapping("users")
public class UserRestController {

    private final UserService service;

    public UserRestController(UserService service)  {
        this.service = service;
    }

    /**
     * ユーザ情報を取得する
     * @param selector メールアドレスの入ったセレクタ
     * @return ユーザ情報
     */
    @CrossOrigin(origins = {"http://localhost:8081"})
    @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public User find(UserSelector selector) {
        return this.service.find(selector);
    }

    /**
     * ユーザ情報を追加する
     * @param user ユーザ
     */
    @CrossOrigin(origins = {"http://localhost:8081"})
    @PostMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public void add(@RequestBody User user) {
        this.service.add(user);
    }

    /**
     * ユーザ情報を更新する
     * @param user ユーザ情報
     */
    @CrossOrigin(origins = {"http://localhost:8081"})
    @PatchMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public void updateUserName(@RequestBody User user) {
        this.service.updateUserName(user);
    }
}
