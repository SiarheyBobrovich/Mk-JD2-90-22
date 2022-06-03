package org.it_academy.currency.dto;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValueTest {

    private static final ObjectMapper mapper = new ObjectMapper()
            .setPropertyNamingStrategy(PropertyNamingStrategies.LOWER_CAMEL_CASE);

    @Test
    void deserialize() throws JsonProcessingException {
        String body =
                "{\n" +
                "    \"code\" : \"USD\",\n" +
                "    \"name\" : \"United states\",\n" +
                "    \"description\" : \"Супер грошы\" \n" +
                "}";

        Value value = mapper.readValue(body, Value.class);

        Assertions.assertEquals("USD" , value.getCode());
        Assertions.assertEquals("United states" , value.getName());
        Assertions.assertEquals("Супер грошы" , value.getDescription());
    }

    @Test
    void deserialize2() throws JsonProcessingException {
        String body =
                "{\n" +
                "    \"id\" : 4,\n" +
                "    \"description\" : \"Такие себе грошы\"\n" +
                "}";

        Value value = mapper.readValue(body, Value.class);

        Assertions.assertEquals(4 , value.getId());
        Assertions.assertEquals("Такие себе грошы" , value.getDescription());
    }
}