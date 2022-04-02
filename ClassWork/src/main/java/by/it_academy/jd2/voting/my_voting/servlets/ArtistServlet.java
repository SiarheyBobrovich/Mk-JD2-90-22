package by.it_academy.jd2.voting.my_voting.servlets;

import by.it_academy.jd2.voting.my_voting.service.ArtistsService;
import by.it_academy.jd2.voting.my_voting.service.GenresService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@WebServlet(name = "ArtistServlet", urlPatterns = "/artists")
public class ArtistServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        String artist = req.getParameter("singer");

        ArtistsService.getInstance().add(artist);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");

        try (PrintWriter writer = resp.getWriter()) {
            writer.write("<p>Выберите одного из четырёх вариантов исполнителя: </p>");
            List<String> artists = ArtistsService.getInstance().getList();

            AtomicInteger index = new AtomicInteger(1);
            artists.forEach(x -> writer.write(
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
