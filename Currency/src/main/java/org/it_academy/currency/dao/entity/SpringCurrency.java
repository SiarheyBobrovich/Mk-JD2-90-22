package org.it_academy.currency.dao.entity;


import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "Currencies")
public class SpringCurrency {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "code", updatable = false, unique = true)
    private String code;

    @Column(name = "name", updatable = false, unique = true)
    private String name;
    private String description;

    @Column(name = "dt_create", updatable = false)
    private LocalDateTime createDate;

    @Version
    @Column(name = "dt_update")
    private LocalDateTime updateDate;

    public SpringCurrency() {
    }

    public SpringCurrency(String code, String description, String name) {
        this.code = code;
        this.description = description;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    public LocalDateTime getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(LocalDateTime updateDate) {
        this.updateDate = updateDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SpringCurrency)) return false;
        SpringCurrency currency = (SpringCurrency) o;
        return id == currency.id &&
                Objects.equals(code, currency.code) &&
                Objects.equals(description, currency.description) &&
                Objects.equals(name, currency.name) &&
                Objects.equals(createDate, currency.createDate) &&
                Objects.equals(updateDate, currency.updateDate);
    }

    @Override
    public int hashCode() {
       return Objects.hash(id, code, description, name, createDate, updateDate);
    }

    @Override
    public String toString() {
        return "SpringCurrency{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", createDate=" + createDate +
                ", updateDate=" + updateDate +
                '}';
    }
}
