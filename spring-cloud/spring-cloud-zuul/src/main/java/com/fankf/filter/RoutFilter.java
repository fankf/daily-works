package com.fankf.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Component
@Slf4j
public class RoutFilter extends ZuulFilter {

    /**
     * 过滤时间
     * pre：路由之前
     * routing：路由之时
     * post： 路由之后
     * error：发送错误调用
     */
    @Override
    public String filterType() {
        return "pre";
    }

    // 过滤顺序
    @Override
    public int filterOrder() {
        return 0;
    }

    //true 永远过滤
    @Override
    public boolean shouldFilter() {
        return true;
    }


    @Override
    public Object run() throws ZuulException {
        RequestContext context = RequestContext.getCurrentContext();
        HttpServletRequest request = context.getRequest();
        log.info("请求数据：{}", request.getRequestURL());
        if (request.getRequestURL().toString().contains("a")) {
            log.info("-------------->>>>>>>>>>>>>>");
        }
        String token = request.getParameter("token");
        if (token == null) {
            context.setSendZuulResponse(false);
            context.setResponseStatusCode(401);
            try {
                context.getResponse().getWriter().write("token is null");
            } catch (IOException e) {
            }
            return null;
        }
        return null;
    }
}
