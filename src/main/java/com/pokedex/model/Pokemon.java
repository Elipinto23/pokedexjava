package com.pokedex.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Pokemon {
    private PokemonResource color;
    @JsonProperty("flavor_text_entries")
    private List<PokemonFlavorTextEntry> flavorTextEntries;
    @JsonProperty("evolution_chain")
    private PokemonResource evolutionChain;
    private List<PokemonGenera> genera;
    private PokemonResource generation;
    private PokemonResource habitat;
    private Boolean isBaby;
    private Boolean isLegendary;
    private Boolean isMythical;
    private Integer id;
    private String name;
    private List<PokemonName> names;
    private Integer order;
}
