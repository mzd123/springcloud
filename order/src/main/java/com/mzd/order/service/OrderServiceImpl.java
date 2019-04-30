package com.mzd.order.service;

import com.mzd.order.feign.UserFeign;
import com.mzd.orderiface.OrderServiceiface;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//开启刷新配置文件  @RefreshScope 如果不加上，则不生效
@RefreshScope
public class OrderServiceImpl implements OrderServiceiface {
    @Autowired
    private UserFeign userFeign;

    @Value("${mzd}")
    private String mzd;

    @RequestMapping("/getOrder")
    @HystrixCommand(fallbackMethod = "backMethod")
    public String getOrder(String name) {
        String str = userFeign.getUser(name);
        System.out.println(str);
        return "这里是order";
    }


//    @RequestMapping("/getOrder2")
//    public String getOrder(String name) {
//        String str = userFeign.getUser(name);
//        System.out.println(str);
//        return "这里是order";
//    }

    public String backMethod(String name) {
        return "服务熔断了。。。。";
    }

    @RequestMapping("/getmzd")
    public String getmzd() {
        return mzd;
    }
}
