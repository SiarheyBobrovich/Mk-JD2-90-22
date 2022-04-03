package by.it_academy.jd2.voting.my_voting.dto;

import java.time.LocalDateTime;
import java.util.*;

public class Counter {

    private Map<String, Integer> artistResult;
    private Map<String, Integer> genresResult;
    private Map<LocalDateTime, String> textAbout;

    public Counter() {
        this.artistResult = new HashMap<>();
        this.genresResult = new HashMap<>();
        this.textAbout = new TreeMap<>(LocalDateTime::compareTo);
    }


}
