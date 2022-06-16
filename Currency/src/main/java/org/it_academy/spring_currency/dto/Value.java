package org.it_academy.spring_currency.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.it_academy.spring_currency.config.JsonToEpochDate;

import java.time.LocalDateTime;

@JsonDeserialize(builder = Value.Builder.class)
public class Value {
    private final long id;
    private final String code;
    private final String description;
    private final String name;

    private  final LocalDateTime createDate;

    @JsonSerialize(using = JsonToEpochDate.class)
    private  final LocalDateTime updateDate;


    public Value(long id, String code, String description, String name, LocalDateTime createDate, LocalDateTime updateDate) {
        this.id = id;
        this.code = code;
        this.description = description;
        this.name = name;
        this.createDate = createDate;
        this.updateDate = updateDate;
    }

    public long getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public LocalDateTime getUpdateDate() {
        return updateDate;
    }

    public static Builder create() {
        return new Builder();
    }

    @JsonPOJOBuilder(withPrefix = "set")
    public static class Builder {
        private long id;
        private String code;
        private String description;
        private String name;

        private  LocalDateTime createDate;

        private  LocalDateTime updateDate;

        public Builder setId(long id) {
            this.id = id;
            return this;
        }

        public Builder setCreateDate(LocalDateTime createDate) {
            this.createDate = createDate;
            return this;
        }

        public Builder setUpdateDate(LocalDateTime updateDate) {
            this.updateDate = updateDate;
            return this;
        }

        public Builder setCode(String code) {
            this.code = code;
            return this;
        }

        public Builder setDescription(String description) {
            this.description = description;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Value build() {
            return new Value(id,code,description,name, createDate, updateDate);
        }
    }

}
