package com.good.tyotto.nknock.api.repository;

import static org.junit.Assert.assertEquals;
import com.good.tyotto.nknock.api.domain.Knock;
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

    @Test
    public void testGetLatestId() {
        int findResult = 1;
        Mockito.doReturn(findResult).when(mapper).getLatestId();

        int result = new KnockListRepositoryImpl(this.sqlSession).getLatestId();

        assertEquals(findResult, result);
        Mockito.verify(mapper, Mockito.times(1)).getLatestId();
    }

    @Test
    public void testAdd() {
        KnockList knockList = new KnockList();
        Mockito.doNothing().when(mapper).add(knockList);

        new KnockListRepositoryImpl(this.sqlSession).add(knockList);

        Mockito.verify(mapper, Mockito.times(1)).add(knockList);
    }

    @Test
    public void testSet() {
        KnockList knockList = new KnockList();
        Mockito.doNothing().when(mapper).update(knockList);

        new KnockListRepositoryImpl(this.sqlSession).set(knockList);

        Mockito.verify(mapper, Mockito.times(1)).update(knockList);
    }

    @Test
    public void testRemove() {
        int knockListId = 1;
        Mockito.doNothing().when(mapper).delete(knockListId);

        new KnockListRepositoryImpl(this.sqlSession).remove(knockListId);

        Mockito.verify(mapper, Mockito.times(1)).delete(knockListId);
    }
}
