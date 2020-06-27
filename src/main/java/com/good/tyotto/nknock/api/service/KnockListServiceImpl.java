package com.good.tyotto.nknock.api.service;

import com.good.tyotto.nknock.api.domain.KnockList;
import com.good.tyotto.nknock.api.domain.KnockListGroup;
import com.good.tyotto.nknock.api.domain.KnockListSelector;
import com.good.tyotto.nknock.api.domain.TagList;
import com.good.tyotto.nknock.api.repository.KnockListRepository;
import org.springframework.stereotype.Service;

@Service
public class KnockListServiceImpl implements KnockListService {

    private final KnockListRepository knockListRepository;

    public KnockListServiceImpl(KnockListRepository knockListRepository) {
        this.knockListRepository = knockListRepository;
    }

    @Override
    public KnockListGroup findAll() {
        KnockListGroup knockLists = new KnockListGroup();
        knockLists.setKnockLists(knockListRepository.findAll());
        return knockLists;
    }

    @Override
    public KnockListGroup find(KnockListSelector selector) {
        KnockListGroup knockLists = new KnockListGroup();
        knockLists.setKnockLists(knockListRepository.find(selector));
        return knockLists;
    }

    @Override
    public TagList findTag() {
        TagList tagList = new TagList();
        tagList.setTags(knockListRepository.findTag());
        return tagList;
    }

    @Override
    public int getLatestId() {
        return knockListRepository.getLatestId();
    }

    @Override
    public void add(KnockList knockList) {
        knockListRepository.add(knockList);
    }

    @Override
    public void set(KnockList knockList) {
        knockListRepository.set(knockList);
    }

    @Override
    public void remove(int knockListId) {
        knockListRepository.remove(knockListId);
    }
}
