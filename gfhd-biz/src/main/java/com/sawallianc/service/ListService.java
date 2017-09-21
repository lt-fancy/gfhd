package com.sawallianc.service;

import com.github.pagehelper.PageInfo;
import com.sawallianc.bo.ListInfoBO;

import java.util.List;

public interface ListService {
    List<ListInfoBO> getListByEname(String ename);

    PageInfo<ListInfoBO> pageQueryList(String ename,Integer page, Integer pageSize);

    int countAllList(String ename);

    ListInfoBO getListInfoById(long id);
}
