package com.rimi.zuulserver.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 前置过滤器
 *
 * @author admin
 * @date 2019-07-19 09:55
 */
@Component
public class PreFilter extends ZuulFilter {

    /**
     * 过滤器的类型，前置过滤器，路由过滤器，后置过滤器
     *
     * @return
     */
    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }

    /**
     * 过滤器的级别
     *
     * @return
     */
    @Override
    public int filterOrder() {
        return 0;
    }


    /**
     * 是否要执行过滤器,写逻辑操作
     *
     * @return
     */
    @Override
    public boolean shouldFilter() {
        //RequestContext context = RequestContext.getCurrentContext();
        //return !context.containsKey(FilterConstants.FORWARD_TO_KEY)
        //        && context.containsKey(FilterConstants.SERVICE_ID_KEY);
        return true;
    }


    /**
     * 过滤器的规则
     *
     * @return
     * @throws ZuulException
     */
    @Override
    public Object run() throws ZuulException {
        RequestContext context = RequestContext.getCurrentContext();
        // 获取request
        HttpServletRequest request = context.getRequest();
        // 获取参数
        String token = request.getParameter("token");
        // 验证
        // TODO 执行SQL或者查询NoSQL获取相关数据
        if (token==null){
            try {
                // 设置
                context.setResponseStatusCode(401);
                // 不再进行路由过滤
                context.setSendZuulResponse(false);
                HttpServletResponse response = context.getResponse();
                response.setContentType("text/html;charset=utf-8");
                response.setCharacterEncoding("UTF-8");
                response.getWriter().write("token为空");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
