package by.it_academy.jd2.voting.my_voting.core.dto;

import by.it_academy.jd2.voting.my_voting.core.dto.api.IVoteContainer;
import by.it_academy.jd2.voting.my_voting.core.dto.api.IVoteCounter;

import by.it_academy.jd2.voting.my_voting.service.GenresService;

import java.util.*;
public class GenresCounter implements IVoteCounter<String, Integer> {

    private final IVoteContainer container;

    public GenresCounter(IVoteContainer container) {
        this.container = container;
    }

    @Override
    public Map<String, Integer> getSortedMap(Comparator<Map.Entry<String, Integer>> comparator) {
        List<Vote> votes = container.getVotes();
        List<String> genres = GenresService.getInstance().getList();
        Map<String, Integer> result = new HashMap<>();

        votes.forEach(x -> Arrays.stream(x.getGenres()).forEach(number -> {
            String genre = genres.get(number);

            if (result.containsKey(genre)) {
                result.put(genre, result.get(genre) + 1);
            }else {
                result.put(genre, 1);
            }

        }));

        return sort(result, comparator);
    }
}
