package servidor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import servidor.model.Treinador;
import java.util.List;

public interface TreinadorRepository extends JpaRepository<Treinador, Long> {
    List<Treinador> findByNome(String nome);
}
