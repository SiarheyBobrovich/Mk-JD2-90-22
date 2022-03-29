package by.it_academy.jd2.voting.dto;

import by.it_academy.jd2.voting.dto.api.IResultList;
import by.it_academy.jd2.voting.dto.enums.Genres;
import by.it_academy.jd2.voting.dto.enums.Singers;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ResultList implements IResultList {

    private final List<Vote> votes = new ArrayList<>();

    @Override
    public synchronized void addVote(Singers singer, List<Genres> genres, String text) {
        votes.add(new Vote(LocalDateTime.now(), singer, genres, text));
    }

    @Override
    public Singers[] getBestSingers() {
        return new Singers[0];
    }

    @Override
    public Genres[] getLovelyGenres() {
        return new Genres[0];
    }

    @Override
    public String[] getSortedText() {
        return new String[0];
    }
}
