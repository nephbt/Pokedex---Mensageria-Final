//package cliente.controllers;
//
//import cliente.ClienteApp;
//import javafx.event.ActionEvent;
//import javafx.fxml.FXML;
//import javafx.scene.control.Button;
//import javafx.scene.control.Label;
//import javafx.scene.control.TextField;
//import org.springframework.beans.factory.annotation.Autowired;
//import servidor.service.TreinadorService;
//import servidor.model.Treinador;
//
//
//public class CadastrarTreinadorController {
//    @FXML
//    private Label mensagemLabel;
//    @FXML
//    private Button voltarButton;
//    @FXML
//    private Button salvarButton;
//    @FXML
//    private TextField nomeTreinadorField;
//    @FXML
//    private TextField nivelTreinadorField;
//
//    @Autowired
//    TreinadorService treinadorService;
//
//    Treinador treinador;
//
//
//    @FXML
//    public void salvarTreinador(ActionEvent event) throws Exception{
//        String nome = nomeTreinadorField.getText().trim();
//
//        // Tenta converter o valor do nível para um número inteiro
//        int nivel;
//        try {
//            nivel = Integer.parseInt(nivelTreinadorField.getText().trim());
//        } catch (NumberFormatException e) {
//            mensagemLabel.setText("O nível deve ser um número inteiro!");
//            return;
//        }
//
//        if (nome.isEmpty()) {
//            mensagemLabel.setText("Preencha todos os campos!");
//            return;
//        }
//        treinador = new Treinador(nome, nivel);
//        treinadorService.cadastrarTreinador(treinador);
//        mensagemLabel.setText("Treinador cadastrado com sucesso!");
//        limparCampos();
//    }
//
//
//    public void voltarInicio(ActionEvent event) throws Exception {
//        ClienteApp.setRoot("1.TelaInicial");
//    }
//
//    @FXML
//    private void limparCampos() {
//        nomeTreinadorField.clear();
//        nivelTreinadorField.clear();
//        mensagemLabel.setText("");
//    }
//
//}

package cliente.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Button;
import servidor.model.Treinador;
import servidor.service.TreinadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class CadastrarTreinadorController {

    @Autowired
    private TreinadorService treinadorService;

    @FXML
    private TextField nomeTreinadorField;

    @FXML
    private TextField nivelTreinadorField;

    @FXML
    private Button salvarButton;

    @FXML
    private Button voltarButton;

    @FXML
    private TableView<Treinador> tabelaTreinadores;

    @FXML
    private TableColumn<Treinador, Long> idTreinadorColuna;

    @FXML
    private TableColumn<Treinador, String> nomeColuna;

    @FXML
    private TableColumn<Treinador, Integer> nivelColuna;

    // Método para salvar o treinador
    @FXML
    public void salvarTreinador() {
        try {
            String nome = nomeTreinadorField.getText();
            Integer nivel = Integer.parseInt(nivelTreinadorField.getText());

            Treinador treinador = new Treinador();
            treinador.setNome(nome);
            treinador.setNivel(nivel);

            // Salvar o treinador no banco de dados
            treinadorService.cadastrarTreinador(treinador);

            // Exibir mensagem de sucesso
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Cadastro Concluído");
            alert.setHeaderText("Treinador cadastrado com sucesso!");
            alert.showAndWait();

            // Atualizar a tabela com os dados
            listarTreinadores();

        } catch (NumberFormatException e) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Erro de Validação");
            alert.setHeaderText("Por favor, insira um nível válido.");
            alert.showAndWait();
        }
    }

    // Método para listar treinadores na tabela
    public void listarTreinadores() {
        tabelaTreinadores.getItems().setAll(treinadorService.listarTodos());
    }

    // Método para voltar (dependendo do seu fluxo, pode ser uma navegação para outra tela)
    @FXML
    public void voltarInicio() {
        // Implemente a navegação de volta, se necessário
    }
}
