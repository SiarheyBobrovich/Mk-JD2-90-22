package org.it_academy.aviasales.info.service;

import org.it_academy.aviasales.info.dao.AirportsDao;
import org.it_academy.aviasales.info.dao.api.IAirportDao;
import org.it_academy.aviasales.info.dto.Airport;
import org.it_academy.aviasales.info.service.api.IAirportService;

import java.util.List;

public class AirportsService implements IAirportService<Airport> {

    @Override
    public List<Airport> get() {
        IAirportDao<Airport> ai = new AirportsDao();

        return ai.getFromDB();
    }
}
