package by.it_academy.jd2.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

@WebServlet(name = "HelloWithNamesServlet", urlPatterns = "/hello_names")
public class HelloWithNamesServlet extends HttpServlet {

    private final String NAME_PARAMETER = "name";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");

        Enumeration<String> attributeNames = req.getParameterNames();

        PrintWriter writer = resp.getWriter();

        resp.setContentType("text/html; charset=UTF-8");
        while (attributeNames.hasMoreElements()) {
            String name = attributeNames.nextElement();
            if (name.contains(NAME_PARAMETER)) {
                writer.write(req.getParameter(name) + "\n");
            }
        }

    }
}
