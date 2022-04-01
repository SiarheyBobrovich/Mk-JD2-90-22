package by.it_academy.jd2.voting.class_voting.servlets;

import by.it_academy.jd2.voting.class_voting.core.dto.ClassVoteDto;
import by.it_academy.jd2.voting.class_voting.service.ClassArtistService;
import by.it_academy.jd2.voting.class_voting.service.ClassGenreService;
import by.it_academy.jd2.voting.class_voting.service.ClassVoteService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

@WebServlet(name = "ClassFormServlet", urlPatterns = "/class/vote/form")
public class ClassFormServlet extends HttpServlet {

    private final ClassVoteService service = new ClassVoteService(ClassArtistService.getInstance(), ClassGenreService.getInstance());

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        int artist = Integer.parseInt(req.getParameter("artist")) - 1;

        int[] genres  = Arrays.stream(req.getParameterMap().get("genre"))
                .mapToInt(s -> Integer.parseInt(s) - 1)
                .toArray();

        String about = req.getParameter("about");

        ClassVoteDto vote = new ClassVoteDto(artist, genres, about);

        this.service.save(vote);
    }


}
