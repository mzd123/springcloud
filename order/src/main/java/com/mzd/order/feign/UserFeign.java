package com.mzd.order.feign;

import com.mzd.order.fallback.UserFallback;
import com.mzd.useriface.UserServiceiface;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "mzd-user", fallback = UserFallback.class)
public interface UserFeign extends UserServiceiface {
    @RequestMapping("/getUser")
    String getUser(@RequestParam("name") String name);
}
