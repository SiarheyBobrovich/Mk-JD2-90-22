package org.it_academy.currency.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

@JsonDeserialize(builder = Value.Builder.class)
public class Value {
    private final long id;
    private final String code;
    private final String description;
    private final String name;

    public Value(long id, String code, String description, String name) {
        this.id = id;
        this.code = code;
        this.description = description;
        this.name = name;
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


    public static Builder create() {
        return new Builder();
    }

    @JsonPOJOBuilder(withPrefix = "set")
    public static class Builder {
        private long id;
        private String code;
        private String description;
        private String name;

        public Builder setId(long id) {
            this.id = id;
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
            return new Value(id,code,description,name);
        }
    }

}
