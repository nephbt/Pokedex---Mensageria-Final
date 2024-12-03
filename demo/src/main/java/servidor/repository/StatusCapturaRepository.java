package servidor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import servidor.model.StatusCaptura;

import java.util.List;

public interface StatusCapturaRepository extends JpaRepository<StatusCaptura, Long> {
    // Busca todos os status de captura de um treinador específico
    List<StatusCaptura> findByTreinadorId(Long treinadorId);

    // Busca status de captura por localização
    List<StatusCaptura> findByLocalizacao(String localizacao);
}
