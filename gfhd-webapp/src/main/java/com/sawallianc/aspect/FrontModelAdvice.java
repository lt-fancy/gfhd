package com.sawallianc.aspect;

import com.sawallianc.annotation.FrontModel;
import com.sawallianc.service.MenuService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.lang.reflect.Method;

@Aspect
@Component
public class FrontModelAdvice {

    @Autowired
    private MenuService menuService;

    public FrontModelAdvice() {
    }

    @Pointcut("@annotation(frontModel)")
    public void cache(FrontModel frontModel){

    }

    @Before("cache(frontModel)")
    public Object proceed(JoinPoint joinPoint, FrontModel frontModel) throws Throwable{
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Method method = methodSignature.getMethod();
        Object[] objs = joinPoint.getArgs();
        Model model = (Model) objs[0];
        GetMapping get = method.getAnnotation(GetMapping.class);
        String ename = get.value()[0];
        ename = ename.replaceAll("/","");
        if(ename.contains("-")){
            ename = ename.substring(0,ename.indexOf("-"));
        }
        model.addAttribute("menus", menuService.queryAllParentMenuOnly());
        model.addAttribute("menuEname",ename);
        model.addAttribute("children", menuService.queryChildrenByEname(ename));
        return model;
    }
}
