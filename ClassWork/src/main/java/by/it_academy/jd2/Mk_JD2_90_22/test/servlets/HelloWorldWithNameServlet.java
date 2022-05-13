package by.it_academy.jd2.Mk_JD2_90_22.test.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "HelloWorldWithNameServlet", urlPatterns = "/hello/hello_with_name")
public class HelloWorldWithNameServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req,
                         HttpServletResponse resp)
            throws ServletException, IOException {
        String firstName = req.getParameter("firstName");


        PrintWriter writer = resp.getWriter();
        writer.write("Hello " + firstName + "!!!");
    }

}
