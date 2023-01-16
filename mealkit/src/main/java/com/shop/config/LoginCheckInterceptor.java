package com.shop.config;

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
        String email = (String)session.getAttribute("email");

        if(email != null) {
            return true;
        } else {
            try {
                response.sendRedirect("/customer/login");
                
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("돌아가 제발;;;");
            return false;
        }
    }
}
