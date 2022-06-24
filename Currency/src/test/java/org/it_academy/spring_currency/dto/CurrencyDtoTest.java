package org.it_academy.spring_currency.dto;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.it_academy.spring_currency.config.JsonToEpochDate;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.Jackson2ObjectMapperFactoryBean;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import static com.fasterxml.jackson.databind.PropertyNamingStrategies.SNAKE_CASE;

public class CurrencyDtoTest {

    private String json = "{\n" +
            "    \"code\" : \"RU\",\n" +
            "    \"name\" : \"Russia\",\n" +
            "    \"description\" : \"Копейки\" \n" +
            "}";

    @Test
    public void deserialize() throws JsonProcessingException {

        Jackson2ObjectMapperFactoryBean jackson2ObjectMapperFactoryBean = new Jackson2ObjectMapperFactoryBean();
        MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter = new MappingJackson2HttpMessageConverter();

        Map<Class<?>, JsonSerializer<?>> serializerMap = Map.of(LocalDateTime.class, new JsonToEpochDate());
        jackson2ObjectMapperFactoryBean.setObjectMapper(new ObjectMapper());
        jackson2ObjectMapperFactoryBean.setPropertyNamingStrategy(SNAKE_CASE);
        jackson2ObjectMapperFactoryBean.setModulesToInstall(JavaTimeModule.class);
        jackson2ObjectMapperFactoryBean.setSerializersByType(serializerMap);

        mappingJackson2HttpMessageConverter.setSupportedMediaTypes(List.of(MediaType.APPLICATION_JSON));
        mappingJackson2HttpMessageConverter.setObjectMapper(jackson2ObjectMapperFactoryBean.getObject());
        ObjectMapper objectMapper = mappingJackson2HttpMessageConverter.getObjectMapper();

        CurrencyDto currencyDto = objectMapper.readValue(json, CurrencyDto.class);
    }

}