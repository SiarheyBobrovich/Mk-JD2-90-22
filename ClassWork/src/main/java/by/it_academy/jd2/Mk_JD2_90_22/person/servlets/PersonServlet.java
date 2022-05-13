package by.it_academy.jd2.Mk_JD2_90_22.person.servlets;

import by.it_academy.jd2.Mk_JD2_90_22.person.core.StorageType;
import by.it_academy.jd2.Mk_JD2_90_22.person.core.dto.Person;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "PersonServlet", urlPatterns = "/person/person")
public class PersonServlet extends HttpServlet {

    private static final String REQUEST_FIRSTNAME_NAME = "firstName";
    private static final String REQUEST_LASTNAME_NAME = "lastName";
    private static final String REQUEST_AGE_NAME = "age";

    private static final String STORAGE_HEADER_NAME = "storage";

    private final IFactoryStorage factoryStorage = new FactoryStorage();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String storageType = req.getHeader(STORAGE_HEADER_NAME);

        try{
            StorageType choiceStorageType = StorageType.valueOfIgnoreCase(storageType);

            IStorage storageByType = factoryStorage.getStorageByType(choiceStorageType);

            Person p = storageByType.get(req);

            PrintWriter writer = resp.getWriter();
            writer.write("firstName = " + p.getFirstName());
            writer.write("lastName = " + p.getLastName());
            writer.write("age = " + p.getAge());
        } catch (IllegalArgumentException e){
            resp.sendError(400, e.getMessage());
            return;
        } catch (IllegalStateException e){
            resp.sendError(500, e.getMessage());
            return;
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String firstName = req.getParameter(REQUEST_FIRSTNAME_NAME);
        String lastName = req.getParameter(REQUEST_LASTNAME_NAME);
        String ageRaw = req.getParameter(REQUEST_AGE_NAME);

        Person p = new Person();
        p.setFirstName(firstName);
        p.setLastName(lastName);
        p.setAge(Integer.parseInt(ageRaw));

        String storageType = req.getHeader(STORAGE_HEADER_NAME);

        try{
            StorageType choiceStorageType = StorageType.valueOfIgnoreCase(storageType);

            IStorage storageByType = this.factoryStorage.getStorageByType(choiceStorageType);

            storageByType.save(req, resp, p);
        } catch (IllegalArgumentException e){
            resp.sendError(400, e.getMessage());
            return;
        } catch (IllegalStateException e){
            resp.sendError(500, e.getMessage());
            return;
        }
    }
}
