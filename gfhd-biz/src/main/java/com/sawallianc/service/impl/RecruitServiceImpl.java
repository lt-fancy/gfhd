package com.sawallianc.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Lists;
import com.sawallianc.bo.RecruitInfoBO;
import com.sawallianc.dao.RecruitInfoDAO;
import com.sawallianc.module.RecruitInfoDO;
import com.sawallianc.service.RecruitService;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.List;

@Service
public class RecruitServiceImpl implements RecruitService{

    @Autowired
    private RecruitInfoDAO recruitInfoDAO;

    @Override
    public PageInfo<RecruitInfoBO> pageQueryAll(Integer page,Integer pageSize) {
        Page page1 = PageHelper.startPage(page, pageSize);
        List<RecruitInfoBO> list = this.queryAll();
        PageInfo pageInfo = page1.toPageInfo();
        pageInfo.setList(list);
        return pageInfo;
    }

    @Override
    public List<RecruitInfoBO> queryAll(){
        return this.bosFromDos(recruitInfoDAO.queryAll());
    }

    @Override
    public RecruitInfoBO getById(long id) {
        return this.boFromDO(recruitInfoDAO.getById(id));
    }

    private RecruitInfoBO boFromDO(RecruitInfoDO recruitInfoDO){
        if(null == recruitInfoDO){
            return null;
        }
        RecruitInfoBO bo = new RecruitInfoBO();
        BeanUtils.copyProperties(recruitInfoDO,bo);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        bo.setGmtCreated(sdf.format(recruitInfoDO.getGmtCreated()));
        bo.setGmtModified(sdf.format(recruitInfoDO.getGmtModified()));
        return bo;
    }
    public List<RecruitInfoBO> bosFromDos(List<RecruitInfoDO> list){
        if(CollectionUtils.isEmpty(list)){
            return null;
        }
        List<RecruitInfoBO> result = Lists.newArrayListWithCapacity(list.size());
        for(RecruitInfoDO recruitInfoDO : list){
            result.add(boFromDO(recruitInfoDO));
        }
        return result;
    }
}
