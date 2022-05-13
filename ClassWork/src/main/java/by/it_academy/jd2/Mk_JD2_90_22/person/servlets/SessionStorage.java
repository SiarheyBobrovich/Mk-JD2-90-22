package by.it_academy.jd2.Mk_JD2_90_22.person.servlets;

import by.it_academy.jd2.Mk_JD2_90_22.person.core.dto.Person;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SessionStorage implements IStorage{

    private static final String SESSION_ATTRIBUTE_NAME = "person";

    @Override
    public void save(HttpServletRequest req, HttpServletResponse resp, Person person) {
        HttpSession session = req.getSession();
        session.setAttribute(SESSION_ATTRIBUTE_NAME, person);
    }

    @Override
    public Person get(HttpServletRequest req) {
        HttpSession session = req.getSession();

        return (Person) session.getAttribute(SESSION_ATTRIBUTE_NAME);
    }
}
