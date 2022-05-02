package org.it_academy.airportsInfo.service.api;

import org.it_academy.airportsInfo.dto.api.BaseAirportObject;

import java.util.List;

public interface IAirportService<A extends BaseAirportObject>{

    List<A> get();


}
