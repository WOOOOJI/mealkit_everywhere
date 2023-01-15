package com.shop.config;



import org.apache.catalina.Context;
import org.apache.catalina.connector.Connector;
import org.apache.coyote.http11.Http11NioProtocol;
import org.apache.tomcat.util.descriptor.web.SecurityCollection;
import org.apache.tomcat.util.descriptor.web.SecurityConstraint;
import org.apache.tomcat.util.net.SSLHostConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.io.File;
import java.nio.file.Paths;

@Configuration
public class WebConfig implements WebMvcConfigurer {

  private final LoginCheckInterceptor loginInterceptor;

  public WebConfig(LoginCheckInterceptor loginInterceptor) {
      this.loginInterceptor = loginInterceptor;
  }

  @Override
  public void addResourceHandlers(ResourceHandlerRegistry registry) {
      registry.addResourceHandler("/css/**") // /m 으로 시작하는 요청이 오면
              .addResourceLocations("classpath:/static/css/") // classpath 기준으로 m 디렉토리 밑에서 제공
//              .setCachePeriod(20); // 20초
      ;
      registry.addResourceHandler("/js/**") // /m 으로 시작하는 요청이 오면
              .addResourceLocations("classpath:/static/js/") // classpath 기준으로 m 디렉토리 밑에서 제공
//              .setCachePeriod(20); // 20초
      ;
      registry.addResourceHandler("/images/**") // /m 으로 시작하는 요청이 오면
              .addResourceLocations("classpath:/images/") // classpath 기준으로 m 디렉토리 밑에서 제공
//              .setCachePeriod(20); // 20초
      ;
  }

  @Override
  public void addInterceptors(InterceptorRegistry registry) {
      registry.addInterceptor(loginInterceptor)
              .addPathPatterns("/cart/**")
              .excludePathPatterns("/", "/fonts/**", "/css/**", "/images/**", "/js/**", "/customer/login", "/logincheck.do*");
  }
}