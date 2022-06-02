package by.it_academy.jd2.hibernate.dao.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "EVENTS")
public class Event {

    private long id;
    private String title;
    private LocalDateTime dtEvents;

    public Event() {}

    public Event(String title, LocalDateTime dtEvents) {
        this.title = title;
        this.dtEvents = dtEvents;
    }

    @Id
//    @GeneratedValue(generator="increment")
//    @GenericGenerator(name="increment", strategy = "increment")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "events_id_sequence")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDateTime getDtEvents() {
        return dtEvents;
    }

    public void setDtEvents(LocalDateTime dtEvents) {
        this.dtEvents = dtEvents;
    }
}
