package com.example.KJ_NoticeBoard.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.servlet.HandlerInterceptor;

public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        Object user = session.getAttribute("user");

        // 로그인하지 않은 경우 로그인 페이지로 리다이렉트
        if (user == null) {
            response.sendRedirect("/login");
            return false;
        }
        return true;
    }
}
