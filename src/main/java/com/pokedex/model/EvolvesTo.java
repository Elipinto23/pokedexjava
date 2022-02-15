package com.pokedex.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class EvolvesTo {
    @JsonProperty("evolves_to")
    private List<EvolvesTo> evolvesTo;
    @JsonProperty("is_baby")
    private Boolean isBaby;
    private PokemonResource species;
}
