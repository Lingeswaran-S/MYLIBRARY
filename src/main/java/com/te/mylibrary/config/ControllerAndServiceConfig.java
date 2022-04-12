package com.te.mylibrary.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.te.mylibrary.controller.MyController;
import com.te.mylibrary.service.MyService;

@Configuration
public class ControllerAndServiceConfig {
	@Bean(name = "controller")
	public MyController getController() {
		return new MyController();
	}
	@Bean(name = "service")
	public MyService getService() {
		return new MyService();
	}

}
