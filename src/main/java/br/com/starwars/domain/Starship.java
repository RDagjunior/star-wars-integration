package br.com.starwars.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

public class Starship extends Vehicle implements Serializable {

    @JsonProperty("starship_class")
    public String starshipClass;

    @JsonProperty("hyperdrive_rating")
    public String hyperdriveRating;

    @JsonProperty("MGLT")
    public String mglt;

    public Starship(String name, String model, String vehicleClass, String manufacturer, String costInCredits, String length, String crew,
            String passengers, String maxAtmospheringSpeed, String cargoCapacity, String consumables, LocalDateTime created,
            LocalDateTime edited, String url, List<String> pilotsUrls, List<String> filmsUrls) {
        super(name, model, vehicleClass, manufacturer, costInCredits, length, crew, passengers, maxAtmospheringSpeed, cargoCapacity, consumables, created,
                edited,
                url, pilotsUrls, filmsUrls);
    }
}