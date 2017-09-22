package com.sawallianc.dao;

import com.sawallianc.module.RecruitInfoDO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RecruitInfoDAO {
    List<RecruitInfoDO> queryAll();

    RecruitInfoDO getById(@Param("id") long id);
}
