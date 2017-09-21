package com.sawallianc.service.impl;

import com.google.common.collect.Lists;
import com.sawallianc.dao.ImageInfoDAO;
import com.sawallianc.module.ImageInfoDO;
import com.sawallianc.service.ImageService;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImageServiceImpl implements ImageService{

    @Autowired
    private ImageInfoDAO imageInfoDAO;

    @Override
    public List<ImageInfoDO> getImageByEname(String ename) {
        List<ImageInfoDO> list = imageInfoDAO.getImageByEname(ename);
        if(CollectionUtils.isEmpty(list)){
            List<ImageInfoDO> result = Lists.newArrayListWithCapacity(1);
            ImageInfoDO imageInfoDO = new ImageInfoDO();
            result.add(imageInfoDO);
            return result;
        }
        return list;
    }
}
