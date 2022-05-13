package by.it_academy.jd2.Mk_JD2_90_22.test.jsp.servlets;


import by.it_academy.jd2.Mk_JD2_90_22.test.jsp.service.NameGeneratorService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "HelloServlet", urlPatterns = "/test/hello")
public class HelloServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req,
                         HttpServletResponse resp)
            throws ServletException, IOException {
        req.setAttribute("name", NameGeneratorService.getRandomName());
        req.setAttribute("allNames", NameGeneratorService.getAllNames());

        req.getRequestDispatcher("/jsp/Hello.jsp").forward(req, resp);
    }
}
