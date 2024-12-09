//package servidor.service;
//
//import org.springframework.stereotype.Service;
//import servidor.model.Treinador;
//import servidor.repository.TreinadorRepository;
//
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class TreinadorService {
//
//    private final TreinadorRepository treinadorRepository;
//
//    public TreinadorService(TreinadorRepository treinadorRepository) {
//        this.treinadorRepository = treinadorRepository;
//    }
//
//    public Treinador cadastrarTreinador(Treinador treinador) {
//        return treinadorRepository.save(treinador);
//    }
//
//    public List<Treinador> listarTodos() {
//        return treinadorRepository.findAll();
//    }
//
//    public Optional<Treinador> buscarPorId(Long id) {
//        return treinadorRepository.findById(id);
//    }
//
//    public void deletarTreinador(Long id) {
//        treinadorRepository.deleteById(id);
//    }
//}

package servidor.service;

import org.springframework.stereotype.Service;
import servidor.model.Treinador;
import servidor.repository.TreinadorRepository;

import java.util.List;
import java.util.Optional;

@Service
public class TreinadorService {

    private final TreinadorRepository treinadorRepository;

    public TreinadorService(TreinadorRepository treinadorRepository) {
        this.treinadorRepository = treinadorRepository;
    }

    public Treinador cadastrarTreinador(Treinador treinador) {
        return treinadorRepository.save(treinador);
    }

    public List<Treinador> listarTodos() {
        return treinadorRepository.findAll();
    }

    public Optional<Treinador> buscarPorId(Long id) {
        return treinadorRepository.findById(id);
    }

    public void deletarTreinador(Long id) {
        treinadorRepository.deleteById(id);
    }
}
