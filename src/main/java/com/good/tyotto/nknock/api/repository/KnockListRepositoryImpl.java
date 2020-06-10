package com.good.tyotto.nknock.api.repository;

import com.good.tyotto.nknock.api.domain.KnockList;
import com.good.tyotto.nknock.api.domain.KnockListSelector;
import com.good.tyotto.nknock.api.domain.Tag;
import com.good.tyotto.nknock.api.repository.mybatis.KnockListMapper;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

/**
 * KnockListRepositoryのMyBatisを利用した実装クラス
 */
@Repository
public class KnockListRepositoryImpl implements KnockListRepository {

    private final SqlSession sqlSession;

    public KnockListRepositoryImpl(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    @Override
    public List<KnockList> findAll() {
        return this.sqlSession.getMapper(KnockListMapper.class).getAll();
    }

    @Override
    public List<KnockList> find(KnockListSelector selector) {
        return this.sqlSession.getMapper(KnockListMapper.class).get(selector);
    }

    @Override
    public List<Tag> findTag() {
        return this.sqlSession.getMapper(KnockListMapper.class).getTag();
    }

    @Override
    public void add(KnockList knockList) {
        this.sqlSession.getMapper(KnockListMapper.class).add(knockList);
    }
}
