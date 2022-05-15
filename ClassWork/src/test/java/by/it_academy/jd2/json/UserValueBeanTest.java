package by.it_academy.jd2.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;


public class UserValueBeanTest {

    @Test
    public void testUserValueBean() throws JsonProcessingException {
        UserValueBean user = new UserValueBean(1, "Siarhey");

        String value = new ObjectMapper().writeValueAsString(user);

        System.out.println(value);

        Assertions.assertEquals("\"UserValueBean{id=1, firstName='Siarhey'}\"", value);


    }

}