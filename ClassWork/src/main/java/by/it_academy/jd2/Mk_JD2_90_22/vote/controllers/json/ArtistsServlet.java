package by.it_academy.jd2.Mk_JD2_90_22.vote.controllers.json;

import by.it_academy.jd2.Mk_JD2_90_22.vote.service.ArtistsService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "ArtistsServletJson", urlPatterns = "/json/vote/artist")
public class ArtistsServlet extends HttpServlet {

    private ArtistsService service;

    public ArtistsServlet() {
        this.service = ArtistsService.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        resp.setContentType("application/json; charset=utf-8");
        PrintWriter writer = resp.getWriter();

        List<String> artists = service.getAll();

        writer.write("[");

        int index = 1;
        boolean needComma = false;
        for (String artist : artists) {
            if(needComma){
                writer.write(",");
            } else {
                needComma = true;
            }
            writer.write("\"" + index++ + " - " + artist + "\"");
        }

        writer.write("]");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        service.add(req.getParameter("artist"));
    }
}
