package com.mzd.useriface;


import org.springframework.web.bind.annotation.RequestParam;

public interface UserServiceiface {
    String getUser(@RequestParam("name") String name);
}
