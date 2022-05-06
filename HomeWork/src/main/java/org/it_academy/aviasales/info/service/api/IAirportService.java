package org.it_academy.aviasales.info.service.api;

import org.it_academy.aviasales.info.dto.Pageable;
import org.it_academy.aviasales.info.dto.api.BaseAirportObject;
import org.it_academy.aviasales.info.dto.filters.api.IFilter;

import java.util.List;

public interface IAirportService<A extends BaseAirportObject>{

    /**
     * Method for getting data from the database
     * @return list of BaseAirportObject
     */
    List<A> getAll();

     /**
     * Method for getting data from the database by parameter
     * @return list of BaseAirportObject
     */
    List<A> getWithParams(Pageable pageable, IFilter filter);

}
