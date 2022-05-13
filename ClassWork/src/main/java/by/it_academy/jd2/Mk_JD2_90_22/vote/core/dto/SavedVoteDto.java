package by.it_academy.jd2.Mk_JD2_90_22.vote.core.dto;

import java.time.LocalDateTime;

public class SavedVoteDto {
    private final LocalDateTime dtCreate;
    private final VoteDto vote;

    public SavedVoteDto(LocalDateTime dtCreate, VoteDto vote) {
        this.dtCreate = dtCreate;
        this.vote = vote;
    }

    public LocalDateTime getDtCreate() {
        return dtCreate;
    }

    public VoteDto getVote() {
        return vote;
    }
}
