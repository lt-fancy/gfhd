package com.sawallianc.bo;

import lombok.Data;

@Data
public class RecruitInfoBO extends BaseBO{
    private String menuEname;
    private String menuCname;
    private String recruitTitle;
    private String recruitDepartment;
    private String recruitContent;
}
