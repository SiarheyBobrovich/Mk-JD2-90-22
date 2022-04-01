package by.it_academy.jd2.voting.my_voting.servlets;

import by.it_academy.jd2.voting.my_voting.dto.ResultList;
import by.it_academy.jd2.voting.my_voting.dto.enums.Genres;
import by.it_academy.jd2.voting.my_voting.dto.enums.Singers;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.Map;

@WebServlet(name = "ResultServlet", urlPatterns = "/result")
public class ResultServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");

        ResultList resultList = ResultList.getInstance();

        try(PrintWriter writer = resp.getWriter()) {

            writer.write("<p><strong>Список лучших исполнителей:</strong></p>");
            resultList.getSortedSingers(
                    new Comparator<Map.Entry<Singers, Integer>>() {

                @Override
                public int compare(Map.Entry<Singers, Integer> o1, Map.Entry<Singers, Integer> o2) {
                    return o1.getValue() - o2.getValue();
                }

            }.reversed()).forEach(x -> writer.write("<p>" + x.toString() + "<p>"));

            writer.write("<p><strong>Список лучших жанров:</strong></p>");

            resultList.getSortedGenres(new Comparator<Map.Entry<Genres, Integer>>() {

                @Override
                public int compare(Map.Entry<Genres, Integer> o1, Map.Entry<Genres, Integer> o2) {
                    return o1.getValue() - o2.getValue();
                }

            }.reversed()).forEach(x -> writer.write("<p>" + x.toString() + "</p>"));

            writer.write("<p><strong>Список \"О себе\":</strong></p>");

            resultList.getSortedText(new Comparator<Map.Entry<LocalDateTime, String>>() {
                @Override
                public int compare(Map.Entry<LocalDateTime, String> o1, Map.Entry<LocalDateTime, String> o2) {
                    return o1.getKey().isBefore(o2.getKey()) ? 1 : 0;
                }

            }.reversed()).forEach(x -> writer.write("<p>" + x + "</p>"));

        }catch (IOException e) {
            log("ResultServlet: " + e.getMessage());
        }


    }
}
