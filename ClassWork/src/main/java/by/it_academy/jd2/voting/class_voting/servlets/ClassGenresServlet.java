package by.it_academy.jd2.voting.class_voting.servlets;

import by.it_academy.jd2.voting.class_voting.service.ClassGenreService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@WebServlet(name = "ClassGenresServlet", urlPatterns = "/class/vote/genres")
public class ClassGenresServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        ClassGenreService.getInstance().add(req.getParameter("genre"));
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");

        try (PrintWriter writer = resp.getWriter()) {
            writer.write("<p>Выберите 3-5 из 10 вариантов жанров музыки: </p>");

            ClassGenreService service = ClassGenreService.getInstance();
            List<String> genres = service.getGenres();

            AtomicInteger index = new AtomicInteger(1);
            genres.forEach(x ->
                    writer.write("<p>" +
                            index.getAndIncrement() +
                            ") " +
                            x +
                            "</p>"
                            + "</br>")
            );

        }catch (IOException e) {
            log(e.getMessage());
        }
    }
}
