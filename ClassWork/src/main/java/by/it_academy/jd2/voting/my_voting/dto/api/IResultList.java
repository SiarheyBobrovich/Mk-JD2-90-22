package by.it_academy.jd2.voting.my_voting.dto.api;

import by.it_academy.jd2.voting.my_voting.dto.enums.Genres;
import by.it_academy.jd2.voting.my_voting.dto.enums.Singers;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public interface IResultList {

    /**
     * Add a new vote
     * @param singer - enum from Singers
     * @param genres - Array from Genres
     * @param text - some text about voter
     */
    void addVote(Singers singer, Set<Genres> genres, String text);



    List<Singers> getSortedSingers(Comparator<Map.Entry<Singers, Integer>> comparator);

    List<Genres> getSortedGenres(Comparator<Map.Entry<Genres, Integer>> comparator);

    List<String> getSortedText(Comparator<Map.Entry<LocalDateTime, String>> comparator);
}
