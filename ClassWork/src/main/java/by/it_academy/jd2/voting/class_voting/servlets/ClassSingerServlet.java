package by.it_academy.jd2.voting.class_voting.servlets;

import by.it_academy.jd2.voting.class_voting.service.ClassArtistService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@WebServlet(name = "ClassSingerServlet", urlPatterns = "/class/vote/singers")
public class ClassSingerServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        ClassArtistService.getInstance().add(req.getParameter("artist"));
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");

        try (PrintWriter writer = resp.getWriter()) {
            writer.write("<p>Выберите одного из четырёх вариантов исполнителя: </p>");

            ClassArtistService service = ClassArtistService.getInstance();
            List<String> artists = service.getArtists();

            AtomicInteger index = new AtomicInteger(1);
            artists.forEach(x ->
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
