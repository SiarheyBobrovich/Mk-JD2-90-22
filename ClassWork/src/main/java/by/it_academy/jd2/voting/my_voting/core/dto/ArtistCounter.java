package by.it_academy.jd2.voting.my_voting.core.dto;

import by.it_academy.jd2.voting.my_voting.core.dto.api.IVoteContainer;
import by.it_academy.jd2.voting.my_voting.core.dto.api.IVoteCounter;
import by.it_academy.jd2.voting.my_voting.service.ArtistsService;

import java.util.*;

public class ArtistCounter implements IVoteCounter<String, Integer> {

    public ArtistCounter(IVoteContainer container) {
        this.container = container;
    }

    private final IVoteContainer container;

    @Override
    public Map<String, Integer> getSortedMap(Comparator<Map.Entry<String, Integer>> comparator) {
        List<Vote> votes = container.getVotes();
        List<String> artists = ArtistsService.getInstance().getList();
        Map<String, Integer> result = new HashMap<>();

        votes.forEach(x -> {
            int artistIndex = x.getArtist();
            String artist = artists.get(artistIndex);
            if (result.containsKey(artist)) {
                result.put(artist, result.get(artist) + 1);
            }else {
                result.put(artist, 1);
            }
        });

        return sort(result, comparator);
    }
}
