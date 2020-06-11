//package com.good.tyotto.nknock.api.repository;
//
//import com.good.tyotto.nknock.api.domain.Knock;
//import org.apache.ibatis.session.SqlSession;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.mockito.MockitoAnnotations;
//
//public class KnockRepositoryTest {
//    @Mock
//    private SqlSession sqlSession;
//
//    @Mock
//    private KnockMapper mapper;
//
//    @BeforeEach
//    public void before() {
//        MockitoAnnotations.initMocks(this);
//        Mockito.doReturn(mapper).when(sqlSession).getMapper(KnockMapper.class);
//    }
//
//    @AfterEach
//    public void after() {
//        Mockito.verify(sqlSession, Mockito.times(1)).getMapper(KnockMapper.class);
//    }
//
//    @Test
//    void testAdd() {
//        Knock knock = new Knock();
//        Mockito.doReturn(1).when(mapper).add(knock);
//
//        new KnockRepositoryImpl(this.sqlSession).add(knock);
//
//        Mockito.verify(mapper, Mockito.times(1)).add(knock);
//    }
//}
