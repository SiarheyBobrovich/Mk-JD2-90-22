package org.it_academy.aviasales.info.service;

import org.it_academy.aviasales.info.dao.AirportsDao;
import org.it_academy.aviasales.info.dao.api.IAirportDao;
import org.it_academy.aviasales.info.dto.Airport;
import org.it_academy.aviasales.info.dto.Pageable;
import org.it_academy.aviasales.info.dto.filters.api.IFilter;
import org.it_academy.aviasales.info.service.api.IAirportService;

import java.util.List;

public class AirportsService implements IAirportService<Airport> {

    private static final AirportsService service = new AirportsService();

    private AirportsService() {}

    public static AirportsService getInstance() {
        return service;
    }

    @Override
    public List<Airport> getAll() {
        IAirportDao<Airport> ai = new AirportsDao();

        return ai.getFromDB(null, null);
    }

    @Override
    public List<Airport> getWithParams(Pageable pageable, IFilter filter) {
        return null;
    }
}
