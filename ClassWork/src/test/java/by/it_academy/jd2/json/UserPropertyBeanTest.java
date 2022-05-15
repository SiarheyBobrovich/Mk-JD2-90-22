package by.it_academy.jd2.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;


public class UserPropertyBeanTest {

    @Test
    public void testUserPropertyBean() throws JsonProcessingException {
        UserPropertyBean user = new UserPropertyBean(1, "Siarhey");
        String value = new ObjectMapper().writeValueAsString(user);

        System.out.println(value);

        Assertions.assertTrue(value.contains("id"));
        Assertions.assertTrue(value.contains("\"name\":\"Siarhey\""));
        Assertions.assertTrue(value.contains("\"first-name\":\"Siarhey\""));
    }
}