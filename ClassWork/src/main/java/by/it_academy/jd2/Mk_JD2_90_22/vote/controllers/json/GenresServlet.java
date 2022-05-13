package by.it_academy.jd2.Mk_JD2_90_22.vote.controllers.json;

import by.it_academy.jd2.Mk_JD2_90_22.vote.service.GenreService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

@WebServlet(name = "GenresServletJson", urlPatterns = "/json/vote/genre")
public class GenresServlet extends HttpServlet {

    private GenreService service;

    public GenresServlet() {
        this.service = GenreService.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        resp.setContentType("application/json; charset=utf-8");
        PrintWriter writer = resp.getWriter();

        List<String> genres = service.getAll();

        List<String> result = new ArrayList<>();

        int index = 1;
        for (String genre : genres) {
            result.add("\"" + index++ + " - " + genre + "\"");
        }

        writer.write("[");
        writer.write(String.join(",", result));
        writer.write("]");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        service.add(req.getParameter("genre"));
    }
}
