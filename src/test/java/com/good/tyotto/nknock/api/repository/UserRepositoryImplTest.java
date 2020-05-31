package com.good.tyotto.nknock.api.repository;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import com.good.tyotto.nknock.api.domain.User;
import com.good.tyotto.nknock.api.domain.UserSelector;
import com.good.tyotto.nknock.api.repository.mybatis.UserMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

/**
 * UserRepositoryに実装されているロジックをテストする
 */
public class UserRepositoryImplTest {

    // UserRepositoryImplクラスが依存しているSqlSessionクラスをモック化する
    @Mock
    private SqlSession sqlSession;

    // UserRepositoryImplクラスが依存しているUserMapperインタフェースをモック化する
    @Mock
    private UserMapper mapper;

    @BeforeEach
    public void before() {
        MockitoAnnotations.initMocks(this);
        Mockito.doReturn(mapper).when(sqlSession).getMapper(UserMapper.class);
    }

    @AfterEach
    public void after() {
        Mockito.verify(sqlSession, Mockito.times(1)).getMapper(UserMapper.class);
    }

    @Test
    public void testGetWhenFound() {
        // setup
        UserSelector selector = new UserSelector();
        User findResult = new User();
        Mockito.doReturn(findResult).when(mapper).get(selector);

        // when sqlSession
        User result = new UserRepositoryImpl(this.sqlSession).find(selector);

        // then
        assertEquals(findResult, result);
        Mockito.verify(mapper, Mockito.times(1)).get(selector);
    }

    /**
     * UserMapperで検索対象が存在しなかった場合に例外が発生するか
     */
    @Test
    public void testGetWhenNotFound() {
        // setup
        UserSelector selector = new UserSelector();
        Mockito.doReturn(null).when(mapper).get(selector);

        // when
        assertThrows(ResourceNotFoundException.class,
                () ->  new UserRepositoryImpl(this.sqlSession).find(selector));
    }
}
