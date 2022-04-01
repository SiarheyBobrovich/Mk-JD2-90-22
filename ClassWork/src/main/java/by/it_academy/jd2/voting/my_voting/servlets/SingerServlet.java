package by.it_academy.jd2.voting.my_voting.servlets;

import by.it_academy.jd2.voting.my_voting.dto.enums.Singers;
import by.it_academy.jd2.voting.my_voting.service.GenresService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "SingerServlet", urlPatterns = "/singers")
public class SingerServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        String genre = req.getParameter("singer");

        GenresService.getInstance().add(genre);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");

        try (PrintWriter writer = resp.getWriter()) {
            writer.write("<p>Выберите одного из четырёх вариантов исполнителя: </p>");
            Singers[] singers = Singers.values();

            for (int i = 0; i < singers.length; i++) {
                writer.write("<p>" + (i + 1) + ") " + singers[i] + "</p>");
            }

        }catch (IOException e) {
            log(e.getMessage());
        }




    }
}
