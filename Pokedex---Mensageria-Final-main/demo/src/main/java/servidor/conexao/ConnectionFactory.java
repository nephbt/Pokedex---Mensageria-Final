package servidor.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    private ConnectionFactory (){};
    public static Connection getConnection(){
        try {
            return DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/ ...", //... = espaço para o nome do banco
                    "postgres",
                    "..."); // ... =  espaço para a senha do seu postgres
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
