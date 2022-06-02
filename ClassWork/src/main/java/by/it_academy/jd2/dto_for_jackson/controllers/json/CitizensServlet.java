package by.it_academy.jd2.dto_for_jackson.controllers.json;

import by.it_academy.jd2.dto_for_jackson.dto.Citizen;
import by.it_academy.jd2.dto_for_jackson.services.CitizensService;
import by.it_academy.jd2.dto_for_jackson.services.api.IJsonService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CitizensServlet", urlPatterns = "/citizens")
public class CitizensServlet extends HttpServlet {
    private final IJsonService<Citizen> service = CitizensService.getInstance();
    private final ObjectMapper mapper;

    public CitizensServlet() {
        mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule())
                .setPropertyNamingStrategy(PropertyNamingStrategies.SNAKE_CASE)
                .disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json; charset=UTF-8");
        mapper.registerModule(new JavaTimeModule());

        resp.getWriter().write(
                mapper.writeValueAsString(service.getAll())
        );
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        ServletInputStream inputStream = req.getInputStream();

        while (inputStream.isReady()) {
            Citizen student = mapper.readValue(inputStream, Citizen.class);

            service.save(student);
        }
    }
}
