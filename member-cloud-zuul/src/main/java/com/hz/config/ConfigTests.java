package com.hz.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class ConfigTests {

    //@Value("${bus}")
    private String bus;

    /**
     *@Value("${url}")获取yml或者properties配置文件的属性值 http://127.0.0.1:7782/getName 从git仓库获取
     */
    //@Value("${eurekaurl}")
    private String url;

    @RequestMapping("/getName")
    public String getName(){

        System.out.println("name"+this.bus);
        System.out.println("name"+this.url);
        return this.bus;
    }
/*
* localhost:8099/bus/refresh  在github仓库改变zull项目的配置数据 不用重启项目运行localhost:8099/bus/refresh post请求 回调函数返回值为空 仓库数据已经同步到项目的配置
* webhook功能
 *
 * 在本项目的yml里配置数据值${name}  ${url}  在github仓库里面有对应数据  即可获取 托放在远程仓库较为安全 也可对文件进行加密 但是拉取到的是加密后的数据
 *
 * http://127.0.0.1:8099/demo-cloud-config/dev/master 从远程仓库拉取数据
 *
 * http://127.0.0.1:8099/encrypt/status 测试项目是否可以加密
 *
 * http://127.0.0.1:8099/encrypt 参数  对参数进行加密  放在github仓库托管
 * 加密在github仓库存放实例:
 * url= http://root:123456@localhost:7777/eureka/
 * url={cipher}e111145c8529072dd4dbcb23ff5afcb9c68f72b13cbc333825fb68237bd09162e3d9c279291c5a441debfb4a37c0daba0675d0d2e3afac35ecd1e8f86bdaf3a1545c
*
* */


}
