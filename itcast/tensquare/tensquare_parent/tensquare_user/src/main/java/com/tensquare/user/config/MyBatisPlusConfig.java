package com.tensquare.user.config;

import com.baomidou.mybatisplus.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName MyBatisPlusConfig
 * @Description
 * @Author xlf
 * @Date 2020/10/23 1:53
 **/
@Configuration
@MapperScan("com.tensquare.user.dao")
public class MyBatisPlusConfig {
	@Bean
	public PaginationInterceptor createPaginationInterceptor(){
		return new PaginationInterceptor();
	}
}
