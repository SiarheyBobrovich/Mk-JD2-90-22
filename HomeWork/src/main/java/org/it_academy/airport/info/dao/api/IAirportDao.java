package org.it_academy.airport.info.dao.api;

import org.it_academy.airport.info.dto.api.BaseAirportObject;

import java.util.List;

public interface IAirportDao<A extends BaseAirportObject> {

    /**
     * Get result from Data Base
     * @return
     */
    List<A> getFromDB();

}
