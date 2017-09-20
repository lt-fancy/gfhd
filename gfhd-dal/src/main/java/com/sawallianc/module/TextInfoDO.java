package com.sawallianc.module;

import com.sawallianc.BaseDO;
import lombok.Data;

@Data
public class TextInfoDO extends BaseDO{
    private String menuEname;
    private String menuCname;
    private String text;
}
