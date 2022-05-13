package by.it_academy.jd2.Mk_JD2_90_22.vote.core.dto;

public class VoteDto {
    private int artist;
    private int[] genres;
    private String about;

    public VoteDto(int artist, int[] genres, String about) {
        this.artist = artist;
        this.genres = genres;
        this.about = about;
    }

    public int getArtist() {
        return artist;
    }

    public void setArtist(int artist) {
        this.artist = artist;
    }

    public int[] getGenres() {
        return genres;
    }

    public void setGenres(int[] genres) {
        this.genres = genres;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }
}
