package com.sawallianc.module;

import com.sawallianc.BaseDO;
import lombok.Data;

@Data
public class RecruitInfoDO extends BaseDO{
    private String menuEname;
    private String menuCname;
    private String recruitTitle;
    private String recruitDepartment;
    private String recruitContent;
}
