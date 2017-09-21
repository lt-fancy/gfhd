package com.sawallianc.controller.image;

import com.google.common.collect.Lists;
import com.sawallianc.entity.Result;
import com.sawallianc.module.ImageInfoDO;
import com.sawallianc.service.ImageService;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(value = "/image")
public class ImageInfoController {
    private static final Logger LOGGER = LoggerFactory.getLogger(ImageInfoController.class);

    @Autowired
    private ImageService imageService;

    @GetMapping("getImageByEname")
    @ResponseBody
    public Result getImageByEname(String ename){
        if(StringUtils.isBlank(ename)){
            LOGGER.error("[getTextByMenuEname] request parameter ename is blank");
            return Result.failResult();
        }
        return Result.getSuccessResult(imageService.getImageByEname(ename));
    }
}
