package org.it_academy.currency.api.CRUD;

public interface ICreateController<C> {

    /**
     * Save a C-object
     * @param c - The C-object which will be saved
     */
    long save(C c);
}
