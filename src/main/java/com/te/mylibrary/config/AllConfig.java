package com.te.mylibrary.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({DefaultConfig.class,
	ControllerAndServiceConfig.class,
	DAOconfig.class})
public class AllConfig {

}
