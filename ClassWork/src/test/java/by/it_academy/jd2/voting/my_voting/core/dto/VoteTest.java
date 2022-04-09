package by.it_academy.jd2.voting.my_voting.core.dto;

import by.it_academy.jd2.voting.my_voting.service.ArtistsService;
import by.it_academy.jd2.voting.my_voting.service.GenresService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalField;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class VoteTest {



    private final static Vote vote = new Vote(3, new int[]{1, 3, 4}, "text");

    @Test
    void getArtist() {
        Assertions.assertEquals(3 , vote.getArtist());
        Assertions.assertNotEquals(2, vote.getArtist());
    }

    @Test
    void getGenres() {
        Assertions.assertArrayEquals(new int[]{1, 3, 4}, vote.getGenres());

    }

    @Test
    void getAbout() {
        Assertions.assertEquals("text", vote.getAbout());
    }

    @Test
    void getTime() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy:HH/mm/ss");
        Assertions.assertEquals(LocalDateTime.now().format(formatter), vote.getTime().format(formatter));
    }

    @Test
    void check() {
        int artistsSize = ArtistsService.getInstance().getList().size();
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Vote(-1, new int[] {1, 2, 3}, ""));
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Vote(artistsSize, new int[] {1, 2, 3}, ""));
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Vote(1, new int[] {1, 2}, ""));
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Vote(1, new int[] {1, 2, 3, 5, 6, 9}, ""));
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Vote(2, new int[] {1, 2, -1, 5}, ""));
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Vote(3, new int[] {1, 12, 0, 5}, ""));
    }

}