package by.it_academy.jd2.voting.dto;

import by.it_academy.jd2.voting.dto.enums.Genres;
import by.it_academy.jd2.voting.dto.enums.Singers;

import java.time.LocalDateTime;
import java.util.List;

public class Vote {

    private final LocalDateTime date;
    private final Singers singer;
    private final List<Genres> genres;
    private final String text;

    public Vote(LocalDateTime date, Singers singer, List<Genres> genres, String text) {
        this.date = date;
        this.singer = singer;
        this.genres = genres;
        this.text = text;
    }
}
