package org.it_academy.airportsInfo.dao.api;

import org.it_academy.airportsInfo.dto.api.BaseAirportObject;

import java.util.List;

public interface IAirportDao<A extends BaseAirportObject> {

    /**
     * Get result from Data Base
     * @return
     */
    List<A> getFromDB();

}
