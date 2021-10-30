package br.com.starwars.controller;

import br.com.starwars.api.PlanetApi;
import br.com.starwars.domain.response.PlanetResponse;
import br.com.starwars.service.PlanetService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/planets")
public class PlanetController implements PlanetApi {

    private final PlanetService service;

    @Override
    @GetMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public PlanetResponse findById(@PathVariable int id) {
        return service.findById(id);
    }

    @Override
    @ResponseStatus(code = HttpStatus.OK)
    @GetMapping
    public List<PlanetResponse> findAllPlanets(@RequestParam int page) {
        return service.findAllPlanets(page);
    }
}
