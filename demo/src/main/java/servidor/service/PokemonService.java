package servidor.service;

import org.springframework.stereotype.Service;
import servidor.model.PokemonEncontrado;
import servidor.repository.PokemonEncontradoRepository;

import java.util.List;

@Service
public class PokemonService {

    private final PokemonEncontradoRepository pokemonRepository;

    public PokemonService(PokemonEncontradoRepository pokemonRepository) {
        this.pokemonRepository = pokemonRepository;
    }

    public PokemonEncontrado cadastrarPokemon(PokemonEncontrado pokemon) {
        return pokemonRepository.save(pokemon);
    }

    public List<PokemonEncontrado> listarTodos() {
        return pokemonRepository.findAll();
    }

    public List<PokemonEncontrado> buscarPorTreinador(Long treinadorId) {
        return pokemonRepository.findByTreinadorId(treinadorId);
    }

    public List<PokemonEncontrado> buscarPorTipo(String tipo) {
        return pokemonRepository.findByTipo(tipo);
    }
}
