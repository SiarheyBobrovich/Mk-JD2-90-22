package by.it_academy.jd2.voting.my_voting.service;

import by.it_academy.jd2.voting.my_voting.service.api.ISingletonService;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GenresService implements ISingletonService {

    private static GenresService genresService;

    private final List<String> genres;

    private GenresService() {
        genres = Stream.of(
                "Артур Пирожков",
                "Linkin park",
                "Rihhana",
                "Лариса Долина")
            .collect(Collectors.toList()
        );
    }

    public static GenresService getInstance() {
        if (genresService != null) {
            return genresService;
        }

        synchronized (GenresService.class) {
            if (genresService == null) {
                return genresService = new GenresService();
            }
        }

        return genresService;
    }

    @Override
    public void add(String name) {
        synchronized (this.genres) {
            if (!this.genres.contains(name)) {
                this.genres.add(name);
            }
        }
    }

    @Override
    public boolean isExist(int index) {
        return index >= 0 && index < this.genres.size();
    }

    @Override
    public List<String> getList() {
        return List.copyOf(this.genres);
    }
}
