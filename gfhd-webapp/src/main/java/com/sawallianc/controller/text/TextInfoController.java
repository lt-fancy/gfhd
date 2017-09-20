package com.sawallianc.controller.text;

import com.sawallianc.advice.WebAdvice;
import com.sawallianc.entity.Result;
import com.sawallianc.module.TextInfoDO;
import com.sawallianc.service.TextService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/text")
public class TextInfoController extends WebAdvice{

    private static final Logger LOGGER = LoggerFactory.getLogger(TextInfoController.class);

    @Autowired
    private TextService textService;

    @GetMapping("getTextByMenuEname")
    @ResponseBody
    public Result getTextByMenuEname(String ename){
        if(StringUtils.isBlank(ename)){
            LOGGER.error("[getTextByMenuEname] request parameter ename is blank");
            return Result.failResult();
        }
        TextInfoDO textInfoDO = textService.getTextByMenuEname(ename);
        if(null == textInfoDO){
            return Result.getSuccessResult("");
        }
        String result = textService.getTextByMenuEname(ename).getText();
        result = StringUtils.isBlank(result)?"":result;
        return Result.getSuccessResult(result);
    }
}
