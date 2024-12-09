package cliente;
/*
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "servidor")
public class ClienteApp extends Application {

    private static Stage primaryStage;
    private static ApplicationContext springContext;

    public static void setRoot(String fxml) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(ClienteApp.class.getResource("/fxml/" + fxml + ".fxml"));
        //fxmlLoader.setControllerFactory(springContext::getBean);  // IMPORTANTE
        Scene scene = new Scene(fxmlLoader.load());
        primaryStage.setScene(scene);

        Object controller = fxmlLoader.getController();
        System.out.println("Controlador carregado: " + controller.getClass().getName());
    }


    @Override
    public void start(Stage stage) throws Exception {
        //springContext = new AnnotationConfigApplicationContext("cliente",
        // "servidor");                                             // IMPORTANTE
        primaryStage = stage;
        setRoot("1.TelaInicial");
        primaryStage.setTitle("Pokedex Interativa");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}*/

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "servidor") // Certifique-se de que o pacote correto esteja sendo escaneado
public class ClienteApp extends Application {

    private static Stage primaryStage;
    private static ApplicationContext springContext;

    // Método para alterar a tela no JavaFX
    public static void setRoot(String fxml) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(ClienteApp.class.getResource("/fxml/" + fxml + ".fxml"));
        fxmlLoader.setControllerFactory(springContext::getBean);  // Usando o Spring para injetar o controlador
        Scene scene = new Scene(fxmlLoader.load());
        primaryStage.setScene(scene);

        Object controller = fxmlLoader.getController();
        System.out.println("Controlador carregado: " + controller.getClass().getName());
    }

    @Override
    public void start(Stage stage) throws Exception {
        // Inicializar o contexto Spring
        springContext = new AnnotationConfigApplicationContext("servidor", "cliente"); // Certifique-se de que está incluindo ambos os pacotes
        primaryStage = stage;
        setRoot("1.TelaInicial");  // Carregar a primeira tela
        primaryStage.setTitle("Pokedex Interativa");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();  // Iniciar a aplicação JavaFX
    }
}

