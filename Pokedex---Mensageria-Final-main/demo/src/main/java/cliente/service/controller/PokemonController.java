package cliente.service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import servidor.model.PokemonEncontrado;
import servidor.service.PokemonService;

import java.util.List;

@RestController
@RequestMapping("/api/pokemon")
public class PokemonController {

    @Autowired
    private PokemonService pokemonService;

    @PostMapping
    public PokemonEncontrado cadastrarPokemon(@RequestBody PokemonEncontrado pokemon) {
        return pokemonService.cadastrarPokemon(pokemon);
    }

    @GetMapping
    public List<PokemonEncontrado> listarTodos() {
        return pokemonService.listarTodos();
    }

    @GetMapping("/treinador/{treinadorId}")
    public List<PokemonEncontrado> buscarPorTreinador(@PathVariable Long treinadorId) {
        return pokemonService.buscarPorTreinador(treinadorId);
    }

    @GetMapping("/tipo/{tipo}")
    public List<PokemonEncontrado> buscarPorTipo(@PathVariable String tipo) {
        return pokemonService.buscarPorTipo(tipo);
    }
}
