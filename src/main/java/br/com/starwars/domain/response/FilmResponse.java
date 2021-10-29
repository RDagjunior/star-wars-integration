package br.com.starwars.domain.response;

import br.com.starwars.domain.Film;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDate;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class FilmResponse {

    @JsonIgnore
    private final Film film;

    @ApiModelProperty("Film Title")
    public String getTitle() {
        return film.getTitle();
    }

    @ApiModelProperty("Episode")
    public int getEpisodeId() {
        return film.getEpisodeId();
    }

    @ApiModelProperty("Film Opening Crawl")
    public String getOpeningCrawl() {
        return film.getOpeningCrawl();
    }

    @ApiModelProperty("Film Director")
    public String getDirector() {
        return film.getDirector();
    }

    @ApiModelProperty("Film Producer")
    public String getProducer() {
        return film.getProducer();
    }

    @ApiModelProperty("Film Release Date")
    public LocalDate getReleaseDate() {
        return film.getReleaseDate();
    }
}

