package com.good.tyotto.nknock.api.repository.mybatis;

import com.good.tyotto.nknock.api.domain.Knock;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface KnockMapper {

    int insert(Knock knock);
}
