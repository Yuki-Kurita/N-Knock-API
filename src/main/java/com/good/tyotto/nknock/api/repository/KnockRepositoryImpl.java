package com.good.tyotto.nknock.api.repository;

import com.good.tyotto.nknock.api.domain.Knock;
import com.good.tyotto.nknock.api.domain.KnockGroup;
import com.good.tyotto.nknock.api.domain.KnockSelector;
import com.good.tyotto.nknock.api.repository.mybatis.KnockMapper;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class KnockRepositoryImpl implements KnockRepository {

    private final SqlSession sqlSession;

    public KnockRepositoryImpl(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    @Override
    public List<Knock> find(KnockSelector selector) {
        List<Knock> knocks = this.sqlSession.getMapper(KnockMapper.class).find(selector);
        return knocks;
    }

    @Override
    public void add(Knock knock) {
        this.sqlSession.getMapper(KnockMapper.class).insert(knock);
    }

    @Override
    public void set(Knock knock) {
        this.sqlSession.getMapper(KnockMapper.class).update(knock);
    }

    @Override
    public void remove(int knockId) {
        this.sqlSession.getMapper(KnockMapper.class).delete(knockId);
    }
}
