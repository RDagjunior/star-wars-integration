package br.com.starwars.controller;

import br.com.starwars.api.FilmApi;
import br.com.starwars.domain.response.FilmResponse;
import br.com.starwars.service.StarWarsService;
import java.io.IOException;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/films")
public class FilmController implements FilmApi {

    private final StarWarsService service;

    @Override
    @GetMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public FilmResponse findById(@PathVariable String id) {
        return service.findById(id);
    }

    @Override
    @ResponseStatus(code = HttpStatus.OK)
    @GetMapping
    public List<FilmResponse> findAllFilms() throws IOException {
        return service.findAllFilms();
    }
}
