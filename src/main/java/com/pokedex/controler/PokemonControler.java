package com.pokedex.controler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class PokemonControler {

    @GetMapping ("/pokedex/java")
    public String listarPokemones () {
    return "listarPokemon";
    }

    @GetMapping ("/pokedex/java/{numeroPokemon}")
    public String verDetallePokemon (@PathVariable ("numeroPokemon") String numeroPokemon){
    return "mostrarDetallePokemon";
    }
}
