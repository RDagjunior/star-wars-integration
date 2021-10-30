package br.com.starwars.service;

import br.com.starwars.client.SwApiIntegration;
import br.com.starwars.component.CallExecutor;
import br.com.starwars.component.CallIntegratorGenerator;
import br.com.starwars.domain.response.PlanetResponse;
import java.util.List;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class PlanetService {

    private final CallIntegratorGenerator callGenerator;
    private final CallExecutor executor;
    private final SwApiIntegration swApiIntegration;

    public PlanetService(CallIntegratorGenerator callGenerator, CallExecutor executor) {
        this.callGenerator = callGenerator;
        this.executor = executor;
        this.swApiIntegration = createCall();
    }

    public PlanetResponse findById(int id) {
        var planet = swApiIntegration.getPlanet(id);
        var planetResponse = executor.verifyStatus(planet);
        return new PlanetResponse(planetResponse.body());
    }

    public List<PlanetResponse> findAllPlanets(int page) {
        var allPlanets = swApiIntegration.getAllPlanets(page);
        var planetResponse = executor.verifyStatus(allPlanets);
        return planetResponse.body().getResults().stream().map(PlanetResponse::new).collect(Collectors.toList());
    }

    private SwApiIntegration createCall() {
        return callGenerator.createCall(SwApiIntegration.class);
    }

}
