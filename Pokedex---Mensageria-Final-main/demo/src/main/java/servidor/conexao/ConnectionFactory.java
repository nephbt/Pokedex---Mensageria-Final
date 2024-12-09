//package servidor.conexao;//package servidor.conexao;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.SQLException;
//
//public class ConnectionFactory {
//    private ConnectionFactory (){};
//    public static Connection getConnection(){
//        try {
//            return DriverManager.getConnection(
//                    "jdbc:postgresql://localhost:5432/pokemon", //... = espaço para o nome do banco
//                    "postgres",
//                    "123456"); // ... =  espaço para a senha do seu postgres
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//    }
//}

package servidor.conexao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    private ConnectionFactory (){}; // Construtor privado para impedir a criação de instâncias

    public static Connection getConnection(){
        try {
            return DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/pokemon", // URL para MySQL (ajuste 'nome_do_banco')
                    "root", // Substitua 'root' pelo seu usuário MySQL
                    "123456"); // Substitua 'senha' pela sua senha do MySQL
        } catch (SQLException e) {
            throw new RuntimeException(e); // Lança exceção em caso de erro na conexão
        }
    }
}
