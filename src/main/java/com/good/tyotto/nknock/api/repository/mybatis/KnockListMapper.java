package com.good.tyotto.nknock.api.repository.mybatis;

import com.good.tyotto.nknock.api.domain.KnockList;
import com.good.tyotto.nknock.api.domain.KnockListSelector;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

/**
 * MyBatisによるKnockListテーブルとのマッパーを表すインタフェース
 */
@Mapper
public interface KnockListMapper {

    List<KnockList> getAll();

    List<KnockList> get(KnockListSelector selector);

}
