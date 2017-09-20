package com.sawallianc.dao;

import com.sawallianc.module.ImageInfoDO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ImageInfoDAO {
    List<ImageInfoDO> getImageByEname(@Param("ename") String ename);
}
