package br.com.starwars.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class Species implements Serializable {

    public String name;
    public String classification;
    public String designation;

    @JsonProperty("average_height")
    public String averageHeight;

    @JsonProperty("average_lifespan")
    public String averageLifespan;

    @JsonProperty("eye_colors")
    public String eyeColors;

    @JsonProperty("hair_colors")
    public String hairColors;

    @JsonProperty("skin_colors")
    public String skinColors;

    @JsonProperty("homeworld")
    public String homeWorld;

    public String language;
    public String created;
    public String edited;
    public String url;

    @JsonProperty("people")
    public List<String> peopleUrls;

    @JsonProperty("films")
    public List<String> filmsUrls;
}