package by.it_academy.jd2.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "PrintNameHeader", urlPatterns = "/names")

public class PrintNameHeader extends HttpServlet {

    private final String NAME_PARAMETER_HEADER = "ARRAY_NAME_PARAM";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");

        String header = req.getHeader(NAME_PARAMETER_HEADER);

        String[] names = req.getParameterMap().get(header);

        if (names != null) {
            for (String name : names) {
                resp.getWriter().append("<p>" + header + ": " + name + "</p>");
            }
        }

    }
}
