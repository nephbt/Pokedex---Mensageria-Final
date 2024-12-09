package cliente;
////
////import org.springframework.boot.autoconfigure.SpringBootApplication;
////import org.springframework.context.ApplicationContext;
////import org.springframework.context.annotation.AnnotationConfigApplicationContext;
////import javafx.application.Application;
////import javafx.fxml.FXMLLoader;
////import javafx.scene.Scene;
////import javafx.stage.Stage;
////import org.springframework.context.annotation.ComponentScan;
////
////@SpringBootApplication
////@ComponentScan(basePackages = "servidor")
////public class ClienteApp extends Application {
////
////    private static Stage primaryStage;
////    private static ApplicationContext springContext;
////
////    public static void setRoot(String fxml) throws Exception {
////        FXMLLoader fxmlLoader = new FXMLLoader(ClienteApp.class.getResource("/fxml/" + fxml + ".fxml"));
////        //fxmlLoader.setControllerFactory(springContext::getBean);  // IMPORTANTE
////        Scene scene = new Scene(fxmlLoader.load());
////        primaryStage.setScene(scene);
////
////        Object controller = fxmlLoader.getController();
////        System.out.println("Controlador carregado: " + controller.getClass().getName());
////    }
////
////
////    @Override
////    public void start(Stage stage) throws Exception {
////        //springContext = new AnnotationConfigApplicationContext("cliente",
////        // "servidor");                                             // IMPORTANTE
////        primaryStage = stage;
////        setRoot("1.TelaInicial");
////        primaryStage.setTitle("Pokedex Interativa");
////        primaryStage.show();
////    }
////
////    public static void main(String[] args) {
////        launch();
////    }
////}
//// SEGUNDO TESTE
////
////package cliente;
////
////import org.springframework.boot.autoconfigure.SpringBootApplication;
////import javafx.application.Application;
////import javafx.fxml.FXMLLoader;
////import javafx.scene.Scene;
////import javafx.stage.Stage;
////
////@SpringBootApplication
////public class ClienteApp extends Application {
////
////    private static Stage primaryStage;
////
////    public static void setRoot(String fxml) throws Exception {
////        FXMLLoader fxmlLoader = new FXMLLoader(ClienteApp.class.getResource("/fxml/" + fxml + ".fxml"));
////        Scene scene = new Scene(fxmlLoader.load());
////        primaryStage.setScene(scene);
////
////        Object controller = fxmlLoader.getController();
////        System.out.println("Controlador carregado: " + controller.getClass().getName());
////    }
////
////    @Override
////    public void start(Stage stage) throws Exception {
////        primaryStage = stage;
////        setRoot("1.TelaInicial");
////        primaryStage.setTitle("Pokedex Interativa");
////        primaryStage.show();
////    }
////
////    public static void main(String[] args) {
////        launch();
////    }
////}

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

@SpringBootApplication
public class ClienteApp extends Application {

    private static Stage primaryStage;
    private static ApplicationContext springContext;

    public static void setRoot(String fxml) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(ClienteApp.class.getResource("/fxml/" + fxml + ".fxml"));

        // Usar o contexto Spring para fornecer o controlador
        fxmlLoader.setControllerFactory(springContext::getBean);

        Scene scene = new Scene(fxmlLoader.load());
        primaryStage.setScene(scene);

        Object controller = fxmlLoader.getController();
        System.out.println("Controlador carregado: " + controller.getClass().getName());
    }

    @Override
    public void start(Stage stage) throws Exception {
        // Inicializar o contexto Spring
        springContext = new AnnotationConfigApplicationContext("cliente", "servidor");

        primaryStage = stage;
        setRoot("1.TelaInicial");
        primaryStage.setTitle("Pokedex Interativa");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
