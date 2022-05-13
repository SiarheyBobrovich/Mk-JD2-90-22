package by.it_academy.jd2.Mk_JD2_90_22.vote.controllers.json;

import by.it_academy.jd2.Mk_JD2_90_22.vote.core.dto.VoteDto;
import by.it_academy.jd2.Mk_JD2_90_22.vote.service.VoteService;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;

@WebServlet(name = "VoteServletJson", urlPatterns = "/json/vote")
public class VoteServlet extends HttpServlet {

    private VoteService service;

    public VoteServlet() {
        this.service = VoteService.getInstance();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        ObjectMapper mapper = new ObjectMapper();

        VoteDto vote = mapper.readValue(req.getInputStream(), VoteDto.class);

        vote.setArtist(vote.getArtist() - 1);

        int[] genres = vote.getGenres();
        for (int i = 0; i < genres.length; i++) {
            genres[i] = genres[i] - 1;
        }

        vote.setGenres(genres);

        service.save(vote);
    }
}
