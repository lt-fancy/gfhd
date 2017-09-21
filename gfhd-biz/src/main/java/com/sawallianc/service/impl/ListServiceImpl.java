package com.sawallianc.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Lists;
import com.sawallianc.bo.ListInfoBO;
import com.sawallianc.dao.ListInfoDAO;
import com.sawallianc.module.ListInfoDO;
import com.sawallianc.module.MenuDO;
import com.sawallianc.service.ListService;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.List;

@Service
public class ListServiceImpl implements ListService{

    @Autowired
    private ListInfoDAO listInfoDAO;

    @Override
    public List<ListInfoBO> getListByEname(String ename) {
        return this.bosFromDOS(listInfoDAO.getListByEname(ename));
    }


    @Override
    public PageInfo<ListInfoBO> pageQueryList(String ename,Integer page, Integer pageSize) {
        Page page1 = PageHelper.startPage(page, pageSize);
        List<ListInfoBO> list = this.getListByEname(ename);
        PageInfo pageInfo = page1.toPageInfo();
        pageInfo.setList(list);
        return pageInfo;
    }

    @Override
    public int countAllList(String ename) {
        return listInfoDAO.countAllList(ename);
    }

    @Override
    public ListInfoBO getListInfoById(long id) {
        return this.boFromDO(listInfoDAO.getListInfoById(id));
    }

    private ListInfoBO boFromDO(ListInfoDO listInfoDO){
        if(null == listInfoDO){
            return null;
        }
        ListInfoBO listInfoBO = new ListInfoBO();
        BeanUtils.copyProperties(listInfoDO,listInfoBO);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        listInfoBO.setGmtCreated(sdf.format(listInfoDO.getGmtCreated()));
        listInfoBO.setGmtModified(sdf.format(listInfoDO.getGmtModified()));
        return listInfoBO;
    }

    private List<ListInfoBO> bosFromDOS(List<ListInfoDO> list){
        if(CollectionUtils.isEmpty(list)){
            return null;
        }
        List<ListInfoBO> result = Lists.newArrayListWithCapacity(list.size());
        for(ListInfoDO listInfoDO : list){
            result.add(boFromDO(listInfoDO));
        }
        return result;
    }
}
