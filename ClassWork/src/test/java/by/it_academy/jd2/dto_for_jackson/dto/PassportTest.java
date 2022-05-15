package by.it_academy.jd2.dto_for_jackson.dto;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

class PassportTest {

    private static ObjectMapper mapper = new ObjectMapper();

    private static final Passport passport = new Passport("123",
            "1",
             "Geroev",
             LocalDate.ofEpochDay(6386)
    );

    private static final String JSON_SERIALIZE_PASSPORT =
            "{\"id\":\"123\",\"id_citizen\":\"1\",\"create_date\":6386,\"address\":\"Geroev\"}";
    private static final String JSON_DESERIALIZE_PASSPORT =
            "{\n" +
                "  \"id\": \"123\",\n" +
                "  \"id_citizen\": \"1\",\n" +
                "  \"address\": \"Geroev\",\n" +
                "  \"create_date\": 6386\n" +
            "}";

    @BeforeAll
    static void init() {
        mapper.registerModule(new JavaTimeModule());
    }

    @Test
    void serializeTest() throws JsonProcessingException {

        String pass = mapper.writeValueAsString(passport);

        System.out.println(pass);

        Assertions.assertEquals(JSON_SERIALIZE_PASSPORT, pass);
    }

    @Test
    void deserializeTest() throws JsonProcessingException {
        Passport passport = mapper.readValue(JSON_DESERIALIZE_PASSPORT, Passport.class);
        System.out.println(passport);
    }
}