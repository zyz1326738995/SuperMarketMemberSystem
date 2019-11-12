package com.hz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy //网关注解涵盖@EnableDiscoveryClient注解
public class MemberCloudZuulApplication {

    public static void main(String[] args) {
        SpringApplication.run(MemberCloudZuulApplication.class, args);
    }

}
