package com.sawallianc.controller;

import com.github.pagehelper.PageInfo;
import com.sawallianc.advice.WebAdvice;
import com.sawallianc.annotation.FrontModel;
import com.sawallianc.bo.ListInfoBO;
import com.sawallianc.bo.RecruitInfoBO;
import com.sawallianc.entity.Result;
import com.sawallianc.module.MenuDO;
import com.sawallianc.service.*;
import org.apache.commons.collections4.CollectionUtils;
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

    @Autowired
    private ImageService imageService;

    @Autowired
    private TextService textService;

    @Autowired
    private RecruitService recruitService;

    @GetMapping("page")
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


    @GetMapping("home")
    @FrontModel
    public String home(Model model) {
        model.addAttribute("lists",listService.query5ListInfoForHome());
        model.addAttribute("about",textService.getTextByMenuEname("home"));
        model.addAttribute("backgroundImages",imageService.getImageByEname("home"));
        return "home";
    }

    @GetMapping("about")
    @FrontModel
    public String about(Model model) {
        return "about";
    }

    @GetMapping(value = {"news","news-business"})
    @FrontModel
    public String news(Model model,@RequestParam(defaultValue = "1") Integer pageNum, @RequestParam(defaultValue = "7") Integer pageSize) {

        List<MenuDO> menus = menuService.queryChildrenByEname("news");
        String childEname;
        if(CollectionUtils.isEmpty(menus)){
            childEname = "news-business";
        } else {
            MenuDO menuDO = menus.get(0);
            if(null == menuDO){
                childEname = "news-business";
            } else {
                childEname = menuDO.getMenuEname();
            }
        }
        PageInfo<ListInfoBO> pageInfo = listService.pageQueryList(childEname,pageNum, pageSize);
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
        model.addAttribute("totalSizes", listService.countAllList(childEname));
        return "news-list";
    }

    @GetMapping("news-crew")
    @FrontModel
    public String newsCrew(Model model){
        model.addAttribute("images",imageService.getImageByEname("news-crew"));
        return "news-crew";
    }

    @GetMapping("news-detail")
    @FrontModel
    public String newsDetail(Model model,@RequestParam Integer id){
        ListInfoBO bo = listService.getListInfoById(Long.parseLong(id+""));
        model.addAttribute("listInfo",bo);
        return "news-detail";
    }


    @GetMapping("org")
    @FrontModel
    public String org(Model model) {
        return "org";
    }

    @GetMapping("biz")
    @FrontModel
    public String biz(Model model) {
        return "biz";
    }

    @GetMapping({"recruit","recruit-list"})
    @FrontModel
    public String recruitList(Model model,@RequestParam(defaultValue = "1")Integer pageNum,@RequestParam(defaultValue = "5")Integer pageSize) {
        PageInfo<RecruitInfoBO> pageInfo = recruitService.pageQueryAll(pageNum, pageSize);
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
        model.addAttribute("totalSizes", pageInfo.getTotal());
        return "recruit-list";
    }

    @GetMapping("recruit-detail")
    @FrontModel
    public String recruitDetail(Model model,@RequestParam Integer id) {
        model.addAttribute("info",recruitService.getById(Long.parseLong(id+"")));
        return "recruit-detail";
    }

    @GetMapping("recruit-process")
    @FrontModel
    public String recruitProcess(Model model) {
        return "recruit-process";
    }

    @GetMapping("contact")
    @FrontModel
    public String contact(Model model) {
        return "contact";
    }
}