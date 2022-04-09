package by.it_academy.jd2.voting.my_voting.core.dto;

import by.it_academy.jd2.voting.my_voting.core.dto.api.IVoteContainer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.*;

class ArtistCounterTest {

    private final IVoteContainer container = VoteContainer.getInstance();
    private final ArtistCounter counter = new ArtistCounter(container);
    private final List<Map.Entry<String, Integer>> result = new ArrayList<>();

     {
        container.saveVote(1, new int[]{1, 2, 3}, "");
        container.saveVote(3, new int[]{1, 2, 3}, "");
        container.saveVote(2, new int[]{1, 2, 3}, "");
        container.saveVote(2, new int[]{1, 2, 3}, "");
        container.saveVote(2, new int[]{1, 2, 3}, "");
        container.saveVote(3, new int[]{1, 2, 3}, "");
    }

    {
        result.add(Map.entry("Linkin park", 1));
        result.add(Map.entry("Лариса Долина", 2));
        result.add(Map.entry("Rihhana", 3));
    }

    @Test
    void getSortedMap() {
        Map<String, Integer> sortedMap = counter.getSortedMap(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o1.getValue() - o2.getValue();
            }
        });
        Assertions.assertEquals(result.size(), sortedMap.size());
        int index = 0;
        for (Map.Entry<String, Integer> entries : sortedMap.entrySet()) {
            Assertions.assertEquals(result.get(index), entries);
            index++;
        }
    }
}