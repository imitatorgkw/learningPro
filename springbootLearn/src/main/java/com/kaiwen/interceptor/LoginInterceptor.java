package com.kaiwen.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 拦截器
 * 登陆检查
 * */

@Slf4j
public class LoginInterceptor implements HandlerInterceptor {

    //目标方法执行前
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String requestURL = request.getRequestURI();
        log.info("拦截的请求路径{}", requestURL);

        //登录检查逻辑
        //如果登录了就return true 否则 return false
        HttpSession session = request.getSession();
        Object loginUser = session.getAttribute("loginUser");
        if (loginUser != null)
            return true;

        request.setAttribute("msg", "请先登录");
        //重定向,把原生的request和response都转过去了
        request.getRequestDispatcher("/hello").forward(request,response);

        return false;
    }


    //目标方法执行后，页面渲染之前
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    //页面渲染之后
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
