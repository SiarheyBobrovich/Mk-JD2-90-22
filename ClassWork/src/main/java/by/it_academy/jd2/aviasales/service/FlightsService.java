package by.it_academy.jd2.aviasales.service;

import by.it_academy.jd2.aviasales.dao.*;

import java.util.List;

public class FlightsService {

    private static final FlightsService instance = new FlightsService();

    private final IFlightsDao dao;

    private FlightsService() {
        this.dao = FlightsDao.getInstance();
    }

    public List<Flights> list(FlightsFilter filter, Pageable pageable){
        return this.dao.list(filter, pageable);
    }

    public static FlightsService getInstance() {
        return instance;
    }
}
