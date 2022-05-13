package by.it_academy.jd2.Mk_JD2_90_22.vote.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArtistsService {

    private static final ArtistsService instance = new ArtistsService();

    private List<String> artists = new ArrayList<>(Arrays.asList(
            "Круг", "Evanessence", "Eminem", "Бах"
    ));

    private ArtistsService() {
    }

    public List<String> getAll(){
        return artists;
    }

    public String get(int index){
        return this.artists.get(index);
    }

    public void add(String artist){
        artists.add(artist);
    }

    public boolean isExist(int index){
        int size = artists.size();
        return index >= 0 && index < size;
    }

    public static ArtistsService getInstance() {
        return instance;
    }
}
