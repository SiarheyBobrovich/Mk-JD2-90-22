package by.it_academy.jd2.json;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.InjectableValues;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class StudentDeleteTest {

    private static ObjectMapper mapper = new ObjectMapper();
    private static String json =
            "{\n" +
            "  \"name\": \"Siarhey\",\n" +
            "  \"score\": 2.2\n" +
            "}";

    @Test
    void serialize() throws JsonProcessingException {
        StudentDelete.Builder builder = StudentDelete.create();
        builder.setName("Siarhey");
        builder.setScore(2.2);
        StudentDelete build = builder.build();

        String student = mapper.writeValueAsString(build);

        System.out.println(student);

        Assertions.assertTrue(student.contains("id"));
        Assertions.assertTrue(student.contains("0"));
        Assertions.assertTrue(student.contains("name"));
        Assertions.assertTrue(student.contains("Siarhey"));
        Assertions.assertTrue(student.contains("score"));
        Assertions.assertTrue(student.contains("2.2"));
    }

    @Test
    void deserialize2() throws IOException {
        InjectableValues.Std id = new InjectableValues.Std().addValue(int.class, 123);

        StudentDelete studentDelete = mapper.reader(id)
                .readValue(json, StudentDelete.class);

        System.out.println(studentDelete);

        Assertions.assertTrue(studentDelete.getId() == 123);

    }
}