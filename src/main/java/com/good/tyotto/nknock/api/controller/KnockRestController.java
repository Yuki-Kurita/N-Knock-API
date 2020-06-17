package com.good.tyotto.nknock.api.controller;

import com.good.tyotto.nknock.api.domain.Knock;
import com.good.tyotto.nknock.api.domain.KnockGroup;
import com.good.tyotto.nknock.api.domain.KnockSelector;
import com.good.tyotto.nknock.api.service.KnockService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
    @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public KnockGroup find(KnockSelector selector) {
        return this.service.find(selector);
    }

    @CrossOrigin(origins = {"http://localhost:8081"})
    @PostMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public void add(@RequestBody Knock knock) {
        this.service.add(knock);
    }

    @CrossOrigin(origins = {"http://localhost:8081"})
    @PatchMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public void set(@RequestBody Knock knock) {
        this.service.set(knock);
    }

    /**
     * Knockを削除する
     * @param knockListId 削除対象のノックリストID
     */
    @CrossOrigin(origins = {"http://localhost:8081"})
    @DeleteMapping(path = "/{knockListId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void remove(@PathVariable int knockListId) {
        this.service.remove(knockListId);
    }
}
