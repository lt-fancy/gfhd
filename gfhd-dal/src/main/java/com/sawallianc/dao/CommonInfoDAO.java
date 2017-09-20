package com.sawallianc.dao;

import com.sawallianc.module.CommonInfoDO;
import org.apache.ibatis.annotations.Param;

public interface CommonInfoDAO {
    CommonInfoDO getByEname(@Param("ename")String ename);
}
