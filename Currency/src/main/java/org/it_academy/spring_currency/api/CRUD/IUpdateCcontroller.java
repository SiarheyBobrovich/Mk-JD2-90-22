package org.it_academy.spring_currency.api.CRUD;

public interface IUpdateCcontroller<U> {

    /**
     * Updating params of saved U-object
     * @param u - The U-object which will be updating
     */
    void update(U u, long id);
}
