package com.good.tyotto.nknock.api.controller;

import com.good.tyotto.nknock.api.domain.User;
import com.good.tyotto.nknock.api.domain.UserSelector;
import com.good.tyotto.nknock.api.service.UserService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
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

    @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public User find(UserSelector selector) {
        return this.service.find(selector);
    }
}
