package by.it_academy.jd2.voting.my_voting.servlets;

import by.it_academy.jd2.voting.my_voting.dto.VoteContainer;
import by.it_academy.jd2.voting.my_voting.service.ArtistsService;
import by.it_academy.jd2.voting.my_voting.service.GenresService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

@WebServlet(name = "FormServlet", urlPatterns = "/form")
public class FormServlet extends HttpServlet {

    private ArtistsService artistsService = ArtistsService.getInstance();
    private GenresService genresService = GenresService.getInstance();

    private final String ARTIST = "artist";
    private final String ABOUT_USER = "about";
    private final String GENRE_PARAMETER_HEADER = "ARRAY_GENRES_PARAM";

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        try {
            int artist = Integer.parseInt(req.getParameter(this.ARTIST)) - 1;
            String header = req.getHeader(GENRE_PARAMETER_HEADER);

            int[] genres = Arrays.stream(
                    req.getParameterMap()
                            .get(header))
                    .mapToInt(x -> Integer.parseInt(x) - 1)
                    .toArray();

            String testAbout = req.getParameter(ABOUT_USER);

            VoteContainer.getInstance().saveVote(artist, genres, testAbout);

        }catch (IllegalArgumentException e) {
            resp.setContentType("text/html;charset=UTF-8");
            resp.getWriter().append(e.getMessage());
        }
    }
}
