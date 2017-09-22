package com.sawallianc.dao;

import com.sawallianc.module.ListInfoDO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ListInfoDAO {
    List<ListInfoDO> getListByEname(@Param("ename")String ename);

    int countAllList(@Param("ename")String ename);

    ListInfoDO getListInfoById(@Param("id")long id);

    List<ListInfoDO> query5ListInfoForHome();
}
