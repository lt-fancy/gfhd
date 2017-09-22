package com.sawallianc.service;

import com.github.pagehelper.PageInfo;
import com.sawallianc.bo.RecruitInfoBO;

import java.util.List;

public interface RecruitService {
    PageInfo<RecruitInfoBO> pageQueryAll(Integer page,Integer pageSize);

    List<RecruitInfoBO> queryAll();

    RecruitInfoBO getById(long id);
}
