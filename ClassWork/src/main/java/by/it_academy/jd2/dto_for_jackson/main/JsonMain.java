package by.it_academy.jd2.dto_for_jackson.main;

import by.it_academy.jd2.dto_for_jackson.dto.Citizen;
import by.it_academy.jd2.dto_for_jackson.dto.Passport;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.time.LocalDate;

public class JsonMain {

    public static void main(String[] args) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());

        Passport geroev = new Passport("123",
                "1",
                "Geroev",
                LocalDate.of(1987, 6, 27)
        );

        Citizen citizen = new Citizen();
        citizen.setId("1");
        citizen.setBirthday(LocalDate.now());
        citizen.setName("Siarhey");
        citizen.setPassport(geroev);

        String pass = mapper.writeValueAsString(citizen);
        System.out.println("Json serialize: " + pass);

        String deserialize = "{\n" +
                "  \"id\": \"1\",\n" +
                "  \"passport\": {\n" +
                "    \"id\": \"123\",\n" +
                "    \"id_citizen\": \"1\",\n" +
                "    \"address\": \"Geroev\",\n" +
                "    \"create_date\": 6386\n" +
                "  },\n" +
                "  \"name\": \"Siarhey\",\n" +
                "  \"birthday\": \"2022-05-13\"\n" +
                "}";

        Citizen citizen1 = mapper.readValue(deserialize, Citizen.class);
        System.out.println("Json deserialize: " + citizen1);


    }
}
