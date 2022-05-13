package by.it_academy.jd2.Mk_JD2_90_22.aviasales.dao;

import java.util.List;

public interface IFlightsDao extends AutoCloseable {

    /**
     * Получить все полёты
     * @return
     */
    List<Flights> getAll();

    /**
     * Получить полёты подподающих под фильтры
     * @param filter фильтры применяемые к запросу
     * @param pageable настройки пагинации
     * @return получившийся список с фильтрами и пагинацией
     */
    List<Flights> list(FlightsFilter filter, Pageable pageable);

    /**
     * Получить полёт
     * @param id PK полёта
     * @return
     */
    Flights get(Long id);

    /**
     * Получить количество записей подподающих под фильтры
     * @param filter фильтры применяемые к запросу
     * @return количество записей
     */
    long count(FlightsFilter filter);
}
