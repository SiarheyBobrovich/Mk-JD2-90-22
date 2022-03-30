package by.it_academy.jd2.voting.dto;

import by.it_academy.jd2.voting.dto.api.IResultList;
import by.it_academy.jd2.voting.dto.enums.Genres;
import by.it_academy.jd2.voting.dto.enums.Singers;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Stream;

public class ResultList implements IResultList {

    private  static ResultList resultList;

    private final HashMap<Singers, Integer> singers = new HashMap<>();
    private final HashMap<Genres, Integer> genres = new HashMap<>();
    private final LinkedHashMap<LocalDateTime, String> text = new LinkedHashMap<>();

    @Override
    public synchronized void addVote(Singers singer, Set<Genres> genres, String text) {
        if (this.singers.containsKey(singer)) {
            this.singers.put(singer, this.singers.get(singer) + 1);
        }else {
            this.singers.put(singer, 1);
        }

        genres.forEach(x -> {
            if (this.genres.containsKey(x)) {
                this.genres.put(x, this.genres.get(x) + 1);
            }else {
                this.genres.put(x, 1);
            }
        });

        this.text.put(LocalDateTime.now(), text);
    }

    @Override
    public List<Singers> getSortedSingers(Comparator<Map.Entry<Singers, Integer>> comparator) {
        List<Singers> result = new ArrayList<>();
        List<Map.Entry<Singers, Integer>> list = new ArrayList<>(singers.entrySet());

        list.sort(comparator);
        list.forEach(x -> result.add(x.getKey()));

        return result;
    }

    @Override
    public List<Genres> getSortedGenres(Comparator<Map.Entry<Genres, Integer>> comparator) {
        List<Genres> result = new ArrayList<>();
        List<Map.Entry<Genres, Integer>> list = new ArrayList<>(this.genres.entrySet());

        list.sort(comparator);
        list.forEach(x -> result.add(x.getKey()));

        return result;
    }

    @Override
    public List<String> getSortedText(Comparator<Map.Entry<LocalDateTime, String>> comparator) {
        List<String> result = new ArrayList<>();
        List<Map.Entry<LocalDateTime, String>> list = new ArrayList<>(this.text.entrySet());

        list.sort(comparator);
        list.forEach(x -> result.add(x.getValue()));

        return result;
    }

    /**
     * Method to get ResultList-object
     * @return object reference
     */
    public static ResultList getInstance() {
        if (resultList != null) {
            return resultList;
        }

        synchronized (ResultList.class) {
            resultList = new ResultList();
        }

        return resultList;
    }
}
