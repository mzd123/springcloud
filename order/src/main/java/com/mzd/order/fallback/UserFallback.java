package com.mzd.order.fallback;

import com.mzd.order.feign.UserFeign;
import org.springframework.stereotype.Component;

@Component
public class UserFallback implements UserFeign {
    @Override
    public String getUser(String name) {
        return "aaaaaaaa";
    }


}
