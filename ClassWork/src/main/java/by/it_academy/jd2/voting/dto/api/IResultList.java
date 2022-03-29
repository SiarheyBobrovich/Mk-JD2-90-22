package by.it_academy.jd2.voting.dto.api;

import by.it_academy.jd2.voting.dto.enums.Genres;
import by.it_academy.jd2.voting.dto.enums.Singers;

import java.util.List;

public interface IResultList {

    /**
     * Add a new vote
     * @param singer - enum from Singers
     * @param genres - Array from Genres
     * @param text - some text about voter
     */
    void addVote(Singers singer, List<Genres> genres, String text);

    /**
     * Calculate best singers
     * @return sorted singers
     */
    Singers[] getBestSingers();

    /**
     * Calculate lovely genres
     * @return - sorted genres[]
     */
    Genres[] getLovelyGenres();

    /**
     * Sort all text by Date
     * @return sorted text[]
     */
    String[] getSortedText();
}
