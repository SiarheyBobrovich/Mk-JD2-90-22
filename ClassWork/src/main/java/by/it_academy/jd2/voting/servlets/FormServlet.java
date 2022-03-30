package by.it_academy.jd2.voting.servlets;

import by.it_academy.jd2.voting.dto.ResultList;
import by.it_academy.jd2.voting.dto.enums.Genres;
import by.it_academy.jd2.voting.dto.enums.Singers;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

@WebServlet(name = "FormServlet", urlPatterns = "/form")
public class FormServlet extends HttpServlet {

    private final String SINGER = "singer";
    private final String ABOUT_USER = "text";
    private final String GENRE_PARAMETER_HEADER = "ARRAY_GENRES_PARAM";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        Set<Genres> genres = new HashSet<>();
        Singers singer = null;

        String singerFromUser = req.getParameter(SINGER);

        if (singerFromUser == null) {
            //добавить код перехода на сраницу формы
        }else {
            singer = Singers.valueOf(singerFromUser);
        }

        String header = req.getHeader(GENRE_PARAMETER_HEADER);
        String[] genresFromUser = req.getParameterMap().get(header);

        if (genresFromUser == null || genresFromUser.length < 3 || genresFromUser.length > 5) {
            //добавить код перехода на сраницу формы
        }else {
            for (String s : genresFromUser) {
                genres.add(Genres.valueOf(s));
            }
        }

        String textAboutUser = req.getParameter(ABOUT_USER);
        if (textAboutUser == null) {
            //добавить код перехода на сраницу формы
        }

        ResultList.getInstance().addVote(
                singer,
                genres,
                textAboutUser
        );
    }
}
