package com.sawallianc.controller.menu;

import com.sawallianc.advice.WebAdvice;
import com.sawallianc.entity.Result;
import com.sawallianc.module.MenuDO;
import com.sawallianc.service.MenuService;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(value = "menu")
public class MenuInfoController extends WebAdvice{

    @Autowired
    private MenuService menuService;

    @GetMapping("getFirstChildMenu")
    @ResponseBody
    public Result getFirstChildMenu(String ename){
        if(StringUtils.isBlank(ename)){
            return Result.failResult();
        }
        List<MenuDO> list = menuService.queryChildrenByEname(ename);
        if(CollectionUtils.isEmpty(list)){
            return Result.failResult();
        }
        return Result.getSuccessResult(list.get(0));
    }

    @GetMapping("getMenuByEname")
    @ResponseBody
    public Result getMenuByEname(String ename){
        if(StringUtils.isBlank(ename)){
            return Result.failResult();
        }
        return Result.getSuccessResult(menuService.queryMenuByEname(ename));
    }
}
