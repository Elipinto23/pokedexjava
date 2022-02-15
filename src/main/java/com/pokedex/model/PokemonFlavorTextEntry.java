package com.pokedex.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PokemonFlavorTextEntry {
    private String flavorText;
    private PokemonResource language;
    private PokemonResource version;
}
