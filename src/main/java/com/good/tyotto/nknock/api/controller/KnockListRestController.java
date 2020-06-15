package com.good.tyotto.nknock.api.controller;

import com.good.tyotto.nknock.api.domain.KnockList;
import com.good.tyotto.nknock.api.domain.KnockListGroup;
import com.good.tyotto.nknock.api.domain.KnockListSelector;
import com.good.tyotto.nknock.api.domain.TagList;
import com.good.tyotto.nknock.api.service.KnockListService;
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
 * KnockListに関する操作を行うRestful Web APIコントローラ
 */
@RestController
@RequestMapping("knocklist")
public class KnockListRestController {

    private final KnockListService service;

    public KnockListRestController(KnockListService service) {
        this.service = service;
    }

    /**
     * ノックリスト全件取得
     * @return 削除されていないノックリスト
     */
    @CrossOrigin(origins = {"http://localhost:8081"})
    @GetMapping(path = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public KnockListGroup findAll() {
        return this.service.findAll();
    }

    /**
     * 条件に一致するノックリストを取得
     * @param selector 検索条件
     * @return ノックリスト
     */
    @CrossOrigin(origins = {"http://localhost:8081"})
    @GetMapping(path = "/search", produces = MediaType.APPLICATION_JSON_VALUE)
    public KnockListGroup find(KnockListSelector selector) {
        return this.service.find(selector);
    }

    /**
     * タグ全件取得
     * @return 削除されていないタグ
     */
    @CrossOrigin(origins = {"http://localhost:8081"})
    @GetMapping(path = "/tags", produces = MediaType.APPLICATION_JSON_VALUE)
    public TagList findTag() {
        return this.service.findTag();
    }

    /**
     * ノックリストを追加
     * @param knockList 追加するノックリスト
     */
    @CrossOrigin(origins = {"http://localhost:8081"})
    @PostMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public void add(@RequestBody KnockList knockList) {
        this.service.add(knockList);
    }

    /**
     * ノックリストIDにマッチするノックリストを更新
     * @param knockList 更新するノックリスト
     */
    @CrossOrigin(origins = {"http://localhost:8081"})
    @PatchMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public void set(@RequestBody KnockList knockList) {
        this.service.set(knockList);
    }

    /**
     * ノックリストIDにマッチするノックリストを論理削除
     * @param knockListId 削除対象のノックリストID
     */
    @CrossOrigin(origins = {"http://localhost:8081"})
    @PatchMapping(path = "/{knockListId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void remove(@PathVariable int knockListId) {
        this.service.remove(knockListId);
    }

}
