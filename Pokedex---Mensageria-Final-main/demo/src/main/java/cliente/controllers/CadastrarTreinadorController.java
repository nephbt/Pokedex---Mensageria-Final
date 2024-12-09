package cliente.controllers;

import cliente.ClienteApp;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.springframework.beans.factory.annotation.Autowired;
import servidor.service.TreinadorService;
import servidor.model.Treinador;


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
    TreinadorService treinadorService;

    Treinador treinador;


    @FXML
    public void salvarTreinador(ActionEvent event) throws Exception{
        String nome = nomeTreinadorField.getText().trim();

        // Tenta converter o valor do nível para um número inteiro
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
        treinador = new Treinador(nome, nivel);
        treinadorService.cadastrarTreinador(treinador);
        mensagemLabel.setText("Treinador cadastrado com sucesso!");
        limparCampos();
    }


    public void voltarInicio(ActionEvent event) throws Exception {
        ClienteApp.setRoot("1.TelaInicial");
    }

    @FXML
    private void limparCampos() {
        nomeTreinadorField.clear();
        nivelTreinadorField.clear();
        mensagemLabel.setText("");
    }

}
