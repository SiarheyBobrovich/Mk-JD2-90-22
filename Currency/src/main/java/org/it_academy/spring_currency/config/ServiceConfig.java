package org.it_academy.spring_currency.config;

import org.it_academy.spring_currency.api.CRUD.ICRUDDao;
import org.it_academy.spring_currency.api.CRUD.ICRUDService;
import org.it_academy.spring_currency.services.CurrencyService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(DaoConfig.class)
public class ServiceConfig {

    @Bean
    public ICRUDService service(ICRUDDao dao) {
        return new CurrencyService(dao);
    }
}
