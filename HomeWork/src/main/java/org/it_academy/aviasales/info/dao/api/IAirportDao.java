package org.it_academy.aviasales.info.dao.api;

import org.it_academy.aviasales.info.dto.api.BaseAirportObject;

import java.util.List;

public interface IAirportDao<A extends BaseAirportObject> {

    /**
     * Get result from Data Base
     * @return
     */
    List<A> getFromDB();

}
