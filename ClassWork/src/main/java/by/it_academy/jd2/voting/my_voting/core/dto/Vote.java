package by.it_academy.jd2.voting.my_voting.core.dto;

import by.it_academy.jd2.voting.my_voting.service.ArtistsService;
import by.it_academy.jd2.voting.my_voting.service.GenresService;

import java.time.LocalDateTime;
import java.util.Arrays;

public class Vote {

    private final int artist;
    private final int[] genres;
    private final String about;
    private final LocalDateTime time;

    public Vote(int artist, int[] genres, String about) throws IllegalArgumentException {
        check(artist, genres);
        this.artist = artist;
        this.genres = genres;
        this.about = about;
        this.time = LocalDateTime.now();
    }

    /**
     * Getter for the artist field
     * @return - int(artist-number)
     */
    public int getArtist() {
        return artist;
    }

    /**
     * Getter for the genres array
     * @return - int[](genre-numbers)
     */
    public int[] getGenres() {
        return genres;
    }

    /**
     * Getter for the text-about field
     * @return - String(about from user)
     */
    public String getAbout() {
        return about;
    }

    /**
     * Getter for the time field
     * @return - LocalDateTime(time the user voted)
     */
    public LocalDateTime getTime() {
        return this.time;
    }

    /**
     * Method for checking the user's vote by parameters
     * @param artist - artist from user
     * @param genres - array of genre from user
     * @throws IllegalArgumentException - if any of the parameters - false
     */
    private void check(int artist, int[] genres) throws IllegalArgumentException {
        if (!ArtistsService.getInstance().isExist(artist)) {
            throw new IllegalArgumentException("Не верный номер исполнителя!");
        }

        if (genres.length < 3 || genres.length > 5) {
            throw new IllegalArgumentException("Не верное колличество жанров!");
        }
        Arrays.stream(genres).forEach(x -> {
            GenresService genresService = GenresService.getInstance();
            if(!genresService.isExist(x)) {
                throw new IllegalArgumentException("Не верный номер жанра!");
            }
        });
    }
}
