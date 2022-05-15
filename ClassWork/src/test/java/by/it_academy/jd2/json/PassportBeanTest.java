package by.it_academy.jd2.json;

import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.time.LocalDate;


class PassportBeanTest {

    @Test
    void testJsonSerialize() throws IOException {
        ObjectMapper mapper = new ObjectMapper().registerModule(new JavaTimeModule());

        PassportBean bean = new PassportBean("999", "1", LocalDate.ofEpochDay(6386));

        String s = mapper.writeValueAsString(bean);

        Assertions.assertTrue(s.contains("personId"));
        Assertions.assertTrue(s.contains("createDate"));
        Assertions.assertTrue(s.contains("id"));
    }

    @Test
    void testJson() throws IOException {

        PassportBean bean = new ObjectMapper().registerModule(new JavaTimeModule())
                .readValue("{\n" +
                        "  \"id\": \"123\",\n" +
                        "  \"personId\": \"1\",\n" +
                        "  \"createDate\": 6385\n" +
                        "}", PassportBean.class);

        Assertions.assertEquals("123", bean.getId());
        Assertions.assertEquals("1", bean.getPersonId());
        Assertions.assertEquals(LocalDate.ofEpochDay(6385), bean.getCreateDate());
    }
}