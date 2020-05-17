package com.blueoptima.userapi;

import com.blueoptima.userapi.ratelimit.config.RetaLimitConfigProperties;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

@Component
@WebFilter("/")
public class UserAuthFilter implements Filter {

    @Autowired
    private final RetaLimitConfigProperties retaLimitConfigProperties;

    public UserAuthFilter(final RetaLimitConfigProperties retaLimitConfigProperties) {
        this.retaLimitConfigProperties = retaLimitConfigProperties;
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        final String userName = ((HttpServletRequest) servletRequest).getHeader("User-Name");

        if (StringUtils.isBlank(userName) || !isUserPresent(retaLimitConfigProperties, userName)) {
            final HttpServletResponse response = (HttpServletResponse) servletResponse;
            response.sendError(HttpStatus.NETWORK_AUTHENTICATION_REQUIRED.value(), "User Details missing in request.");
        } else {
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }

    private boolean isUserPresent(RetaLimitConfigProperties retaLimitConfigProperties, String userName) {
        return retaLimitConfigProperties.getConfigList().stream().anyMatch(config -> Objects.equals(config.getUserName(), userName));
    }
}
