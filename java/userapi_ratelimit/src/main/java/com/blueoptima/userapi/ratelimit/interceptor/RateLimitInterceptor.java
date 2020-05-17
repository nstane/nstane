package com.blueoptima.userapi.ratelimit.interceptor;

import com.blueoptima.userapi.ratelimit.RateLimitHandler;
import com.blueoptima.userapi.ratelimit.config.RetaLimitConfigProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class RateLimitInterceptor extends HandlerInterceptorAdapter {

    private final RetaLimitConfigProperties retaLimitConfigProperties;

    private final RateLimitHandler rateLimitHandler;

    @Autowired
    public RateLimitInterceptor(RetaLimitConfigProperties retaLimitConfigProperties, RateLimitHandler rateLimitHandler) {
        this.retaLimitConfigProperties = retaLimitConfigProperties;
        this.rateLimitHandler = rateLimitHandler;
    }

    @Override
    public boolean preHandle(
            HttpServletRequest request,
            HttpServletResponse response,
            Object handler) {
        rateLimitHandler.handle(request, retaLimitConfigProperties);
        return true;
    }

    @Override
    public void afterCompletion(
            HttpServletRequest request,
            HttpServletResponse response,
            Object handler,
            Exception ex) {
    }
}
