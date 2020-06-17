package com.good.tyotto.nknock.api.repository.mybatis;

import com.good.tyotto.nknock.api.domain.Knock;
import com.good.tyotto.nknock.api.domain.KnockSelector;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

/**
 * MyBatisによるKnockテーブルとのマッパーを表すインタフェース
 */
@Mapper
public interface KnockMapper {

    List<Knock> find(KnockSelector selector);

    int insert(Knock knock);

    int update(Knock knock);

    void delete(int knockId);
}
