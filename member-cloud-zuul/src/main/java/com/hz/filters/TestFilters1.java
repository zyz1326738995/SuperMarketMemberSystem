/*
package com.hz.filters;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.springframework.stereotype.Component;

@Component
public class TestFilters1 extends ZuulFilter {
    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 1;
    }

    @Override
    public boolean shouldFilter() {
        RequestContext requestContext = RequestContext.getCurrentContext();

        return requestContext.sendZuulResponse();//默认true
    }

    @Override
    public Object run() {
        System.out.println("第二个过滤器==="+000000);
        return null;
    }
}
*/
