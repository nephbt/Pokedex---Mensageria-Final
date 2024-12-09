////package servidor.conexao;
////
////import java.sql.Connection;
////import java.sql.DriverManager;
////import java.sql.SQLException;
////
////public class ConnectionFactory {
////    private ConnectionFactory (){};
////    public static Connection getConnection(){
////        try {
////            return DriverManager.getConnection(
////                    "jdbc:postgresql://localhost:5432/pokemon", //... = espaço para o nome do banco
////                    "postgres",
////                    "123456"); // ... =  espaço para a senha do seu postgres
////        } catch (SQLException e) {
////            throw new RuntimeException(e);
////        }
////    }
////}
//package servidor.conexao;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.SQLException;
//
//public class ConnectionFactory {
//    private ConnectionFactory (){};  // Construtor privado para impedir instâncias
//
//    public static Connection getConnection(){
//        try {
//            return DriverManager.getConnection(
//                    "jdbc:postgresql://localhost:5432/pokemon", // Banco de dados pokemon
//                    "postgres",  // Usuário
//                    "123456");   // Senha
//        } catch (SQLException e) {
//            throw new RuntimeException("Erro ao conectar ao banco de dados", e);
//        }
//    }
//}

package servidor.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    private ConnectionFactory(){};  // Construtor privado para impedir instâncias

    public static Connection getConnection(){
        try {
            // URL de conexão para MySQL
            return DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/pokemon", // Banco de dados pokemon no MySQL
                    "root",  // Usuário do MySQL (substitua conforme necessário)
                    "123456");   // Senha do MySQL (substitua conforme necessário)
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao conectar ao banco de dados", e);
        }
    }
}

