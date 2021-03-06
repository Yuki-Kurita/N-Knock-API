package com.good.tyotto.nknock.api.repository;

import com.good.tyotto.nknock.api.domain.User;
import com.good.tyotto.nknock.api.domain.UserSelector;
import com.good.tyotto.nknock.api.repository.mybatis.UserMapper;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

/**
 * UserRepositoryのMyBatisを利用した実装クラス
 */
@Repository
public class UserRepositoryImpl implements UserRepository {

    private final SqlSession sqlSession;

    public UserRepositoryImpl(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    @Override
    public User find(UserSelector selector) {
        User user = this.sqlSession.getMapper(UserMapper.class).get(selector);
        if (user == null) {
            throw new ResourceNotFoundException("User not found.");
        }
        return user;
    }

    @Override
    public void insert(User user) {
        this.sqlSession.getMapper(UserMapper.class).add(user);
    }

    @Override
    public void updateUserName(User user) {
        this.sqlSession.getMapper(UserMapper.class).setUserName(user);
    }
}
