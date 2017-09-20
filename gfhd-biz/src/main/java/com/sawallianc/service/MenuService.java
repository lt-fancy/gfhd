package com.sawallianc.service;

import com.github.pagehelper.PageInfo;
import com.sawallianc.module.MenuDO;

import java.util.List;

/**
 * Created by fingertap on 2017/9/16.
 */
public interface MenuService {

    List<MenuDO> queryAllMenuByOrder();

    List<MenuDO> queryAllParentMenuOnly();

    List<MenuDO> queryChildrenByParentId(Long id);

    List<MenuDO> queryChildrenByEname(String ename);

    PageInfo<MenuDO> pageQuery(Integer page,Integer pageSize);

    MenuDO queryMenuById(Long id);

    int addMenu(MenuDO menuDO);

    int batchAddMenu(List<MenuDO> list);

    int modifyMenu(MenuDO menuDO);

    int batchDeleteMenu(List<Long> ids);

}
