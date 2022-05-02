package org.it_academy.airportsInfo.service;

import org.it_academy.airportsInfo.dao.AirportsDao;
import org.it_academy.airportsInfo.dao.api.IAirportDao;
import org.it_academy.airportsInfo.dto.Airport;
import org.it_academy.airportsInfo.service.api.IAirportService;

import java.util.List;

public class AirportsService implements IAirportService<Airport> {

    private final IAirportDao<Airport> ad;

    public AirportsService() {
        this.ad = new AirportsDao();
    }

    @Override
    public List<Airport> get() {
        List<Airport> fromDB = this.ad.getFromDB();
        return fromDB;
    }

}
