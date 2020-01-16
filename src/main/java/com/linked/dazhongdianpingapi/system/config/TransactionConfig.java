package com.linked.dazhongdianpingapi.system.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * @author Simo
 * @date 2019/01/15
 * @Description: 通一事务管理配置
 */
@Configuration
@ImportResource(locations = "classpath:/spring/spring-trans.xml")
public class TransactionConfig {

}
