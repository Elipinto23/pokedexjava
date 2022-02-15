package com.pokedex.service;

import com.google.gson.Gson;
import com.pokedex.dto.PokemonItemDTO;
import com.pokedex.dto.PokemonListaDTO;
import com.pokedex.model.Pokemon;
import com.pokedex.model.PokemonLista;
import com.pokedex.repository.PokemonRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public Pokemon obtenerDetallePokemon(Integer numero) {
        return pokemonRepository.obtenerDetallePokemon(numero);
    }
}
