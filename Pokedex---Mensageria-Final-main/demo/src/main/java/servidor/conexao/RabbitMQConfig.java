package servidor.conexao;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    // Constantes para Filas e Rotas
    public static final String FILA_NOVO_TREINADOR = "treinador.novo";
    public static final String FILA_ATUALIZAR_TREINADOR = "treinador.atualizar";
    public static final String FILA_DELETAR_TREINADOR = "treinador.deletar";
    public static final String FILA_NOVO_POKEMON = "pokemon.novo";

    // Criação de Filas
    @Bean
    public Queue filaNovoTreinador() {
        return new Queue(FILA_NOVO_TREINADOR, true);
    }

    @Bean
    public Queue filaAtualizarTreinador() {
        return new Queue(FILA_ATUALIZAR_TREINADOR, true);
    }

    @Bean
    public Queue filaDeletarTreinador() {
        return new Queue(FILA_DELETAR_TREINADOR, true);
    }

    @Bean
    public Queue filaNovoPokemon() {
        return new Queue(FILA_NOVO_POKEMON, true);
    }


    @Bean
    public TopicExchange exchange() {
        return new TopicExchange("pokedex.exchange");
    }

    // ligação das filas a enchange com uma chave de roteamento
    @Bean
    public Binding bindingNovoTreinador(Queue filaNovoTreinador, TopicExchange exchange) {
        return BindingBuilder.bind(filaNovoTreinador).to(exchange).with(FILA_NOVO_TREINADOR);
    }

    @Bean
    public Binding bindingAtualizarTreinador(Queue filaAtualizarTreinador, TopicExchange exchange) {
        return BindingBuilder.bind(filaAtualizarTreinador).to(exchange).with(FILA_ATUALIZAR_TREINADOR);
    }

    @Bean
    public Binding bindingDeletarTreinador(Queue filaDeletarTreinador, TopicExchange exchange) {
        return BindingBuilder.bind(filaDeletarTreinador).to(exchange).with(FILA_DELETAR_TREINADOR);
    }

    @Bean
    public Binding bindingNovoPokemon(Queue filaNovoPokemon, TopicExchange exchange) {
        return BindingBuilder.bind(filaNovoPokemon).to(exchange).with(FILA_NOVO_POKEMON);
    }
}

