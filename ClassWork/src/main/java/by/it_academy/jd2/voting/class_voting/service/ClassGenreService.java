package by.it_academy.jd2.voting.class_voting.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ClassGenreService {

    private static ClassGenreService classGenreService;
    private final List<String> genres = new ArrayList<>(Arrays.asList(
        "Поп", "Рок", "Фанк", "Метал", "Джаз",
            "Блюз", "Кантри", "Рэгги", "Хип-хоп", "Электронная"
    ));

    /**
     * Singleton constructor
     */
    private ClassGenreService() {
    }

    /**
     * Singleton getter
     * @return GenresService's object
     */
    public static ClassGenreService getInstance() {
        if (classGenreService != null) {
            return classGenreService;
        }

        synchronized (ClassGenreService.class) {
            if (classGenreService == null) {
                classGenreService = new ClassGenreService();
            }
        }
        return classGenreService;
    }

    /**
     * Getter of genre's list
     * @return List
     */
    public List<String> getGenres() {
        return this.genres;
    }

    /**
     * Check number of genre
     * @param index - number of genre
     * @return result
     */
    public boolean isExist(int index) {
        int size = genres.size();
        return index >= 0 && index < size;
    }

    /**
     * add a new genre
     * @param genre - genre of music
     */
    public void add(String genre) {
        synchronized (this.genres) {
            this.genres.add(genre);
        }
    }
}
