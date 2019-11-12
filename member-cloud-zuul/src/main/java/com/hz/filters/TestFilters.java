/*
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
public class TestFilters extends ZuulFilter {

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
        String username=request.getParameter("username");
        String userpwd=request.getParameter("userpwd");
        System.out.println("name==="+username);
        System.out.println("userpwd==="+userpwd);
        String token = request.getHeader("token");
        System.out.println("token:"+token);
        if(!request.getRequestURI().split( "/")[2].equals("loginUser"))
        {
            if(EmptyUtils.isEmpty(token)|| EmptyUtils.isEmpty(redisUtil.getStr(token)))
            {
                requestContext.setSendZuulResponse(false);
                requestContext.setResponseBody("Login failure");
            }
        }else{
                System.out.println("已经登录，放行.....");
        }

        System.out.println("url====="+request.getRequestURI());
        */
/*if(EmptyUtils.isEmpty(userpwd)){
            System.out.println("userpwd==="+null+"空的");
        }
      if(!"zyz".equals(username)||!"123456".equals(userpwd)){
            requestContext.setSendZuulResponse(false);
            requestContext.setResponseStatusCode(401);
            requestContext.setResponseBody("error login");
        }*//*

        return null;
    }

}
*/
