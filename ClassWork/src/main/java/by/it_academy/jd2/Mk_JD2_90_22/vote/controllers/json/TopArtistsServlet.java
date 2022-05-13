package by.it_academy.jd2.Mk_JD2_90_22.vote.controllers.json;

import by.it_academy.jd2.Mk_JD2_90_22.vote.core.TopDto;
import by.it_academy.jd2.Mk_JD2_90_22.vote.service.VoteService;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "TopArtistsServletJson", urlPatterns = "/json/top/artist")
public class TopArtistsServlet extends HttpServlet {

    private final VoteService voteService;
    private ObjectMapper mapper = new ObjectMapper();

    public TopArtistsServlet() {
        this.voteService = VoteService.getInstance();
    }

    @Override
    public void doGet(HttpServletRequest req,
                         HttpServletResponse resp)
            throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        resp.setContentType("application/json; charset=utf-8");
        PrintWriter writer = resp.getWriter();

        List<TopDto<String>> topArtist = this.voteService.getTopArtist();



        String json = mapper.writeValueAsString(topArtist);

        writer.write(json);
    }
}
