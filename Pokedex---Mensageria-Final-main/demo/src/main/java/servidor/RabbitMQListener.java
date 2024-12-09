package servidor;


import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import servidor.conexao.RabbitMQConfig;
import servidor.model.Treinador;
import servidor.repository.TreinadorRepository;

@Service
public class RabbitMQListener {

    @Autowired
    private TreinadorRepository treinadorRepository;

    // Listener para inserir um novo treinador
    @RabbitListener(queues = RabbitMQConfig.FILA_NOVO_TREINADOR)
    public void processarNovoTreinador(String mensagem) {
        // Exemplo de formato de mensagem: "INSERT|Treinador|nome:Ash Ketchum"
        String[] dados = mensagem.split("\\|");

        if (dados[0].equals("INSERT") && dados[1].equals("Treinador")) {
            // Processa a criação de um novo treinador
            String nomeTreinador = dados[2].split(":")[1];
            Treinador novoTreinador = new Treinador();
            novoTreinador.setNome(nomeTreinador);
            treinadorRepository.save(novoTreinador);  // Salva no banco de dados
            System.out.println("Novo Treinador Inserido: " + nomeTreinador);
        }
    }

    // Listener para atualizar informações de um treinador
    @RabbitListener(queues = RabbitMQConfig.FILA_ATUALIZAR_TREINADOR)
    public void processarAtualizarTreinador(String mensagem) {
        // Exemplo de formato de mensagem: "UPDATE|Treinador|id:1|nome:Ash Ketchum"
        String[] dados = mensagem.split("\\|");

        if (dados[0].equals("UPDATE") && dados[1].equals("Treinador")) {
            long id = Long.parseLong(dados[2].split(":")[1]);
            String novoNome = dados[3].split(":")[1];

            // Atualiza o treinador existente
            Treinador treinadorExistente = treinadorRepository.findById(id).orElse(null);
            if (treinadorExistente != null) {
                treinadorExistente.setNome(novoNome);
                treinadorRepository.save(treinadorExistente);  // Salva a atualização
                System.out.println("Treinador Atualizado: " + novoNome);
            } else {
                System.out.println("Treinador não encontrado com ID: " + id);
            }
        }
    }

    // Listener para deletar um treinador
    @RabbitListener(queues = RabbitMQConfig.FILA_DELETAR_TREINADOR)
    public void processarDeletarTreinador(String mensagem) {
        // Exemplo de formato de mensagem: "DELETE|Treinador|id:1"
        String[] dados = mensagem.split("\\|");

        if (dados[0].equals("DELETE") && dados[1].equals("Treinador")) {
            long id = Long.parseLong(dados[2].split(":")[1]);

            // Deleta o treinador do banco
            treinadorRepository.deleteById(id);
            System.out.println("Treinador Deletado com ID: " + id);
        }
    }
}
