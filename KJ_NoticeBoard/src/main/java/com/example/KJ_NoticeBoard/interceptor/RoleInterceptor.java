package com.example.KJ_NoticeBoard.interceptor;

import com.example.KJ_NoticeBoard.dto.UserDTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.servlet.HandlerInterceptor;

public class RoleInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        UserDTO user = (UserDTO) session.getAttribute("user");

        // 유저 권한이 root(1)가 아닌 경우 접근 금지
        if (user != null && user.getGrade() != 1) {
            response.sendRedirect("/accessDenied");
            return false;
        }
        return true;
    }
}
