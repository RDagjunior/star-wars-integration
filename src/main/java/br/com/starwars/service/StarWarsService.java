package br.com.starwars.service;

import br.com.starwars.client.CallIntegration;
import br.com.starwars.domain.response.FilmResponse;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class StarWarsService {

    private final CallIntegratorGenerator callGenerator;
    private final CallExecutor executor;

    public FilmResponse findById(String id) {
        var callIntegration = createCall();
        var allFilms = callIntegration.getFilm(id);
        var filmResponse = executor.verifyStatus(allFilms);
        return new FilmResponse(filmResponse.body());
    }

    public List<FilmResponse> findAllFilms() {
        var callIntegration = createCall();

        var allFilms = callIntegration.getAllFilms();

        var filmResponse = executor.verifyStatus(allFilms);
        return filmResponse.body().getResults().stream().map(FilmResponse::new).collect(Collectors.toList());
    }

    private CallIntegration createCall() {
        return callGenerator.createCall(CallIntegration.class);
    }
}
