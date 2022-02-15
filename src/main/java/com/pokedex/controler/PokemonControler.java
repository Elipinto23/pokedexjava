package com.pokedex.controler;

import com.google.gson.Gson;
import com.pokedex.dto.PokemonListaDTO;
import com.pokedex.model.Pokemon;
import com.pokedex.model.PokemonLista;
import com.pokedex.service.PokemonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@Slf4j
public class PokemonControler {
    @Autowired
    PokemonService pokemonService;

    @GetMapping("/pokedex/listar/")
    public String listarPokemones(@RequestParam(name = "limit", required = false, defaultValue = "20") Integer limit,
                                  @RequestParam(name = "offset", required = false, defaultValue = "0") Integer offset,
                                  Model model) {
        PokemonListaDTO pokemonListaDTO = pokemonService.listarPokemon(limit, offset);
        log.info(new Gson().toJson(pokemonListaDTO));
        model.addAttribute("resultado", pokemonListaDTO);
        return "listarPokemon";
    }

    @GetMapping("/pokedex/detalle/{numeroPokemon}")
    public String verDetallePokemon(@PathVariable("numeroPokemon") Integer numeroPokemon, Model model) {
        Pokemon pokemon = pokemonService.obtenerDetallePokemon(numeroPokemon);
        log.info(new Gson().toJson(pokemon));
        model.addAttribute("pokemon", pokemon);
        return "mostrarDetallePokemon";
    }
}
