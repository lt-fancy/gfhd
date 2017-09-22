package com.sawallianc.module;

import com.sawallianc.BaseDO;
import lombok.Data;

@Data
public class ListInfoDO extends BaseDO{
    private String menuEname;
    private String menuCname;
    private String listTitle;
    private String listContent;
    private String author;
    private String imageUri;
    private Integer isHome;
}
