package com.sawallianc.service.impl;

import com.sawallianc.dao.CommonInfoDAO;
import com.sawallianc.module.CommonInfoDO;
import com.sawallianc.service.CommonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommonServiceImpl implements CommonService{

    private final static Logger LOGGER = LoggerFactory.getLogger(CommonServiceImpl.class);

    @Autowired
    private CommonInfoDAO commonInfoDAO;

    @Override
    public CommonInfoDO getByEname(String ename) {
        return commonInfoDAO.getByEname(ename);
    }
}
