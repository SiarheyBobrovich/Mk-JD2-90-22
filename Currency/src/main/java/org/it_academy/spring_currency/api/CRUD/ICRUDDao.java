package org.it_academy.spring_currency.api.CRUD;

import org.it_academy.currency.dao.entity.SpringCurrency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICRUDDao extends JpaRepository<SpringCurrency, Long> {

}
