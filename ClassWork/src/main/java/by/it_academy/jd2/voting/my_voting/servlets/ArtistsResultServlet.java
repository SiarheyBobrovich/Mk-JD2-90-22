package by.it_academy.jd2.voting.my_voting.servlets;

import by.it_academy.jd2.voting.my_voting.core.dto.ArtistCounter;
import by.it_academy.jd2.voting.my_voting.core.dto.VoteContainer;
import by.it_academy.jd2.voting.my_voting.core.dto.api.IVoteCounter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Comparator;
import java.util.Map;

@WebServlet(name = "ArtistsResultServlet", urlPatterns = "/artist/result")
public class ArtistsResultServlet extends HttpServlet {

    private final static IVoteCounter<String, Integer> COUNTER = new ArtistCounter(VoteContainer.getInstance());
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Map<String, Integer> sortedMap = COUNTER.getSortedMap(new Comparator<Map.Entry<String, Integer>>() {

            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o1.getValue() - o2.getValue();
            }
        }.reversed());

        resp.setContentType("text/html; charset=UTF-8");

        PrintWriter writer = resp.getWriter();

        sortedMap.forEach((key, value) -> writer.write("<p>Артист: " + key + " набрал: " + value +
                (value == 1 ? " голос" : value < 5 ? " голоса" : " голосов") + "</p></br>")
        );
    }
}
