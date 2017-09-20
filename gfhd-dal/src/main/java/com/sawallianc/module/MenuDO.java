package com.sawallianc.module;

import com.sawallianc.BaseDO;
import lombok.Data;

import java.util.List;

/**
 * Created by fingertap on 2017/9/16.
 */
@Data
public class MenuDO extends BaseDO{
    private Long parentId;
    private String menuCname;
    private String menuEname;
    private String menuUri;
    private Integer isParent;
    private Integer orderIndex;
    private List<MenuDO> children;
}
