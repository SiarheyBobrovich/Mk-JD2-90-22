package by.it_academy.jd2.Mk_JD2_90_22.vote.service;

import by.it_academy.jd2.Mk_JD2_90_22.vote.core.TopDto;
import by.it_academy.jd2.Mk_JD2_90_22.vote.core.dto.SavedVoteDto;
import by.it_academy.jd2.Mk_JD2_90_22.vote.core.dto.VoteDto;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

public class VoteService {

    private static final VoteService instance = new VoteService();

    private final List<SavedVoteDto> savedVotes;

    private ArtistsService artistsService;
    private GenreService genreService;

    private VoteService() {
        this.artistsService = ArtistsService.getInstance();
        this.genreService = GenreService.getInstance();
        this.savedVotes = new ArrayList<>();
    }

    public void check(VoteDto vote){
        if(vote.getGenres().length < 3 || vote.getGenres().length > 5){
            throw new IllegalArgumentException("Жанров слишком мало! или много!");
        }
        if(!this.artistsService.isExist(vote.getArtist())){
            throw new IllegalArgumentException("Такого артиста не существует");
        }
        for (int genre : vote.getGenres()) {
            if(!this.genreService.isExist(genre)){
                throw new IllegalArgumentException("Такого жанра не существует");
            }
        }
    }

    public void save(VoteDto vote){
        check(vote);
        this.savedVotes.add(new SavedVoteDto(LocalDateTime.now(), vote));
    }
    
    public List<TopDto<String>> getTopArtist(){
        Map<String, TopDto<String>> result = new HashMap<>();

        for (SavedVoteDto savedVote : this.savedVotes) {
            String artist = this.artistsService.get(savedVote.getVote().getArtist());

            TopDto<String> count = result.getOrDefault(artist, new TopDto<>(artist));

            count.incCount();

            result.put(artist, count);

        }

        return result.values()
                .stream()
                .sorted((t1, t2) -> t2.getCount() - t1.getCount())
                .collect(Collectors.toList());
    }

    public List<TopDto<String>> getTopGenre(){
        Map<String, TopDto<String>> result = new HashMap<>();

        for (SavedVoteDto savedVote : this.savedVotes) {
            for (int genreRaw : savedVote.getVote().getGenres()) {
                String genre = this.genreService.get(genreRaw);

                TopDto<String> count = result.getOrDefault(genre, new TopDto<>(genre));

                count.incCount();

                result.put(genre, count);
            }
        }

        return result.values()
                .stream()
                .sorted((t1, t2) -> t2.getCount() - t1.getCount())
                .collect(Collectors.toList());
    }

    public List<String> getAllAbout(){
        return this.savedVotes.stream()
                .sorted(Comparator.comparing(SavedVoteDto::getDtCreate))
                .map(s -> s.getVote().getAbout())
                .collect(Collectors.toList());
    }
    

    public static VoteService getInstance() {
        return instance;
    }
}
