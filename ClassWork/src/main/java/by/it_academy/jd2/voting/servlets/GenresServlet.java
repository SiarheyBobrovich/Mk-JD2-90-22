package by.it_academy.jd2.voting.servlets;

import by.it_academy.jd2.voting.dto.enums.Genres;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(name = "SingerServlet", urlPatterns = "/genres")
public class GenresServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");

        try(PrintWriter writer = resp.getWriter()) {
            writer.write("<p>Выберите одного из четырёх вариантов исполнителя: </p>");
            Genres[] genres = Genres.values();

            for (int i = 0; i < genres.length; i++) {
                writer.write("<p>" + (i + 1) + ") " + genres[i] + "</p>");
            }

        }catch (IOException e) {
            log(e.getMessage());
        }
    }
}
