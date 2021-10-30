package br.com.starwars.api;


import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

import br.com.starwars.domain.response.ErrorResponse;
import br.com.starwars.domain.response.PlanetResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import java.io.IOException;
import java.util.List;
import org.springframework.web.bind.annotation.PathVariable;

@Api(tags = "Planet Api")
public interface PlanetApi {

    @ApiOperation(value = "Find Planet by id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Ok", response = PlanetResponse.class),
            @ApiResponse(code = 400, message = "Invalid id value"),
            @ApiResponse(code = 404, message = "Planet not found"),
            @ApiResponse(code = 500, message = "Internal Server Error")})
    PlanetResponse findById(@ApiParam("Planet Id") @PathVariable int id);

    @ApiOperation(value = "Finds all Star wars planets", produces = APPLICATION_JSON_VALUE)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "List of Planet returned with success", response = PlanetResponse.class),
            @ApiResponse(code = 500, message = "An unexpected error occurred", response = ErrorResponse.class)})
    List<PlanetResponse> findAllPlanets(int page) throws IOException;
}
