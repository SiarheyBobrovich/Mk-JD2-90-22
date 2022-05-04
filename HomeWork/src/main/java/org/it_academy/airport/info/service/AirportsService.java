package org.it_academy.airport.info.service;

import org.it_academy.airport.info.dao.AirportsDao;
import org.it_academy.airport.info.dao.api.IAirportDao;
import org.it_academy.airport.info.dto.Airport;
import org.it_academy.airport.info.service.api.IAirportService;

import java.util.List;

public class AirportsService implements IAirportService<Airport> {

    @Override
    public List<Airport> get() {
        IAirportDao<Airport> ai = new AirportsDao();

        return ai.getFromDB();
    }
}
