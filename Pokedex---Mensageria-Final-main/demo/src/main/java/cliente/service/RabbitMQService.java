package cliente.service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import servidor.model.Treinador;

@Service
public class RabbitMQService {

    private static final String EXCHANGE = "pokedex.exchange";

    @Autowired
    private RabbitTemplate rabbitTemplate;

    // Envia o cadastro de um treinador para a fila RabbitMQ
    public void enviarCadastroTreinador(Treinador treinador) {
        rabbitTemplate.convertAndSend(EXCHANGE, "treinador.novo", treinador);
        System.out.println("Mensagem de cadastro enviada: " + treinador);
    }

    // Envia a atualização de um treinador para a fila RabbitMQ
    public void enviarAtualizacaoTreinador(Treinador treinador) {
        rabbitTemplate.convertAndSend(EXCHANGE, "treinador.atualizar", treinador);
        System.out.println("Mensagem de atualização enviada: " + treinador);
    }

    // Envia a solicitação de deleção de um treinador para a fila RabbitMQ
    public void enviarDelecaoTreinador(Long id) {
        rabbitTemplate.convertAndSend(EXCHANGE, "treinador.deletar", id);
        System.out.println("Mensagem de exclusão enviada para o treinador com ID: " + id);
    }
}
