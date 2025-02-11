package com.example.demo.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;

@Configuration
public class BeanDefine {

	@Bean
	Mapper mapper() {
		return DozerBeanMapperBuilder.buildDefault();
	}
}
