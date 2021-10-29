package br.com.starwars.service;

import br.com.starwars.client.SwApiIntegration;
import br.com.starwars.domain.response.FilmResponse;
import java.util.List;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class StarWarsService {

    private final CallIntegratorGenerator callGenerator;
    private final CallExecutor executor;
    private final SwApiIntegration swApiIntegration;

    public StarWarsService(CallIntegratorGenerator callGenerator, CallExecutor executor) {
        this.callGenerator = callGenerator;
        this.executor = executor;
        this.swApiIntegration = createCall();
    }

    public FilmResponse findById(String id) {
        var allFilms = swApiIntegration.getFilm(id);
        var filmResponse = executor.verifyStatus(allFilms);
        return new FilmResponse(filmResponse.body());
    }

    public List<FilmResponse> findAllFilms() {
        var allFilms = swApiIntegration.getAllFilms();

        var filmResponse = executor.verifyStatus(allFilms);
        return filmResponse.body().getResults().stream().map(FilmResponse::new).collect(Collectors.toList());
    }

    private SwApiIntegration createCall() {
        return callGenerator.createCall(SwApiIntegration.class);
    }
}
