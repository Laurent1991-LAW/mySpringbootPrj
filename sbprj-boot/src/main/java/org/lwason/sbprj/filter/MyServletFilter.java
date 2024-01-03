package org.lwason.sbprj.filter;

import com.lwason.sbprj.common.entity.CurrentContext;
import com.lwason.sbprj.common.entity.UserInfo;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 自定义过滤器需要注册到spring， 见MyInitConfig
 */
@Slf4j
public class MyServletFilter extends HttpFilter {

    private static final String GLOBAL_BUSI_TRACK_NO = "GLOBAL_BUSI_TRACK_NO";
    private static final String X_ER_TOKEN = "X_ER_TOKEN";
    private static final String USER_INFO = "USER_INFO";

    @Override
    protected void doFilter(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain chain) throws IOException, ServletException {
        try {
            putIntoContext(request);
            chain.doFilter(request, response);
        } catch (Exception e) {
            log.warn("初始化CurrentContext异常", e);
        }
    }

    private void putIntoContext(HttpServletRequest request) {
        String trackNo = request.getHeader(GLOBAL_BUSI_TRACK_NO);
        String token = request.getHeader(X_ER_TOKEN);
        // token解析为user信息
        UserInfo nathan = UserInfo.builder().usrName("Nathan").accountNo("19911122").instNo("110093").build();
        CurrentContext.set(GLOBAL_BUSI_TRACK_NO, trackNo);
        CurrentContext.set(USER_INFO, nathan);
    }
}
