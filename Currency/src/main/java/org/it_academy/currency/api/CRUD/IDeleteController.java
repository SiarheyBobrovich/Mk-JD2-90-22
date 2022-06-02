package org.it_academy.currency.api.CRUD;

public interface IDeleteController<D> {

    /**
     * Delete a D-object
     * @param d - D-object which will be deleted
     */
    void delete(D d);
}
