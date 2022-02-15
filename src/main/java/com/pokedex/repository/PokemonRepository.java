package com.pokedex.repository;

import com.pokedex.model.Pokemon;
import com.pokedex.model.PokemonLista;

public interface PokemonRepository {
     PokemonLista listarPokemon(Integer limit, Integer offset);
     Pokemon obtenerDetallePokemon(Integer numero);
}
