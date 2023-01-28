package com.shop.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

  private final LoginCheckInterceptor loginInterceptor;

  public WebConfig(LoginCheckInterceptor loginInterceptor) {
      this.loginInterceptor = loginInterceptor;
  }

  @Override
  public void addInterceptors(InterceptorRegistry registry) {
      registry.addInterceptor(loginInterceptor)
              .addPathPatterns("/cart/**")
              .addPathPatterns("/wish/**")
              .addPathPatterns("/order")
              .excludePathPatterns("/", "/fonts/**", "/css/**", "/images/**", "/js/**", "/customer/login", "/logincheck.do*");
  }
}