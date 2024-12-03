//package servidor.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//import servidor.model.StatusCaptura;
//import servidor.service.StatusCapturaService;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/api/pokemon")
//public class StatusCapturaController {
//
//    @Autowired
//    private StatusCapturaService statusService;
//
//    @PostMapping
//    public StatusCaptura salvarStatus(@RequestBody StatusCaptura status) {
//        return statusService.salvarStatus(status);
//    }
//
//    @GetMapping
//    public List<StatusCaptura> listarTodos() {
//        return statusService.listarTodos();
//    }
//
//    @GetMapping("/treinador/{treinadorId}")
//    public List<StatusCaptura> buscarPorTreinador(@PathVariable Long treinadorId) {
//        return statusService.buscarPorTreinador(treinadorId);
//    }
//
//    @GetMapping("/localizacao/{localizacao}")
//    public List<StatusCaptura> buscarPorLocalizacao(@PathVariable String localizacao) {
//        return statusService.buscarPorLocalizacao(localizacao);
//    }
//}
