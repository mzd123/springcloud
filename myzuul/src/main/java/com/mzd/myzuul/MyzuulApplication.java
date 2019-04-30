package com.mzd.myzuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.netflix.zuul.ZuulProxyAutoConfiguration;
import org.springframework.cloud.netflix.zuul.filters.ZuulProperties;

@SpringBootApplication
@EnableZuulProxy
@EnableEurekaClient
public class MyzuulApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyzuulApplication.class, args);
    }


//    @RefreshScope
//    @ConfigurationProperties("zuul")
//    public ZuulProperties getZuulProperties() {
//        return new ZuulProperties();
//    }

}
