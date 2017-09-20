package com.sawallianc.bo;

import lombok.Data;

@Data
public class ListInfoBO extends BaseBO{
    private String menuEname;
    private String menuCname;
    private String listTitle;
    private String listContent;
    private String author;
}
