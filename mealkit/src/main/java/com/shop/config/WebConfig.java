package com.shop.config;



import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

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
              .addPathPatterns("/wish/**")
              .addPathPatterns("/order")
              .excludePathPatterns("/", "/fonts/**", "/css/**", "/images/**", "/js/**", "/customer/login", "/logincheck.do*");
  }
}