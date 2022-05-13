package by.it_academy.jd2.Mk_JD2_90_22.vote.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GenreService {

    private static final GenreService instance = new GenreService();

    private List<String> genre = new ArrayList<>(Arrays.asList(
            "Частушки", "Реп", "Рок", "ХиП-ХоП",
            "Клаssика", "Джаз", "Блюз", "....."
    ));

    private GenreService() {
    }

    public List<String> getAll(){
        return genre;
    }

    public String get(int index){
        return this.genre.get(index);
    }

    public void add(String genre){
        this.genre.add(genre);
    }

    public boolean isExist(int index){
        int size = genre.size();
        return index >= 0 && index < size;
    }

    public static GenreService getInstance() {
        return instance;
    }
}
