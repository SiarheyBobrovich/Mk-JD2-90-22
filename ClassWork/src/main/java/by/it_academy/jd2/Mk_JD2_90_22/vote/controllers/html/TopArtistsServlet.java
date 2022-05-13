package by.it_academy.jd2.Mk_JD2_90_22.vote.controllers.html;

import by.it_academy.jd2.Mk_JD2_90_22.vote.core.TopDto;
import by.it_academy.jd2.Mk_JD2_90_22.vote.service.VoteService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "TopArtistsServlet", urlPatterns = "/html/top/artist")
public class TopArtistsServlet extends HttpServlet {

    private final VoteService voteService;

    public TopArtistsServlet() {
        this.voteService = VoteService.getInstance();
    }

    @Override
    public void doGet(HttpServletRequest req,
                         HttpServletResponse resp)
            throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        resp.setContentType("text/html; charset=utf-8");
        PrintWriter writer = resp.getWriter();

        List<TopDto<String>> topArtist = this.voteService.getTopArtist();

        for (TopDto<String> topDto : topArtist) {
            writer.write("<p>" + topDto.getName() + " - " + topDto.getCount() + "</p></br>");

        }
    }
}
