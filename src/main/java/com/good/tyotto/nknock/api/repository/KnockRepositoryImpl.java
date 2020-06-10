package com.good.tyotto.nknock.api.repository;

import com.good.tyotto.nknock.api.domain.Knock;
import com.good.tyotto.nknock.api.repository.mybatis.KnockMapper;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class KnockRepositoryImpl implements KnockRepository {

    private final SqlSession sqlSession;

    public KnockRepositoryImpl(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    @Override
    public void add(Knock knock) {
        this.sqlSession.getMapper(KnockMapper.class).insert(knock);
    }
}
