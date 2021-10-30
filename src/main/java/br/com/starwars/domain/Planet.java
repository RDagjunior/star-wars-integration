package br.com.starwars.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Planet {

    private String name;
    private String diameter;
    private String gravity;
    private String population;
    private String climate;
    private String terrain;
    private String created;
    private String edited;
    private String url;

    @JsonProperty("rotation_period")
    private String rotationPeriod;

    @JsonProperty("orbital_period")
    private String orbitalPeriod;

    @JsonProperty("surface_water")
    private String surfaceWater;

    @JsonProperty("residents")
    private List<String> residentsUrls;

    @JsonProperty("films")
    private List<String> filmsUrls;
}