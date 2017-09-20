package com.sawallianc.dao;

import com.sawallianc.module.TextInfoDO;
import org.apache.ibatis.annotations.Param;

public interface TextInfoDAO {
    TextInfoDO getTextByMenuEname(@Param("ename") String ename);
}
