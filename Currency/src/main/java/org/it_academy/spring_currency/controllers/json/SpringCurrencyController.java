package org.it_academy.spring_currency.controllers.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.it_academy.spring_currency.api.CRUD.ICRUDService;
import org.it_academy.spring_currency.services.CurrencyService;
import org.it_academy.spring_currency.controllers.utils.ControllerUtils;
import org.it_academy.spring_currency.dto.CurrencyDto;
import org.it_academy.spring_currency.dto.CurrencyId;
import org.it_academy.spring_currency.dto.Value;
import org.it_academy.spring_currency.exceptions.CurrencyServiceException;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "SpringCurrencyController", urlPatterns = "/spring/currency")
public class SpringCurrencyController extends HttpServlet {

    private final ObjectMapper mapper;
    private final ICRUDService service;

    public SpringCurrencyController() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application.xml");

        service = context.getBean(CurrencyService.class);

        mapper = context.getBean(ObjectMapper.class)
                .setPropertyNamingStrategy(PropertyNamingStrategies.SNAKE_CASE)
                .registerModule(new JavaTimeModule());


        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ControllerUtils.setEncodingType(req, resp);

        PrintWriter writer = resp.getWriter();
        String parameter = req.getParameter("id");
        String json;

        if (parameter != null) {
            try {
                long id = Long.parseLong(parameter);
                json = mapper.writeValueAsString(service.get(id));

            } catch (NumberFormatException e) {
                resp.setStatus(400);
                return;
            }catch (CurrencyServiceException e) {
                resp.setStatus(e.getStatus());
                return;
            }

        }else {
            json = mapper.writeValueAsString(service.getAll());
        }

        resp.setContentType("application/json");
        writer.write(json);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        postPutDelete(req, resp);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        postPutDelete(req, resp);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        postPutDelete(req, resp);
    }

    private void postPutDelete(HttpServletRequest req, HttpServletResponse resp) {
        Value value;
        CurrencyId currencyId;
        CurrencyDto currencyDto;

        try {
            ControllerUtils.setEncodingType(req, resp);



            switch (req.getMethod()) {
                case "POST" :
                    currencyDto = mapper.readValue(req.getInputStream(), CurrencyDto.class);

                    long id = service.save(currencyDto);

                    resp.setContentType("application/json");
                    resp.getWriter().write(String.valueOf(id));
                    break;

                case "PUT" :
                    value = mapper.readValue(req.getInputStream(), Value.class);
                    service.update(value);

                    resp.setStatus(204);
                    break;

                case "DELETE" :
                    currencyId = mapper.readValue(req.getInputStream(), CurrencyId.class);
                    service.delete(currencyId);

                    resp.setStatus(204);
                    break;
            }

        }catch (JsonProcessingException e) {
            resp.setStatus(415);

        }catch (CurrencyServiceException e) {
            resp.setStatus(e.getStatus());

        }catch (IOException e) {
            log(e.getMessage(), e);
        }
    }
}
