package by.it_academy.jd2.class_work.servlets;

import by.it_academy.jd2.class_work.dto_person.ClassPerson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(name = "Person", urlPatterns = "/person")
public class ClassPersonServlet extends HttpServlet {

    private final String FIRST_NAME = "firstName";
    private final String LAST_NAME = "lastName";
    private final String AGE = "age";

    private final String HEADER_PARAM = "param";

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        String firstName = req.getParameter(this.FIRST_NAME);
        String lastName = req.getParameter(this.LAST_NAME);
        String paramAge = req.getParameter(this.AGE);
        int age = paramAge != null ? Integer.parseInt(paramAge) : -1;

        if (firstName == null || lastName == null || age == -1) {
            throw new IllegalArgumentException("Не верные данные");
        }

        String header = req.getHeader(this.HEADER_PARAM);
        ClassPerson person = new ClassPerson(firstName, lastName, age);

        if ("cookie".equalsIgnoreCase(header)) {
            saveInCookie(person, resp);

        }else if ("session".equalsIgnoreCase(header)){
            saveInSession(person, req.getSession());
        }else {
            throw new IllegalArgumentException("Введите параметр сохранения: cookie/session");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        String header = req.getHeader(HEADER_PARAM);
        ClassPerson person;

        if ("cookie".equalsIgnoreCase(header)) {
            person = loadFromCookie(req);
        }else if ("session". equalsIgnoreCase(header)) {
            person = loadFromSession(req.getSession());
        }else {
            throw new IllegalArgumentException("Введите параметр загрузки: cookie/session");
        }

        resp.getWriter().append(person.toString());

    }

    private ClassPerson loadFromCookie(HttpServletRequest request) {
        String firstName = null;
        String lastName = null;
        int age = -1;
        Cookie[] cookies = request.getCookies();
        if (cookies == null) {
            throw new IllegalArgumentException("Персона не существует");
        }

        for (Cookie cookie : cookies) {
            if (FIRST_NAME.equals(cookie.getName())) {
                firstName = cookie.getValue();
            }else  if (LAST_NAME.equals(cookie.getName())) {
                lastName = cookie.getValue();
            }else if (AGE.equals(cookie.getName())) {
                age = Integer.parseInt(cookie.getValue());
            }
        }

        return new ClassPerson(firstName, lastName, age);
    }

    private ClassPerson loadFromSession(HttpSession session) {
        return (ClassPerson) session.getAttribute("person");
    }



    private void saveInCookie(ClassPerson person, HttpServletResponse resp) {
        Cookie name = new Cookie("firstName", person.getFirstName());
        name.setMaxAge(600);

        Cookie lastName = new Cookie("lastName", person.getLastName());
        lastName.setMaxAge(600);

        Cookie age = new Cookie("age", String.valueOf(person.getAge()));
        age.setMaxAge(600);

        resp.setContentType("text/html; charset=UTF-8");

        resp.addCookie(name);
        resp.addCookie(lastName);
        resp.addCookie(age);
    }

    private void saveInSession(ClassPerson person, HttpSession session) {
        session.setAttribute("person", person);
    }
}
