package com.pokedex.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PokemonName {
    private PokemonResource language;
    private String name;
}
