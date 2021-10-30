package br.com.starwars.domain.response;

import br.com.starwars.domain.Planet;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class PlanetResponse {

    @JsonIgnore
    private final Planet planet;

    @ApiModelProperty("Planet Name")
    public String getName() {
        return planet.getName();
    }

    @ApiModelProperty("Planet Diameter")
    public String getDiameter() {
        return planet.getDiameter();
    }

    @ApiModelProperty("Planet Gravity")
    public String getGravity() {
        return planet.getGravity();
    }

    @ApiModelProperty("Planet Population")
    public String getPopulation() {
        return planet.getPopulation();
    }

    @ApiModelProperty("Planet Climate")
    public String getClimate() {
        return planet.getClimate();
    }

    @ApiModelProperty("Planet Terrain")
    public String getTerrain() {
        return planet.getTerrain();
    }

    @ApiModelProperty("Planet Surface Water")
    public String getSurfaceWater() {
        return planet.getSurfaceWater();
    }

    @ApiModelProperty("Planet Rotation Period")
    public String getRotationPeriod() {
        return planet.getRotationPeriod();
    }

    @ApiModelProperty("Planet Orbital Period")
    public String getOrbitalPeriod() {
        return planet.getOrbitalPeriod();
    }

    @ApiModelProperty("Planet Url")
    public String getUrl() {
        return planet.getUrl();
    }
}

