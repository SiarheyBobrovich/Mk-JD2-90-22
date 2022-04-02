package by.it_academy.jd2.voting.my_voting.dto;

import by.it_academy.jd2.voting.my_voting.service.ArtistsService;
import by.it_academy.jd2.voting.my_voting.service.GenresService;

import java.util.Arrays;

public class Vote {

    private final int artist;
    private final int[] genres;
    private final String about;

    public Vote(int artist, int[] genres, String about) throws IllegalArgumentException {
        check(artist, genres);
        this.artist = artist;
        this.genres = genres;
        this.about = about;
    }

    public int getArtist() {
        return artist;
    }

    public int[] getGenres() {
        return genres;
    }

    public String getAbout() {
        return about;
    }

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
