package by.it_academy.jd2.voting.my_voting.service;

import by.it_academy.jd2.voting.my_voting.service.api.ISingletonService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ArtistsService implements ISingletonService {

    private static ArtistsService artistsService;
    private final List<String> artists = Stream.of(
            "Артур Пирожков",
            "Linkin park",
            "Rihhana",
            "Лариса Долина")
            .collect(Collectors.toList()
    );

    private ArtistsService() {}

    public static ArtistsService getInstance() {
        if (artistsService != null) {
            return artistsService;
        }

        synchronized (ArtistsService.class) {
            if (artistsService == null) {
                return new ArtistsService();
            }
        }

        return artistsService;
    }

    @Override
    public void add(String name) {
        synchronized (this.artists) {
            if (!this.artists.contains(name))
                this.artists.add(name);
        }
    }

    @Override
    public boolean isExist(int index) {
        return index >= 0 && index < this.artists.size();
    }

    @Override
    public List<String> getList() {
        return List.copyOf(this.artists);
    }
}
