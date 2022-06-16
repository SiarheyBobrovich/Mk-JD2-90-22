package org.it_academy.spring_currency.config;

import org.it_academy.spring_currency.api.CRUD.ICRUDDao;
import org.it_academy.spring_currency.dao.CurrencyDao;
import org.it_academy.spring_currency.dao.IEntityManager;
import org.it_academy.spring_currency.dao.Manager;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;
import java.util.Properties;

@Configuration
public class DaoConfig {

    @Bean
    public ICRUDDao dao(IEntityManager manager) {
        return new CurrencyDao(manager);
    }

    @Bean
    public IEntityManager manager(@Value("${login}") String login,
                                  @Value("${password}") String pass) {
        Properties properties = new Properties();
        properties.putAll(Map.of(
                "jakarta.persistence.jdbc.user", login,
                "jakarta.persistence.jdbc.password", pass
        ));

        return new Manager(properties);
    }

}
