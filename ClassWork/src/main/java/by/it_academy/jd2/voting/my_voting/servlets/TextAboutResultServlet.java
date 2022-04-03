package by.it_academy.jd2.voting.my_voting.servlets;

import by.it_academy.jd2.voting.my_voting.core.dto.TextAboutCounter;
import by.it_academy.jd2.voting.my_voting.core.dto.VoteContainer;
import by.it_academy.jd2.voting.my_voting.core.dto.api.IVoteCounter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

import java.time.format.DateTimeFormatter;
import java.util.Map;

@WebServlet(name = "TextAboutResultServlet", urlPatterns = "/about/result")
public class TextAboutResultServlet extends HttpServlet {

    private static final IVoteCounter<LocalDateTime, String> COUNTER = new TextAboutCounter(VoteContainer.getInstance());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");

        Map<LocalDateTime, String> sortedMap = COUNTER.getSortedMap(Map.Entry.comparingByKey());
        PrintWriter writer = resp.getWriter();

        sortedMap.forEach((key, value) -> writer.write("<p>Время: " + key.format(DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss")) + " текст: " + value + "</p></br>")
        );
    }
}
