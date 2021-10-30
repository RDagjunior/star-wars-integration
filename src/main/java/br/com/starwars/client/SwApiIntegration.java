package br.com.starwars.client;

import br.com.starwars.domain.Film;
import br.com.starwars.domain.People;
import br.com.starwars.domain.Planet;
import br.com.starwars.domain.SWModelList;
import br.com.starwars.domain.Species;
import br.com.starwars.domain.Starship;
import br.com.starwars.domain.Vehicle;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface SwApiIntegration {

    @GET("people/")
    Call<SWModelList<People>> getAllPeople(@Query("page") int page);

    @GET("people/{id}/")
    Call<People> getPeople(@Path("id") int peopleId);

    @GET("films/")
    Call<SWModelList<Film>> getAllFilms();

    @GET("films/{id}/")
    Call<Film> getFilm(@Path("id") String filmId);

    @GET("starships")
    Call<SWModelList<Starship>> getAllStarships(@Query("page") int page);

    @GET("starships/{id}/")
    Call<Starship> getStarship(@Path("id") int starshipId);

    @GET("vehicles/")
    Call<SWModelList<Vehicle>> getAllVehicles(@Query("page") Integer page);

    @GET("vehicles/{id}/")
    Call<Vehicle> getVehicle(@Path("id") int vehicleId);

    @GET("species/")
    Call<SWModelList<Species>> getAllSpecies(@Query("page") int page);

    @GET("species/{id}/")
    Call<Species> getSpecies(@Path("id") int speciesId);

    @GET("planets/")
    Call<SWModelList<Planet>> getAllPlanets(@Query("page") int page);

    @GET("planets/{id}/")
    Call<Planet> getPlanet(@Path("id") int planetId);
}
