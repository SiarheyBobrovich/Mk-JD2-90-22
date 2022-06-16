package org.it_academy.spring_currency.config;

import org.springframework.context.annotation.*;

@Configuration
@PropertySource("classpath:properties/hibernate.properties")
@Import(ControllerConfig.class)
public class AppConfig {

}
