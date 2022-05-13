package by.it_academy.jd2.dto_for_jackson.services.api;

import java.util.List;

public interface IJsonService<T> {
    List<T> getAll();

    void save(T t);
}
