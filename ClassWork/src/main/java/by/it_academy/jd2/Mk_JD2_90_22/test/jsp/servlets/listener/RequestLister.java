package by.it_academy.jd2.Mk_JD2_90_22.test.jsp.servlets.listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

public class RequestLister implements ServletRequestListener {
    @Override
    public void requestDestroyed(ServletRequestEvent sre) {

        System.out.println("Ptishel novy zapros");

    }

    @Override
    public void requestInitialized(ServletRequestEvent sre) {

    }
}
