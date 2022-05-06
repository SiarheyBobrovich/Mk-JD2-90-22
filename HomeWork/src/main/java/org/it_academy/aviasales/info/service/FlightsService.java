package org.it_academy.aviasales.info.service;

import org.it_academy.aviasales.info.dao.FlightDao;
import org.it_academy.aviasales.info.dao.api.IAirportDao;
import org.it_academy.aviasales.info.dto.Flight;
import org.it_academy.aviasales.info.dto.Pageable;
import org.it_academy.aviasales.info.dto.filters.FlightFilters;
import org.it_academy.aviasales.info.dto.filters.api.IFilter;
import org.it_academy.aviasales.info.service.api.IAirportService;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class FlightsService implements IAirportService<Flight>{
    private static final FlightsService service;

    static {
        service = new FlightsService();
    }

    private FlightsService() {}

    public static FlightsService getInstance() {
        return service;
    }

    @Override
    public List<Flight> getAll() {
        return getWithParams(new Pageable(25, 1), null);
    }

    @Override
    public List<Flight> getWithParams(Pageable pageable, IFilter filter) {
        FlightDao flightDao = new FlightDao();
        flightDao.getFromDB(pageable, filter);
        return null;
    }

}
