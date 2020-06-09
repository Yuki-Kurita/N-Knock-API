package com.good.tyotto.nknock.api.repository;

import static org.junit.Assert.assertEquals;
import com.good.tyotto.nknock.api.domain.KnockList;
import com.good.tyotto.nknock.api.domain.KnockListGroup;
import com.good.tyotto.nknock.api.domain.KnockListSelector;
import com.good.tyotto.nknock.api.repository.mybatis.KnockListMapper;
import java.util.ArrayList;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class KnockListRepositoryTest {
    @Mock
    private SqlSession sqlSession;

    @Mock
    private KnockListMapper mapper;

    @BeforeEach
    public void before() {
        MockitoAnnotations.initMocks(this);
        Mockito.doReturn(mapper).when(sqlSession).getMapper(KnockListMapper.class);
    }

    @AfterEach
    public void after() {
        Mockito.verify(sqlSession, Mockito.times(1)).getMapper(KnockListMapper.class);
    }

    @Test
    public void testGetAll() {
        KnockList knockList = new KnockList();
        List<KnockList> findResult = new ArrayList<>();
        findResult.add(knockList);
        Mockito.doReturn(findResult).when(mapper).getAll();

        List<KnockList> result = new KnockListRepositoryImpl(this.sqlSession).findAll();

        assertEquals(findResult, result);
        Mockito.verify(mapper, Mockito.times(1)).getAll();
    }

    @Test
    public void testGet() {
        KnockList knockList = new KnockList();
        List<KnockList> findResult = new ArrayList<>();
        findResult.add(knockList);
        KnockListSelector selector = new KnockListSelector();
        Mockito.doReturn(findResult).when(mapper).get(selector);

        List<KnockList> result = new KnockListRepositoryImpl(this.sqlSession).find(selector);

        assertEquals(findResult, result);
        Mockito.verify(mapper, Mockito.times(1)).get(selector);
    }
}
