package com.sawallianc.dao;

import com.sawallianc.module.MenuDO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by fingertap on 2017/9/16.
 */
public interface MenuDAO {
    List<MenuDO> queryAllMenuByOrder();

    List<MenuDO> queryAllParentMenuOnly();

    MenuDO queryMenuById(@Param("id") Long id);

    MenuDO queryMenuByEname(@Param("ename") String ename);

    List<MenuDO> queryChildrenByParentId(@Param("id") Long id);

    int addMenu(@Param("info") MenuDO menuDO);

    int batchAddMenu(@Param("list") List<MenuDO> list);

    int modifyMenu(@Param("info") MenuDO menuDO);

    int batchDeleteMenu(@Param("list") List<Long> ids);

}
