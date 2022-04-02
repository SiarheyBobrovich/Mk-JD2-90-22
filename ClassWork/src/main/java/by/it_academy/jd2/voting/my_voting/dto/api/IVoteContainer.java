package by.it_academy.jd2.voting.my_voting.dto.api;


import by.it_academy.jd2.voting.my_voting.dto.Vote;

import java.util.List;

public interface IVoteContainer {

    /**
     *
     * @param artist - artist's number
     * @param genres - genre's numbers
     * @param textAbout - text about User
     */

    void saveVote(int artist, int[] genres, String textAbout);

    List<Vote> getVotes();
}
