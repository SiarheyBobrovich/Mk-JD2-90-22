package by.it_academy.jd2.voting.my_voting.core.dto;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.*;


class VoteContainerTest {

    private final VoteContainer container = VoteContainer.getInstance();

    @Test
    void getInstance() {
        Assertions.assertEquals(VoteContainer.getInstance(), container);
    }

    @Test
    void saveVote() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy:HH/mm/ss");
        container.saveVote(1, new int[]{1,3,2}, "text");
        Vote test = new Vote(1, new int[]{1,3,2}, "text");
        int size = container.getVotes().size();
        Vote containerVote = container.getVotes().get(size - 1);

        Assertions.assertEquals(test.getArtist(), containerVote.getArtist());
        Assertions.assertEquals(test.getAbout(), containerVote.getAbout());
        Assertions.assertEquals(test.getTime().format(formatter), containerVote.getTime().format(formatter));
        Assertions.assertArrayEquals(test.getGenres(), containerVote.getGenres());
    }
}