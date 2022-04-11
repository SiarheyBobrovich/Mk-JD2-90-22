package by.it_academy.jd2.servlet;

import by.it_academy.jd2.class_work.dto_person.ClassPerson;
import by.it_academy.jd2.servlet.utils.CookieSaveLoadUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

@WebServlet(name = "CookieSerializableServlet", urlPatterns = "/serializable")
public class CookieSerializableServlet extends HttpServlet {

    private final String FIRST_NAME = "firstName";
    private final String LAST_NAME = "lastName";
    private final String AGE = "age";

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");
        String error = "";

        String firstName;
        if ((firstName = req.getParameter(this.FIRST_NAME)) == null) {
            error += "имя";
        }

        String lastName;
            if((lastName = req.getParameter(this.LAST_NAME)) == null) {
                error += error.length() == 0 ? "фамилия" : ", фамилия";
            }

        int age = -1;
        try {
            age = Integer.parseInt(req.getParameter(this.AGE));
        }catch (IllegalArgumentException e) {
            error += error.length() == 0 ? "возраст" : ", возраст";
        }

        if (firstName == null || lastName == null || age < 0) {
            resp.sendError(400, "Не корректо: " + error + ".");
            return;
        }

        ClassPerson person = new ClassPerson(firstName, lastName, age);
        Cookie cookie = CookieSaveLoadUtil.getCookie("person", person, 600);
        resp.addCookie(cookie);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        Cookie[] cookies = req.getCookies();
        if (cookies == null) {
            resp.sendError(400, "Не найдены Cookie");
            return;
        }

        for (Cookie cookie : cookies) {

            if ("person".equals(cookie.getName())) {
                try {
                    ClassPerson person = CookieSaveLoadUtil.getObject(cookie);
                    resp.getWriter().append(person.toString());
                }catch (IOException e) {
                    resp.sendError(400, "Не верно записан cookie");
                    return;
                }
            }
        }
    }
}
