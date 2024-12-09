package servidor.service;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;
import servidor.model.Treinador;

@Service
public class RabbitMQListenerService {

    // Consumidor para mensagens de novo treinador
    @RabbitListener(queues = "treinador.novo")
    public void processarNovoTreinador(Treinador treinador) {
        System.out.println("Recebida mensagem de novo treinador: " + treinador);
        // Lógica para salvar o treinador no banco de dados
    }

    // Consumidor para mensagens de atualização de treinador
    @RabbitListener(queues = "treinador.atualizar")
    public void processarAtualizacaoTreinador(Treinador treinador) {
        System.out.println("Recebida mensagem de atualização de treinador: " + treinador);
        // Lógica para atualizar o treinador no banco de dados
    }

    // Consumidor para mensagens de deleção de treinador
    @RabbitListener(queues = "treinador.deletar")
    public void processarDelecaoTreinador(Long id) {
        System.out.println("Recebida mensagem de deleção de treinador com ID: " + id);
        // Lógica para deletar o treinador no banco de dados
    }
}
