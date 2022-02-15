package com.pokedex.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PokemonListaDTO {
    Integer offsetPrevius;
    Integer offsetNext;
    Integer limit;
    List<PokemonItemDTO> resultados;
}
