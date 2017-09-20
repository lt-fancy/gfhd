package com.sawallianc.service;

import com.sawallianc.module.ImageInfoDO;

import java.util.List;

public interface ImageService {
    List<ImageInfoDO> getImageByEname(String ename);
}
