package br.com.starwars.api;


import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

import br.com.starwars.domain.response.ErrorResponse;
import br.com.starwars.domain.response.FilmResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import java.io.IOException;
import java.util.List;
import org.springframework.web.bind.annotation.PathVariable;

@Api(tags = "Film Api")
public interface FilmApi {

    @ApiOperation(value = "Find Film by id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Ok", response = FilmResponse.class),
            @ApiResponse(code = 400, message = "Invalid id value"),
            @ApiResponse(code = 404, message = "Film not found"),
            @ApiResponse(code = 500, message = "Internal Server Error")})
    FilmResponse findById(@ApiParam("Film Id") @PathVariable String id);

    @ApiOperation(value = "Finds all Star wars movies", produces = APPLICATION_JSON_VALUE)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "List of Films returned with success", response = FilmResponse.class),
            @ApiResponse(code = 500, message = "An unexpected error occurred", response = ErrorResponse.class)})
    List<FilmResponse> findAllFilms() throws IOException;
}
