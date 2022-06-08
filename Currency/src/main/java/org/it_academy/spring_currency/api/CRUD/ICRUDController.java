package org.it_academy.spring_currency.api.CRUD;

public interface ICRUDController<C, R, U, D> extends ICreateController<C>, IReadController<R>, IUpdateCcontroller<U>, IDeleteController<D> {

}
