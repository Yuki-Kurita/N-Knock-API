package com.good.tyotto.nknock.api.service;

import com.good.tyotto.nknock.api.domain.Knock;
import com.good.tyotto.nknock.api.repository.KnockRepository;
import org.springframework.stereotype.Service;

@Service
public class KnockServiceImpl implements KnockService {

    private final KnockRepository knockRepository;

    public KnockServiceImpl(KnockRepository knockRepository) {
        this.knockRepository = knockRepository;
    }

    @Override
    public void add(Knock knock) {
        knockRepository.add(knock);
    }
}
