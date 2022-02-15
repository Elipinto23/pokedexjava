package com.pokedex.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PokemonFlavorTextEntry {
    @JsonProperty("flavor_text")
    private String flavorText;
    private PokemonResource language;
    private PokemonResource version;
}
