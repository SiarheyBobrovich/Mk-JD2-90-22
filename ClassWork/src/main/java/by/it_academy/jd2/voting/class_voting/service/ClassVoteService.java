package by.it_academy.jd2.voting.class_voting.service;

import by.it_academy.jd2.voting.class_voting.core.dto.ClassVoteDto;

public class ClassVoteService {

    private final ClassArtistService artist;
    private final ClassGenreService genres;

    public ClassVoteService(ClassArtistService artist, ClassGenreService genres) {
        this.artist = artist;
        this.genres = genres;
    }

    /**
     * Checker count of genres(from 3 to 5)
     * @param vote - vote from servlet
     */
    public void check(ClassVoteDto vote) {
        if (vote.getGenres().length < 3 || vote.getGenres().length > 5) {
            throw  new IllegalArgumentException("Не соответствие количества жанров!");
        }
        if (!this.artist.isExist(vote.getArtist())) {
            throw new IllegalArgumentException("Такого артиста не существует");
        }
        for (int genre : vote.getGenres()) {
            if(!this.genres.isExist(genre)) {
                throw new IllegalArgumentException("Такого жанра не существует");
            }
        }
    }

    /**
     * Save vote from servlet
     * @param vote - object from servlet
     */
    public void save(ClassVoteDto vote) {
        check(vote);
    }
}
