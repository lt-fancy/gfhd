package com.sawallianc.controller;

import com.github.pagehelper.PageInfo;
import com.sawallianc.advice.WebAdvice;
import com.sawallianc.annotation.FrontModel;
import com.sawallianc.bo.ListInfoBO;
import com.sawallianc.entity.Result;
import com.sawallianc.module.MenuDO;
import com.sawallianc.service.ListService;
import com.sawallianc.service.MenuService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by fingertap on 2017/9/16.
 */
@Controller
public class WebController extends WebAdvice {

    private static final Logger LOGGER = LoggerFactory.getLogger(WebController.class);

    @Autowired
    private MenuService menuService;

    @Autowired
    private ListService listService;

    @GetMapping("/page")
    public String page(Model model,@RequestParam(defaultValue = "1") Integer pageNum, @RequestParam(defaultValue = "3") Integer pageSize) {
        PageInfo<MenuDO> pageInfo = menuService.pageQuery(pageNum, pageSize);
        //获得当前页
        model.addAttribute("pageNum", pageInfo.getPageNum());
        //获得一页显示的条数
        model.addAttribute("pageSize", pageInfo.getPageSize());
        //是否是第一页
        model.addAttribute("isFirstPage", pageInfo.isIsFirstPage());
        //获得总页数
        model.addAttribute("totalPages", pageInfo.getPages());
        //是否是最后一页
        model.addAttribute("isLastPage", pageInfo.isIsLastPage());
        model.addAttribute("totalSizes", menuService.queryAllMenuByOrder().size());
//        model.addAttribute("menus", pageInfo.getList());
        model.addAttribute("menus", menuService.queryAllMenuByOrder());
        return "page";
    }


    @GetMapping("/home")
    @FrontModel
    public String home(Model model) {
        return "home";
    }

    @GetMapping("/about")
    @FrontModel
    public String about(Model model) {
        return "about";
    }

    @GetMapping("/news")
    @FrontModel
    public String news(Model model,@RequestParam(defaultValue = "1") Integer pageNum, @RequestParam(defaultValue = "7") Integer pageSize) {
        PageInfo<ListInfoBO> pageInfo = listService.pageQueryList("news-business",pageNum, pageSize);
        model.addAttribute("lists",pageInfo.getList());
        //获得当前页
        model.addAttribute("pageNum", pageInfo.getPageNum());
        //获得一页显示的条数
        model.addAttribute("pageSize", pageInfo.getPageSize());
        //是否是第一页
        model.addAttribute("isFirstPage", pageInfo.isIsFirstPage());
        //获得总页数
        model.addAttribute("totalPages", pageInfo.getPages());
        //是否是最后一页
        model.addAttribute("isLastPage", pageInfo.isIsLastPage());
        model.addAttribute("totalSizes", listService.countAllList("news-business"));
        return "news";
    }

    @GetMapping("/org")
    @FrontModel
    public String org(Model model) {
        return "org";
    }

    @GetMapping("/biz")
    @FrontModel
    public String biz(Model model) {
        return "biz";
    }

    @GetMapping("/recruit")
    @FrontModel
    public String recruit(Model model) {
        return "recruit";
    }

    @GetMapping("/contact")
    @FrontModel
    public String contact(Model model) {
        return "contact";
    }
}