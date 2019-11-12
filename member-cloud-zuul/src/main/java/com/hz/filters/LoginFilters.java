package com.hz.filters;

import com.hz.utils.EmptyUtils;
import com.hz.utils.RedisUtil;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
@Component
public class LoginFilters extends ZuulFilter {

    @Resource
    private RedisUtil redisUtil;

    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        RequestContext ctx=RequestContext.getCurrentContext();
        return ctx.sendZuulResponse();//默认true
    }

    @Override
    public Object run() {
        RequestContext requestContext=RequestContext.getCurrentContext();
        HttpServletRequest request=requestContext.getRequest();

        String admin_name=request.getParameter("admin_name");
        String admin_pwd=request.getParameter("admin_pwd");

        String token = request.getHeader("token");
        System.out.println("token:"+token);
        if(!request.getRequestURI().split( "/")[2].equals("getAdminByNamePwd"))// 如果是登录功能之外的其他请求会进入if下面进行判断
        {
            if(EmptyUtils.isEmpty(token)|| EmptyUtils.isEmpty(redisUtil.getStr(token)))
            {
                System.out.println("aaaa:"+"jinrule");
                requestContext.setSendZuulResponse(false);
                requestContext.setResponseBody("failure");
            }
        }else{//如果是登录功能
            System.out.println("aaaa:"+"jinrule");
            requestContext.setSendZuulResponse(false);
            requestContext.setResponseBody("aa failure");
           System.out.println("已经登录，放行.....");
        }
        System.out.println("url====="+request.getRequestURI());
        return null;
    }
}
