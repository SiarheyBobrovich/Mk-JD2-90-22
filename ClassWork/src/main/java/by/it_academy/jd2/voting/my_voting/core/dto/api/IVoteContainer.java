package by.it_academy.jd2.voting.my_voting.core.dto.api;


import by.it_academy.jd2.voting.my_voting.core.dto.Vote;

import java.util.List;

public interface IVoteContainer {

    /**
     *
     * @param artist - artist's number
     * @param genres - genre's numbers
     * @param textAbout - text about User
     */
    void saveVote(int artist, int[] genres, String textAbout);

    /**
     * Getter for votes
     * @return - Vote's list
     */
    List<Vote> getVotes();
}
