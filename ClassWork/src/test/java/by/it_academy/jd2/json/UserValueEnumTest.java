package by.it_academy.jd2.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;


public class UserValueEnumTest {

    @Test
    public void testUserValueEnum() throws JsonProcessingException {
        UserValueEnum enumTest = UserValueEnum.FIRST_NAME;

        String value = new ObjectMapper().writeValueAsString(enumTest);
        System.out.println(value);

        Assertions.assertTrue(value.contains("\"Siarhey\""));

        UserValueEnum userValueEnum = new ObjectMapper().readValue(value, UserValueEnum.class);
        Assertions.assertEquals(UserValueEnum.FIRST_NAME, userValueEnum);
    }

}