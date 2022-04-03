package by.it_academy.jd2.voting.my_voting.dto;

import by.it_academy.jd2.voting.my_voting.dto.api.IVoteContainer;
import by.it_academy.jd2.voting.my_voting.dto.api.IVoteCounter;

import java.time.LocalDateTime;
import java.util.*;

public class TextAboutCounter implements IVoteCounter<LocalDateTime, String> {

    private IVoteContainer container;

    public TextAboutCounter(IVoteContainer container) {
        this.container = container;
    }

    @Override
    public Map<LocalDateTime, String> getSortedMap(Comparator<Map.Entry<LocalDateTime, String>> comparator) {
        Map<LocalDateTime, String> result = new LinkedHashMap<>();

        container.getVotes().forEach(vote ->
            result.put(vote.getTime(), vote.getAbout())
        );

        return sort(result, comparator);
    }

}
