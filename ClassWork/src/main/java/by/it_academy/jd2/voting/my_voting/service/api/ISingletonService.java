package by.it_academy.jd2.voting.my_voting.service.api;

import java.util.List;

public interface ISingletonService {

    /**
     * Add a new name in list
     * @param name - name of object
     */
    void add(String name);

    /**
     * Check number of object
     * @param index - number of genre
     * @return result
     */
    boolean isExist(int index);

    /**
     * Getter-method
     * @return list
     */
    List<String> getList();
}
