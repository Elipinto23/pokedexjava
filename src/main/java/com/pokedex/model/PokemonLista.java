package com.pokedex.model;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class PokemonLista {
    private Integer count;
    private String next;
    private String previous;
    private List<PokemonItem> results = new ArrayList<>();
}
