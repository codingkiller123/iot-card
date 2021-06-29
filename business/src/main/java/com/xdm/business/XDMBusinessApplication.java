package com.xdm.business;

import com.xdm.common.security.annotation.EnableCustomConfig;
import com.xdm.common.security.annotation.EnableRyFeignClients;
import com.xdm.common.swagger.annotation.EnableCustomSwagger2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableCustomConfig
@EnableCustomSwagger2
@EnableRyFeignClients
@SpringBootApplication
public class XDMBusinessApplication {

    public static void main(String[] args) {
        SpringApplication.run(XDMBusinessApplication.class, args);
        System.out.println("(♥◠‿◠)ﾉﾞ  卡业务模块启动成功   ლ(´ڡ`ლ)ﾞ  ");
    }
}
