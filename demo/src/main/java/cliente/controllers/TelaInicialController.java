package cliente.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import cliente.ClienteApp;

public class TelaInicialController {

    @FXML
    private void cadastrarTreinador(ActionEvent event) throws Exception {
        ClienteApp.setRoot("2.CadastrarTreinador");
    }

    @FXML
    private void registrarPokemon(ActionEvent event) throws Exception {
        ClienteApp.setRoot("3.RegistrarPokemon");
    }

    @FXML
    private void registrarStatusCaptura(ActionEvent event) throws Exception {
        ClienteApp.setRoot("4.RegistrarStatusCaptura");
    }
}
