package org.it_academy.aviasales.info.dto.filters.api;

import java.util.Map;

public interface IFilter extends Iterable<Object> {

    Map<String, Object> getParams();

    boolean isEmpty();
}
