package br.com.starwars.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class Vehicle implements Serializable {

    public String name;
    public String model;

    @JsonProperty("vehicle_class")
    public String vehicleClass;

    public String manufacturer;

    @JsonProperty("cost_in_credits")
    public String costInCredits;

    public String length;
    public String crew;
    public String passengers;

    @JsonProperty("max_atmosphering_speed")
    public String maxAtmospheringSpeed;

    @JsonProperty("cargo_capacity")
    public String cargoCapacity;

    public String consumables;
    public LocalDateTime created;
    public LocalDateTime edited;
    public String url;

    @JsonProperty("pilots")
    public List<String> pilotsUrls;

    @JsonProperty("films")
    public List<String> filmsUrls;
}