package org.it_academy.aviasales.info.dto.filters;

import org.it_academy.aviasales.info.dto.filters.api.IFilter;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FlightFilters implements IFilter {
    private final String departureAirport;
    private final String arrivalAirport;
    private final LocalDateTime actualDepartureLocal;
    private final LocalDateTime actualArrivalLocal;


    private FlightFilters(String departureAirport, String arrivalAirport,
                          LocalDateTime actualDepartureLocal, LocalDateTime actualArrivalLocal) {
        this.departureAirport = departureAirport;
        this.arrivalAirport = arrivalAirport;
        this.actualDepartureLocal = actualDepartureLocal;
        this.actualArrivalLocal = actualArrivalLocal;
    }

    public String getDepartureAirport() {
        return departureAirport;
    }

    public String getArrivalAirport() {
        return arrivalAirport;
    }

    public LocalDateTime getActualDepartureLocal() {
        return actualDepartureLocal;
    }

    public LocalDateTime getActualArrivalLocal() {
        return actualArrivalLocal;
    }

    @Override
    public Map<String, Object> getParams() {
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("departureAirport", departureAirport);
        resultMap.put("arrivalAirport", arrivalAirport);
        resultMap.put("actualDepartureLocal", actualDepartureLocal);
        resultMap.put("actualArrivalLocal", actualArrivalLocal);

        return resultMap;
    }

    @Override
    public boolean isEmpty() {
        return Objects.isNull(departureAirport) && Objects.isNull(arrivalAirport) &&
                Objects.isNull(actualDepartureLocal) && Objects.isNull(actualArrivalLocal);
    }

    @Override
    public Iterator<Object> iterator() {
        return new Iterator<>() {
            private List<Object> list = Stream.of(departureAirport, arrivalAirport,
                            actualDepartureLocal, actualArrivalLocal)
                    .filter(Objects::nonNull)
                    .collect(Collectors.toList());

            private int index = -1;

            private boolean hasNext;
            @Override
            public boolean hasNext() {
                hasNext = true;
                return ++index < list.size();
            }

            @Override
            public Object next() {
                if (!hasNext) {
                    throw new NoSuchElementException();
                }

                hasNext = false;
                return list.get(index);
            }
        };
    }

    @Override
    public String toParameterString() {
        return "departureAirport=" + (departureAirport == null ? "" : departureAirport) +
        "&arrivalAirport=" + (arrivalAirport == null ? "" : arrivalAirport) +
        "&actualDepartureLocal=" + (actualDepartureLocal == null ? "" : actualDepartureLocal) +
        "&actualArrivalLocal=" + (actualArrivalLocal == null ? "" : actualArrivalLocal);
    }

    public static class Builder {
        private String departureAirport;
        private String arrivalAirport;
        private LocalDateTime actualDepartureLocal;
        private LocalDateTime actualArrivalLocal;

        private Builder() {
        }

        public Builder setDepartureAirport(String departureAirport) {
            if (departureAirport != null && !departureAirport.isEmpty()) {
                this.departureAirport = departureAirport;
            }
            return this;
        }

        public Builder setArrivalAirport(String arrivalAirport) {
            if (arrivalAirport != null && !arrivalAirport.isEmpty()) {
                this.arrivalAirport = arrivalAirport;
            }
            return this;
        }

        public Builder setActualDepartureLocal(LocalDateTime actualDepartureLocal) {
            this.actualDepartureLocal = actualDepartureLocal;
            return this;
        }

        public Builder setActualArrivalLocal(LocalDateTime actualArrivalLocal) {
            this.actualArrivalLocal = actualArrivalLocal;
            return this;
        }

        public FlightFilters build() {
            return new FlightFilters(departureAirport, arrivalAirport,
                    actualDepartureLocal, actualArrivalLocal);
        }

        public static Builder create() {
            return new Builder();
        }
    }
}
