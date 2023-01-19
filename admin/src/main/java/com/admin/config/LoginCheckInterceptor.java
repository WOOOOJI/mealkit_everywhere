package com.admin.config;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class LoginCheckInterceptor implements HandlerInterceptor {

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("LoginInterceptor - {}", "호출완료");
        System.out.println("----------------------------------------------------------------------");

        HttpSession session = request.getSession();
        String adminid = (String)session.getAttribute("adminid");
        System.out.println(adminid);
        if(adminid != null) {
            return true;
        } else {
            try {
                response.sendRedirect("/admin/loginForm");
                System.out.println("돌아가 제발;;;");
            } catch (IOException e) {
                e.printStackTrace();
            }
            return false;
        }
    }
}
