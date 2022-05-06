package org.it_academy.aviasales.info.dao.api;

import org.it_academy.aviasales.info.dto.Pageable;
import org.it_academy.aviasales.info.dto.api.BaseAirportObject;
import org.it_academy.aviasales.info.dto.filters.api.IFilter;

import java.util.List;

public interface IAirportDao<A extends BaseAirportObject> {

    /**
     * Get result from Data Base
     * @return
     */
    List<A> getFromDB(Pageable pageable, IFilter filter);

}
