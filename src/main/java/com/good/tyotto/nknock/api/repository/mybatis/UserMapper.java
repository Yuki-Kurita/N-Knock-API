package com.good.tyotto.nknock.api.repository.mybatis;

import com.good.tyotto.nknock.api.domain.User;
import com.good.tyotto.nknock.api.domain.UserSelector;
import org.apache.ibatis.annotations.Mapper;

/**
 * MyBatisによるUserテーブルとのマッパーを表すインタフェース
 */
@Mapper
public interface UserMapper {

    User get(UserSelector selector);

    int add(User user);
}
