package com.good.tyotto.nknock.api.service;

import com.good.tyotto.nknock.api.domain.Knock;
import com.good.tyotto.nknock.api.domain.KnockGroup;
import com.good.tyotto.nknock.api.domain.KnockSelector;
import com.good.tyotto.nknock.api.repository.KnockRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class KnockServiceImpl implements KnockService {

    private final KnockRepository knockRepository;

    public KnockServiceImpl(KnockRepository knockRepository) {
        this.knockRepository = knockRepository;
    }

    @Override
    public KnockGroup find(KnockSelector selector) {
        List<Knock> knocks = knockRepository.find(selector);
        KnockGroup knockGroup = new KnockGroup();
        knockGroup.setKnocks(knocks);
        return knockGroup;
    }

    @Override
    public void add(Knock knock) {
        knockRepository.add(knock);
    }

    @Override
    public void set(Knock knock) {
        knockRepository.set(knock);
    }

    @Override
    public void remove(int knockId) {
        knockRepository.remove(knockId);
    }
}
