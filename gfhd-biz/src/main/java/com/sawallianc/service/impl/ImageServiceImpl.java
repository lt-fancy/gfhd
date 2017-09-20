package com.sawallianc.service.impl;

import com.sawallianc.dao.ImageInfoDAO;
import com.sawallianc.module.ImageInfoDO;
import com.sawallianc.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImageServiceImpl implements ImageService{

    @Autowired
    private ImageInfoDAO imageInfoDAO;

    @Override
    public List<ImageInfoDO> getImageByEname(String ename) {
        return imageInfoDAO.getImageByEname(ename);
    }
}
