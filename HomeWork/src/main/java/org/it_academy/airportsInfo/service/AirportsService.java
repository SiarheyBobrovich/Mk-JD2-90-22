package org.it_academy.airportsInfo.service;

import org.it_academy.airportsInfo.dao.AirportsDao;
import org.it_academy.airportsInfo.dto.Airport;
import org.it_academy.airportsInfo.service.api.IAirportService;

import java.util.List;
import java.util.stream.Collectors;

public class AirportsService implements IAirportService {

    private final AirportsDao ad;

    public AirportsService() {
        this.ad = new AirportsDao();
    }

    @Override
    public List<Airport> get() {
        return this.ad.getFromDB();
    }
}
