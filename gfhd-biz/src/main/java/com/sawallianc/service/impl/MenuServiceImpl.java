package com.sawallianc.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Lists;
import com.sawallianc.annotation.Cacheable;
import com.sawallianc.dao.MenuDAO;
import com.sawallianc.module.MenuDO;
import com.sawallianc.service.MenuService;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.util.List;

/**
 * Created by fingertap on 2017/9/16.
 */
@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuDAO menuDAO;

    @Override
    @Cacheable
    public List<MenuDO> queryAllMenuByOrder() {
        List<MenuDO> list = menuDAO.queryAllMenuByOrder();
        if(CollectionUtils.isEmpty(list)){
            return Lists.newArrayListWithCapacity(0);
        }
        for(MenuDO menuDO : list){
            if(null == menuDO){
                continue;
            }
            if(1==menuDO.getIsParent()){
                continue;
            }
            List<MenuDO> children = this.queryChildrenByParentId(menuDO.getId());
            menuDO.setChildren(children);
        }
        return list;
    }

    @Override
    @Cacheable
    public List<MenuDO> queryAllParentMenuOnly() {
        return menuDAO.queryAllParentMenuOnly();
    }

    @Override
    public PageInfo<MenuDO> pageQuery(Integer page,Integer pageSize) {
        PageHelper.startPage(page, pageSize);
        List<MenuDO> list = this.queryAllMenuByOrder();
        return new PageInfo<MenuDO>(list);
    }

    @Override
    public MenuDO queryMenuById(Long id) {
        return menuDAO.queryMenuById(id);
    }

    @Override
    public List<MenuDO> queryChildrenByParentId(Long id) {
        return menuDAO.queryChildrenByParentId(id);
    }

    @Override
    @Cacheable
    public List<MenuDO> queryChildrenByEname(String ename) {
        MenuDO menuDO = menuDAO.queryMenuByEname(ename);
        if(null == menuDO){
            return null;
        }
        if(0!=menuDO.getIsParent()){
            return null;
        }
        return this.queryChildrenByParentId(menuDO.getId());
    }

    @Override
    public int addMenu(MenuDO menuDO) {
        return menuDAO.addMenu(menuDO);
    }

    @Override
    public int batchAddMenu(List<MenuDO> list) {
        return menuDAO.batchAddMenu(list);
    }

    @Override
    public int modifyMenu(MenuDO menuDO) {
        return menuDAO.modifyMenu(menuDO);
    }

    @Override
    public int batchDeleteMenu(List<Long> ids) {
        return menuDAO.batchDeleteMenu(ids);
    }
}
