package com.pokedex.service;

import com.pokedex.dto.PokemonListaDTO;
import com.pokedex.model.Pokemon;

public interface PokemonService {
    PokemonListaDTO listarPokemon(Integer limit, Integer offset);
    Pokemon obtenerDetallePokemon(Integer numero);
}
