package by.it_academy.jd2.voting.class_voting.core.dto;

public class ClassVoteDto {

    private final int artist;
    private final int[] genres;
    private final String about;

    public ClassVoteDto(int artist, int[] genres, String about) {
        this.artist = artist;
        this.genres = genres;
        this.about = about;
    }

    /**
     * Artist's getter
     * @return index of artist
     */
    public int getArtist() {
        return artist;
    }

    /**
     * Genres's getter
     * @return indexes of genres
     */
    public int[] getGenres() {
        return genres;
    }

    /**
     * Text's getter
     * @return text obout User
     */
    public String getAbout() {
        return about;
    }
}
