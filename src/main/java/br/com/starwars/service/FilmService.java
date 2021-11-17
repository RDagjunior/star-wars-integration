package br.com.starwars.service;

import br.com.starwars.client.SwApiIntegration;
import br.com.starwars.component.CallExecutor;
import br.com.starwars.component.CallIntegratorGenerator;
import br.com.starwars.domain.Film;
import br.com.starwars.domain.response.FilmResponse;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class FilmService {

    private final CallIntegratorGenerator callGenerator;
    private final CallExecutor executor;
    private final SwApiIntegration swApiIntegration;

    public FilmService(CallIntegratorGenerator callGenerator, CallExecutor executor) {
        this.callGenerator = callGenerator;
        this.executor = executor;
        this.swApiIntegration = createCall();
    }

    public FilmResponse findById(String id) {
        var film = swApiIntegration.getFilm(id);
        var filmResponse = executor.verifyStatus(film);
        return new FilmResponse(filmResponse.body());
    }

    public List<FilmResponse> findAllFilms() {
        var allFilms = swApiIntegration.getAllFilms();
        var filmResponse = executor.verifyStatus(allFilms);
        var filmsList = sortFilmList(filmResponse.body().getResults());
        return filmsList.stream().map(FilmResponse::new).collect(Collectors.toList());
    }

    private List<Film> sortFilmList(List<Film> films) {
        films.sort(Comparator.comparingInt(Film::getEpisodeId));
        return films;
    }

    private SwApiIntegration createCall() {
        return callGenerator.createCall(SwApiIntegration.class);
    }
}
