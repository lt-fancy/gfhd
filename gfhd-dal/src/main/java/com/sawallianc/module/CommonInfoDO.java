package com.sawallianc.module;

import com.sawallianc.BaseDO;
import lombok.Data;

@Data
public class CommonInfoDO extends BaseDO{
    private String commonEname;
    private String commonCname;
    private String content;
}
