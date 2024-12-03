//package servidor.controller;
//
//import org.springframework.web.bind.annotation.*;
//import servidor.model.Treinador;
//import servidor.service.TreinadorService;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/api/treinador")
//public class TreinadorController {
//
//    private final TreinadorService treinadorService;
//
//    public TreinadorController(TreinadorService treinadorService) {
//        this.treinadorService = treinadorService;
//    }
//
//    @PostMapping
//    public Treinador cadastrarTreinador(@RequestBody Treinador treinador) {
//        return treinadorService.cadastrarTreinador(treinador);
//    }
//
//    @GetMapping
//    public List<Treinador> listarTodos() {
//        return treinadorService.listarTodos();
//    }
//}
