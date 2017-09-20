package com.sawallianc.module;

import com.sawallianc.BaseDO;
import lombok.Data;

@Data
public class ImageInfoDO extends BaseDO{
    private String menuEname;
    private String menuCname;
    private String imageUri;
    private String imageTitle;
}
