package by.it_academy.jd2.aviasales.dao;

import java.util.List;

public interface IAirportDao extends AutoCloseable {
    /**
     * Получить все аэропорты
     * @return
     */
    List<Airport> getAll();

    /**
     * Получить аэропорт
     * @param code код аэропорта
     * @return
     */
    Airport get(String code);
}
