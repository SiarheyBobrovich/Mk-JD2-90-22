package by.it_academy.jd2.voting.my_voting.core.dto;

import by.it_academy.jd2.voting.my_voting.core.dto.api.IVoteContainer;

import java.util.ArrayList;
import java.util.List;

public class VoteContainer implements IVoteContainer {

    private static VoteContainer voteContainer;
    private final List<Vote> votes;

    private VoteContainer() {
        votes = new ArrayList<>();
    }

    /**
     * Singleton getter
     * @return class reference
     */
    public static VoteContainer getInstance() {
        if (voteContainer != null) {
            return voteContainer;
        }

        synchronized (VoteContainer.class) {
            if (voteContainer == null) {
                voteContainer = new VoteContainer();
            }
        }

        return voteContainer;
    }

    @Override
    public void saveVote(int artist, int[] genres, String textAbout) throws IllegalArgumentException {
        synchronized (votes) {
            this.votes.add(new Vote(artist, genres, textAbout));
        }
    }

    @Override
    public List<Vote> getVotes() {
        return List.copyOf(votes);
    }
}
