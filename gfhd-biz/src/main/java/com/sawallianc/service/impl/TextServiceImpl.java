package com.sawallianc.service.impl;

import com.sawallianc.dao.TextInfoDAO;
import com.sawallianc.module.TextInfoDO;
import com.sawallianc.service.TextService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TextServiceImpl implements TextService{
    @Autowired
    private TextInfoDAO textInfoDAO;
    @Override
    public TextInfoDO getTextByMenuEname(String ename) {
        return textInfoDAO.getTextByMenuEname(ename);
    }
}
