package com.good.tyotto.nknock.api.repository.mybatis;

import com.good.tyotto.nknock.api.domain.Knock;
import org.apache.ibatis.annotations.Mapper;

/**
 * MyBatisによるKnockテーブルとのマッパーを表すインタフェース
 */
@Mapper
public interface KnockMapper {

    int add(Knock knock);
}
