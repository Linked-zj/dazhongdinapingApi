package com.linked.dazhongdianpingapi.system.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * @author Linked
 * @date 2020/5/4 17:00
 */
@Configuration
@ImportResource(locations = "classpath:/spring/spring-trans.xml")
public class TransactionConfig {

}
