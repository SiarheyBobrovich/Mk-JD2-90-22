package by.it_academy.jd2.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class HelloServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().append("<title>Hello</title>")
                .append("<body>")
                .append("<img src=\"https://scientificrussia.ru/images/b/teb-full.jpg\">")
                .append("<h1>Hello, my friend!</h1>")
                .append("</body>")
        ;
    }
}
