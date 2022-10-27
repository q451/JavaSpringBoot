package com.example.demo.util;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class JwtFilters implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("token");
        if (StringUtils.isEmpty(token)){
            return false;
        }
        try {
            JwtUtil.verifyToken(token);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
