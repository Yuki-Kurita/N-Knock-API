package com.good.tyotto.nknock.api.repository;

import static org.junit.Assert.assertEquals;
import com.good.tyotto.nknock.api.domain.Knock;
import com.good.tyotto.nknock.api.domain.KnockSelector;
import com.good.tyotto.nknock.api.repository.mybatis.KnockMapper;
import java.util.ArrayList;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class KnockRepositoryTest {
    @Mock
    private SqlSession sqlSession;

    @Mock
    private KnockMapper mapper;

    @BeforeEach
    public void before() {
        MockitoAnnotations.initMocks(this);
        Mockito.doReturn(mapper).when(sqlSession).getMapper(KnockMapper.class);
    }

    @AfterEach
    public void after() {
        Mockito.verify(sqlSession, Mockito.times(1)).getMapper(KnockMapper.class);
    }

    @Test
    void testFind() {
        List<Knock> findResult = new ArrayList<>();
        Knock knock = new Knock();
        findResult.add(knock);
        KnockSelector input = new KnockSelector();
        Mockito.doReturn(findResult).when(mapper).find(input);

        List<Knock> result = new KnockRepositoryImpl(this.sqlSession).find(input);

        assertEquals(findResult, result);
        Mockito.verify(mapper, Mockito.times(1)).find(input);
    }

    @Test
    void testAdd() {
        Knock knock = new Knock();
        Mockito.doReturn(1).when(mapper).insert(knock);

        new KnockRepositoryImpl(this.sqlSession).add(knock);

        Mockito.verify(mapper, Mockito.times(1)).insert(knock);
    }

    @Test
    void testSet() {
        Knock knock = new Knock();
        Mockito.doReturn(1).when(mapper).update(knock);

        new KnockRepositoryImpl(this.sqlSession).set(knock);

        Mockito.verify(mapper, Mockito.times(1)).update(knock);
    }

    @Test
    void testRemove() {
        int input = 1;
        Mockito.doNothing().when(mapper).delete(input);

        new KnockRepositoryImpl(this.sqlSession).remove(input);

        Mockito.verify(mapper, Mockito.times(1)).delete(input);
    }

}
