package by.it_academy.jd2.voting.my_voting.servlets;

import by.it_academy.jd2.voting.my_voting.service.GenresService;
import by.it_academy.jd2.voting.my_voting.service.api.ISingletonService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;


@WebServlet(name = "SingerServlet", urlPatterns = "/genres")
public class GenresServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        String genre = req.getParameter("genre");

        GenresService.getInstance().add(genre);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");

        try(PrintWriter writer = resp.getWriter()) {
            writer.write("<p>Выберите одного из четырёх вариантов исполнителя: </p>");
            ISingletonService service = GenresService.getInstance();

            List<String> genres = service.getList();

            AtomicInteger index = new AtomicInteger();
            genres.forEach(x -> writer.write(
                    "<p>"
                    + index.getAndIncrement()
                    + ") "
                    + x
                    + "</p></br>")
            );

        }catch (IOException e) {
            log(e.getMessage());
        }
    }
}
