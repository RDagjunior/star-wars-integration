package br.com.starwars.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class Root implements Serializable {

    @JsonProperty("films")
    public String filmsUrl;
    @JsonProperty("people")
    public String peopleUrl;
    @JsonProperty("planets")
    public String planetsUrl;
    @JsonProperty("species")
    public String speciesUrl;
    @JsonProperty("starships")
    public String starshipsUrl;
    @JsonProperty("vehicles")
    public String vehiclesUrl;
}