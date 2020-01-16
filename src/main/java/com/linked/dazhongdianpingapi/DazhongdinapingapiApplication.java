package com.linked.dazhongdianpingapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import tk.mybatis.spring.annotation.MapperScan;

@EnableSwagger2
@SpringBootApplication
@MapperScan(basePackages = "com.linked.dazhongdianpingapi.business.dao.*")
public class DazhongdinapingapiApplication {

    public static void main(String[] args) {
        SpringApplication.run(DazhongdinapingapiApplication.class, args);
    }

}
