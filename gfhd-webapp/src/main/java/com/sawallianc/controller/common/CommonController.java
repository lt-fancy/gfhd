package com.sawallianc.controller.common;

import com.sawallianc.advice.WebAdvice;
import com.sawallianc.entity.Result;
import com.sawallianc.module.CommonInfoDO;
import com.sawallianc.service.CommonService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "common")
public class CommonController extends WebAdvice{

    private static final Logger LOGGER = LoggerFactory.getLogger(CommonController.class);

    @Autowired
    private CommonService commonService;

    @GetMapping("getByEname")
    @ResponseBody
    public Result getByEname(String ename){
        if(StringUtils.isBlank(ename)){
            LOGGER.error("[getByEname] request parameter ename is blank");
            return Result.failResult();
        }
        CommonInfoDO common = commonService.getByEname(ename);
        if(null == common){
            return Result.failResult();
        }
        return Result.getSuccessResult(common.getContent());
    }
}
