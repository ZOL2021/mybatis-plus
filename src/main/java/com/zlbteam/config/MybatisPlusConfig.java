package com.zlbteam.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * 配置 mybatis plus
 * @author zhoulibin
 */
@Configuration
@MapperScan("com.zlbteam.mapper")
@EnableTransactionManagement
public class MybatisPlusConfig {
}
