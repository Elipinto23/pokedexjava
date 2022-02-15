package com.pokedex.dto;

import com.pokedex.model.PokemonFlavorTextEntry;
import com.pokedex.model.PokemonResource;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PokemonDTO {
    private PokemonResource color;
    private List<PokemonFlavorTextEntry> flavorTextEntries;
    private Integer id;
    private String name;
    private PokemonResource generation;
    private PokemonResource habitat;
    private Integer chainId;
}
