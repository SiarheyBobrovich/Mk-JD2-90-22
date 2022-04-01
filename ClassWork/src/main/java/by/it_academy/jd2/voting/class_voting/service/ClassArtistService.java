package by.it_academy.jd2.voting.class_voting.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Singleton class
 */
public class ClassArtistService {

    private static ClassArtistService artistService;
    private final List<String> artists = new ArrayList<>(Arrays.asList(
            "Круг", "Eminem", "Evanescence", "Linkin Park"
    ));

    /**
     * Singleton constructor
     */
    private ClassArtistService() {
    }

    /**
     * Singleton getter
     * @return ArtistService's object
     */
    public static ClassArtistService getInstance() {
        if (artistService != null) {
            return artistService;
        }

        synchronized (ClassArtistService.class) {
            if (artistService == null) {
                artistService = new ClassArtistService();
            }
        }

        return artistService;
    }

    /**
     * Getter-method
     * @return artists
     */
    public List<String> getArtists() {
        return artists;
    }

    /**
     * Add a new artist
     * @param artist - Anyone artist
     */
    public void add(String artist) {
        synchronized (this.artists) {
            this.artists.add(artist);
        }
    }

    /**
     * Проверка на существование индекса в списке
     * @param index переданный индекс
     * @return существует ли
     */
    public boolean isExist(int index) {
        int size = artists.size();
        return index >= 0 && index < size;
    }
}
