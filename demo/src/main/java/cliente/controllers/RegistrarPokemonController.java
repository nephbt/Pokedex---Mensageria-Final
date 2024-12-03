package cliente.controllers;

import cliente.ClienteApp;
import javafx.event.ActionEvent;

public class RegistrarPokemonController {

    public void voltarInicio(ActionEvent event) throws Exception {
        ClienteApp.setRoot("1.TelaInicial");
    }
}
