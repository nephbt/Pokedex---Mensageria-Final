package servidor.service;

import org.springframework.stereotype.Service;
import servidor.model.StatusCaptura;
import servidor.repository.StatusCapturaRepository;

import java.util.List;

@Service
public class StatusCapturaService {

    private final StatusCapturaRepository statusRepository;

    public StatusCapturaService(StatusCapturaRepository statusRepository) {
        this.statusRepository = statusRepository;
    }

    public StatusCaptura salvarStatus(StatusCaptura status) {
        return statusRepository.save(status);
    }

    public List<StatusCaptura> listarTodos() {
        return statusRepository.findAll();
    }

    public List<StatusCaptura> buscarPorTreinador(Long treinadorId) {
        return statusRepository.findByTreinadorId(treinadorId);
    }

    public List<StatusCaptura> buscarPorLocalizacao(String localizacao) {
        return statusRepository.findByLocalizacao(localizacao);
    }
}
