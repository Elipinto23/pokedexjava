package com.pokedex.repository;

import com.pokedex.model.Evolution;
import com.pokedex.model.Pokemon;
import com.pokedex.model.PokemonLista;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

@Repository
@Slf4j
public class PokemonRepositoryImpl implements PokemonRepository {
    @Autowired
    RestTemplate restTemplate;

    @Override
    public PokemonLista listarPokemon(Integer limit, Integer offset) {
        try {
            return restTemplate.getForObject("https://pokeapi.co/api/v2/pokemon-species?limit=" + limit + "&offset=" + offset, PokemonLista.class);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        return new PokemonLista();
    }

    @Override
    public Pokemon obtenerDetallePokemon(Integer numero) {
        try {
            return restTemplate.getForObject("https://pokeapi.co/api/v2/pokemon-species/" + numero + "/", Pokemon.class);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        return new Pokemon();
    }

    @Override
    public Evolution obtenerCadenaEvolucion(Integer cadena) {
        try {
            return restTemplate.getForObject("https://pokeapi.co/api/v2/evolution-chain/" + cadena + "/", Evolution.class);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        return new Evolution();
    }
}
