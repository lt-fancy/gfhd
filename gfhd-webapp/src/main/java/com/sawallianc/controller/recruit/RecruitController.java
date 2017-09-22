package com.sawallianc.controller.recruit;

import com.sawallianc.advice.WebAdvice;
import com.sawallianc.entity.Result;
import com.sawallianc.service.RecruitService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "recruit")
public class RecruitController extends WebAdvice{
    private final static Logger LOGGER = LoggerFactory.getLogger(RecruitController.class);

    @Autowired
    private RecruitService recruitService;

    @GetMapping("queryAll")
    @ResponseBody
    public Result queryAll(){
        return Result.getSuccessResult(recruitService.queryAll());
    }

    @GetMapping("getById")
    @ResponseBody
    public Result getById(Long id){
        return Result.getSuccessResult(recruitService.getById(id));
    }
}
