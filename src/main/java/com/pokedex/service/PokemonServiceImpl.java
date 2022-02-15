package com.pokedex.service;

import com.google.gson.Gson;
import com.pokedex.dto.PokemonDTO;
import com.pokedex.dto.PokemonItemDTO;
import com.pokedex.dto.PokemonListaDTO;
import com.pokedex.model.*;
import com.pokedex.repository.PokemonRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class PokemonServiceImpl implements PokemonService {
    @Autowired
    private PokemonRepository pokemonRepository;

    @Override
    public PokemonListaDTO listarPokemon(Integer limit, Integer offset) {
        PokemonLista pokemonLista = pokemonRepository.listarPokemon(limit, offset);
        log.info(new Gson().toJson(pokemonLista));
        PokemonListaDTO pokemonListaDTO = new PokemonListaDTO();
        //transformaciones
        pokemonListaDTO.setLimit(limit);

        //si hay pagina siguiente calcula el offset
        if (pokemonLista.getNext() != null) {
            pokemonListaDTO.setOffsetNext(offset + limit);
        }

        //si hay pagina previa calcula el offset
        if (pokemonLista.getPrevious() != null) {
            pokemonListaDTO.setOffsetPrevius(offset - limit);
        }

        //transforma de pokemonitem al pokemon item dto usando stream para usar el map (transformacion)
        pokemonListaDTO.setResultados(pokemonLista.getResults().stream().map(pokemonItem -> {
            PokemonItemDTO pokemonItemDTO = new PokemonItemDTO();
            pokemonItemDTO.setNombre(pokemonItem.getName());
            int indexInicial = pokemonItem.getUrl().indexOf("pokemon-species/") + "pokemon-species/".length();
            pokemonItemDTO.setNumero(pokemonItem.getUrl().substring(indexInicial, pokemonItem.getUrl().length() - 1));
            return pokemonItemDTO;
        }).collect(Collectors.toList()));

        return pokemonListaDTO;
    }

    @Override
    public PokemonDTO obtenerDetallePokemon(Integer numero) {
        Pokemon pokemon = pokemonRepository.obtenerDetallePokemon(numero);
        PokemonDTO pokemonDTO = new PokemonDTO();
        pokemonDTO.setColor(pokemon.getColor());
        pokemonDTO.setFlavorTextEntries(pokemon.getFlavorTextEntries());
        pokemonDTO.setId(pokemon.getId());
        pokemonDTO.setGeneration(pokemon.getGeneration());
        pokemonDTO.setHabitat(pokemon.getHabitat());
        pokemonDTO.setName(pokemon.getName());
        int indexInicial = pokemon.getEvolutionChain().getUrl().indexOf("evolution-chain/") + "evolution-chain/".length();
        pokemonDTO.setChainId(Integer.parseInt(pokemon.getEvolutionChain().getUrl().substring(indexInicial, pokemon.getEvolutionChain().getUrl().length() - 1)));
        return pokemonDTO;
    }

    @Override
    public List<PokemonResource> obtenerCadenaEvolucion(Integer cadena) {
        List<PokemonResource> evoluciones = new ArrayList<>();
        Evolution evolution = pokemonRepository.obtenerCadenaEvolucion(cadena);
        EvolvesTo evolvesTo = evolution.getChain();
        do {
            evoluciones.add(evolvesTo.getSpecies());
            evolvesTo = evolvesTo.getEvolvesTo() != null && evolvesTo.getEvolvesTo().size() > 0 ? evolvesTo.getEvolvesTo().get(0) : null;
        } while (evolvesTo != null);
        return evoluciones;
    }
}
