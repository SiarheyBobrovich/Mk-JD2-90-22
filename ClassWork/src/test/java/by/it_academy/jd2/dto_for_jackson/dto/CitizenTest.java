package by.it_academy.jd2.dto_for_jackson.dto;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

class CitizenTest {

    private static ObjectMapper mapper = new ObjectMapper();

    private static final Passport passport = new Passport("123",
            "1",
            "Geroev",
            LocalDate.ofEpochDay(1)
    );

    private static final Citizen citizen = new Citizen();

    private static final String JSON_SERIALIZE_CITIZEN =
            "{" +
                    "\"id\":\"1\"," +
                    "\"passport\":{" +
                        "\"id\":\"123\"," +
                        "\"id_citizen\":\"1\"," +
                        "\"create_date\":1," +
                        "\"address\":\"Geroev\"" +
                    "}," +
                    "\"name\":\"Siarhey\"," +
                    "\"birthday\":\"1987-06-27\"" +
                    "}";
    private static final String JSON_DESERIALIZE_CITIZEN =
            "{\n" +
                "  \"id\": \"1\",\n" +
                "  \"passport\": {\n" +
                "    \"id\": \"123\",\n" +
                "    \"id_citizen\": \"1\",\n" +
                "    \"create_date\": 1,\n" +
                "    \"address\": \"Geroev\"\n" +
                "  },\n" +
                "  \"name\": \"Siarhey\",\n" +
                "  \"birthday\": \"1987-06-27\"\n" +
            "}";

    @BeforeAll
    static void init() {
        mapper.registerModule(new JavaTimeModule())
                .setPropertyNamingStrategy(PropertyNamingStrategies.SNAKE_CASE);

        citizen.setName("Siarhey");
        citizen.setId("1");
        citizen.setPassport(passport);
        citizen.setBirthday(LocalDate.ofEpochDay(6386));
    }

    @Test
    void serializeTest() throws JsonProcessingException {
        String citizen = mapper.writeValueAsString(CitizenTest.citizen);

        Assertions.assertEquals(JSON_SERIALIZE_CITIZEN, citizen);
    }

    @Test
    void deserializeTest() throws JsonProcessingException {
        Citizen citizen1 = mapper.readValue(JSON_DESERIALIZE_CITIZEN, Citizen.class);
        System.out.println(citizen1);
        System.out.println(citizen);

        Assertions.assertEquals(citizen.toString(), citizen1.toString());
    }

}