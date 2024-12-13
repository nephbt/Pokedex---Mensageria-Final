package servidor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import servidor.model.PokemonEncontrado;

import java.util.List;

public interface PokemonEncontradoRepository extends JpaRepository<PokemonEncontrado, Long> {
    // Busca Pokémons pelo ID do Treinador
    List<PokemonEncontrado> findByTreinadorId(Long treinadorId);

    // Busca Pokémons pelo tipo
    List<PokemonEncontrado> findByTipo(String tipo);
}
