package com.mzd.user.service;

import com.mzd.useriface.UserServiceiface;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
//开启刷新配置文件  @RefreshScope 如果不加上，则不生效
@RefreshScope
public class UserServiceImpl implements UserServiceiface {

    @Value("${server.port}")
    private String port;


    @Value("${mzd}")
    private String mzd;

    @RequestMapping("/getUser")
    public String getUser(@RequestParam("name") String name) {
        System.out.println("这里是user。。。");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "这里是user,名字为:" + name + ",端口为:" + port;
    }

    @RequestMapping("/getmzd")
    public String getmzd() {
        return mzd;
    }


    @RequestMapping("/getmzd2")
    public String getmzd2() {
        return "aaaaaaaaaaaaaaaa";
    }
}
