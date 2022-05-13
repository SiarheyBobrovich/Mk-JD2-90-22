package by.it_academy.jd2.Mk_JD2_90_22.aviasales.service;

import by.it_academy.jd2.Mk_JD2_90_22.aviasales.dao.*;

import java.util.List;

public class AirportsService {

    private static final AirportsService instance = new AirportsService();

    private final IAirportDao dao;

    private AirportsService() {
        this.dao = AirportPoolDao.getInstance();
    }

    public List<Airport> getAll(){
        return this.dao.getAll();
    }

    public static AirportsService getInstance() {
        return instance;
    }
}
