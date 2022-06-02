package by.it_academy.jd2.json;

import com.fasterxml.jackson.annotation.JacksonInject;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

@JsonDeserialize(builder = StudentDelete.Builder.class)
public class StudentDelete {

    private int id;

    private String name;

    private double score;

    public StudentDelete(String name, double score) {
        this.name = name;
        this.score = score;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getScore() {
        return score;
    }

    @Override
    public String toString() {
        return "StudentDelete{" +
                ", id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", score=" + score +
                '}';
    }

    public static Builder create() {
        return new Builder();
    }


    @JsonPOJOBuilder(withPrefix = "set")
    public static class Builder {

        @JacksonInject
        private int id;

        private String name;

        private double score;

        private Builder() {
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setScore(double score) {
            this.score = score;
        }


        public StudentDelete build() {
            StudentDelete studentDelete = new StudentDelete(name, score);
            studentDelete.id = this.id;
            return studentDelete;
        }

        public Builder create() {
            return this;
        }
    }
}

