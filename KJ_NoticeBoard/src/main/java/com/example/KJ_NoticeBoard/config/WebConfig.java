package com.example.KJ_NoticeBoard.config;

import com.example.KJ_NoticeBoard.interceptor.LoginInterceptor;
import com.example.KJ_NoticeBoard.interceptor.RoleInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 로그인 필요 인터셉터 등록
        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns("/list", "/addBook"); // 보호할 경로

        // 권한 필요 인터셉터 등록
        registry.addInterceptor(new RoleInterceptor())
                .addPathPatterns("/addBook", "/goDelete/*", "/goUpdate/*"); // 특정 경로 보호
    }
}
