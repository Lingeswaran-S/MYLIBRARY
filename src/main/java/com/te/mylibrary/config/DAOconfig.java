package com.te.mylibrary.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.te.mylibrary.dao.MyDAO;

@Configuration
public class DAOconfig {
	@Bean(name = "DAO_object")
	public MyDAO getMyDAOObj() {
		return new MyDAO();
		
	}

}
