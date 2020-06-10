package com.good.tyotto.nknock.api.controller;

import com.good.tyotto.nknock.api.domain.Knock;
import com.good.tyotto.nknock.api.service.KnockService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Knockに関する操作を行うRestful Web APIコントローラ
 */
@RestController
@RequestMapping("knock")
public class KnockRestController {

    private final KnockService service;

    public KnockRestController(KnockService service) {
        this.service = service;
    }

    @CrossOrigin(origins = {"http://localhost:8081"})
    @PostMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public void add(@RequestBody Knock knock) {
        this.service.add(knock);
    }
}
