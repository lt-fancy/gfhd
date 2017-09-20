package com.sawallianc.controller.list;

import com.sawallianc.advice.WebAdvice;
import com.sawallianc.entity.Result;
import com.sawallianc.service.ListService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "list")
public class ListInfoController extends WebAdvice{

    private static final Logger LOGGER = LoggerFactory.getLogger(ListInfoController.class);

    @Autowired
    private ListService listService;

    @GetMapping("getByEname")
    @ResponseBody
    public Result getByEname(String ename){
        if(StringUtils.isBlank(ename)){
            LOGGER.error("[getByEname] request parameter ename is blank");
            return Result.failResult();
        }
        return Result.getSuccessResult(listService.getListByEname(ename));
    }
}
