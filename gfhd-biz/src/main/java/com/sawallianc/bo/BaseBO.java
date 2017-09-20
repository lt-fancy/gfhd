package com.sawallianc.bo;

import lombok.Data;

@Data
public class BaseBO {
    private Long id;
    private String gmtCreated;
    private String gmtModified;
    private String isDeleted;
}
