package org.it_academy.airportsInfo.service;

import org.it_academy.airportsInfo.dao.AirportsDao;
import org.it_academy.airportsInfo.dao.api.IAirportDao;
import org.it_academy.airportsInfo.dto.Airport;
import org.it_academy.airportsInfo.service.api.IAirportService;

import java.util.List;

public class AirportsService implements IAirportService<Airport> {

    @Override
    public List<Airport> get() {
        IAirportDao<Airport> ai = new AirportsDao();

        return ai.getFromDB();
    }
}
