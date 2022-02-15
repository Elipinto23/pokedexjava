package com.pokedex.service;

import com.pokedex.dto.PokemonDTO;
import com.pokedex.dto.PokemonListaDTO;
import com.pokedex.model.PokemonResource;

import java.util.List;

public interface PokemonService {
    PokemonListaDTO listarPokemon(Integer limit, Integer offset);

    PokemonDTO obtenerDetallePokemon(Integer numero);

    List<PokemonResource> obtenerCadenaEvolucion(Integer cadena);
}
