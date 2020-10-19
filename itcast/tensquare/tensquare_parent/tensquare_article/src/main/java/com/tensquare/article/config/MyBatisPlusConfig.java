package com.tensquare.article.config;

import com.baomidou.mybatisplus.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName MyBatisPlusConfig
 * @Description
 * @Author xlf
 * @Date 2020/10/20 0:17
 **/
@Configuration
@MapperScan("com.tensquare.article.dao*")
public class MyBatisPlusConfig {
	@Bean
	public PaginationInterceptor createPaginationInterceptor() {
		return new PaginationInterceptor();
	}
}
