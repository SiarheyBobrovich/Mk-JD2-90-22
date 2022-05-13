package by.it_academy.jd2.dto_for_jackson.controllers.json;

import by.it_academy.jd2.dto_for_jackson.dto.Student;
import by.it_academy.jd2.dto_for_jackson.services.StudentService;
import by.it_academy.jd2.dto_for_jackson.services.api.IJsonService;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "StudentsServlet", urlPatterns = "/students")
public class StudentsServlet extends HttpServlet {

    private IJsonService<Student> service = StudentService.getInstance();
    private ObjectMapper mapper = new ObjectMapper();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json; charset=UTF-8");

        resp.getWriter().write(
                mapper.writeValueAsString(service.getAll())
        );
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        ServletInputStream inputStream = req.getInputStream();

        Student student = mapper.readValue(inputStream, Student.class);

        service.save(student);
    }
}
