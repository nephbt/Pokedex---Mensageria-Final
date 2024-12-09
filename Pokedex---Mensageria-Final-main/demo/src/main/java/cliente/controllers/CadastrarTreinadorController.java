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

import cliente.ClienteApp;
import cliente.service.RabbitMQService; // Importe o serviço para enviar mensagens RabbitMQ
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import servidor.model.Treinador;

@Controller
public class CadastrarTreinadorController {

    @FXML
    private Label mensagemLabel;
    @FXML
    private Button voltarButton;
    @FXML
    private Button salvarButton;
    @FXML
    private TextField nomeTreinadorField;
    @FXML
    private TextField nivelTreinadorField;

    @Autowired
    // Dentro do CadastrarTreinadorController
    private RabbitMQService rabbitMQService = new RabbitMQService();


    @FXML
    public void salvarTreinador(ActionEvent event) throws Exception {
        String nome = nomeTreinadorField.getText().trim();

        int nivel;
        try {
            nivel = Integer.parseInt(nivelTreinadorField.getText().trim());
        } catch (NumberFormatException e) {
            mensagemLabel.setText("O nível deve ser um número inteiro!");
            return;
        }

        if (nome.isEmpty()) {
            mensagemLabel.setText("Preencha todos os campos!");
            return;
        }

        Treinador treinador = new Treinador(nome, nivel);

        // Envia o treinador para o RabbitMQ para ser processado e salvo
        rabbitMQService.enviarCadastroTreinador(treinador);
        mensagemLabel.setText("Treinador cadastrado com sucesso!");
        limparCampos();
    }

    @FXML
    private void limparCampos() {
        nomeTreinadorField.clear();
        nivelTreinadorField.clear();
        mensagemLabel.setText("");
    }

    public void voltarInicio(ActionEvent event) throws Exception {
        ClienteApp.setRoot("1.TelaInicial");
    }
}
