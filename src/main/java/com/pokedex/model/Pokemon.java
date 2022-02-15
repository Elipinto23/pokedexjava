package com.pokedex.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Pokemon {
    private PokemonResource color;
    private List<PokemonFlavorTextEntry> flavorTextEntries;
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
