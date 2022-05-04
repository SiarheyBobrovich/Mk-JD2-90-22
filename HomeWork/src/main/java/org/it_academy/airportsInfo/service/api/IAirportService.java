package org.it_academy.airportsInfo.service.api;

import org.it_academy.airportsInfo.dto.api.BaseAirportObject;

import java.util.List;

public interface IAirportService<A extends BaseAirportObject>{

    /**
     * Method for getting data from the database
     * @return list of BaseAirportObject
     */
    List<A> get();

}
