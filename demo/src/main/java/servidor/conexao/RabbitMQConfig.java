package servidor.conexao;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    public static final String FILA_NOVO_TREINADOR = "treinador.novo";
    public static final String FILA_NOVO_POKEMON = "pokemon.novo";

    @Bean
    public Queue filaNovoTreinador() {
        return new Queue(FILA_NOVO_TREINADOR, true);
    }

    @Bean
    public Queue filaNovoPokemon() {
        return new Queue(FILA_NOVO_POKEMON, true);
    }

    @Bean
    public TopicExchange exchange() {
        return new TopicExchange("pokedex.exchange");
    }

    @Bean
    public Binding bindingNovoTreinador(Queue filaNovoTreinador, TopicExchange exchange) {
        return BindingBuilder.bind(filaNovoTreinador).to(exchange).with(FILA_NOVO_TREINADOR);
    }

    @Bean
    public Binding bindingNovoPokemon(Queue filaNovoPokemon, TopicExchange exchange) {
        return BindingBuilder.bind(filaNovoPokemon).to(exchange).with(FILA_NOVO_POKEMON);
    }
}
