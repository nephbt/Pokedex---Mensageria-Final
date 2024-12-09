//package servidor.model;
//
//import jakarta.persistence.*;
//import lombok.Getter;
//import lombok.Setter;
//
//@Entity
//@Getter
//@Setter
//public class PokemonEncontrado {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    private String nome;
//    private String tipo;
//
//    @ManyToOne                                           // se atentar ao nome da
//    @JoinColumn(name = "treinador_id", nullable = false) //chave estrangeira definida
//    private Treinador treinador;
//
//    public PokemonEncontrado(long id, String nome, String tipo, Treinador treinador) {
//    }
//}
package servidor.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class PokemonEncontrado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String tipo;

    @ManyToOne                                           // Relacionamento ManyToOne com Treinador
    @JoinColumn(name = "treinador_id", nullable = false)  // Chave estrangeira definida
    private Treinador treinador;

    // Construtor com parâmetros para inicializar os campos
    public PokemonEncontrado(String nome, String tipo, Treinador treinador) {
        this.nome = nome;
        this.tipo = tipo;
        this.treinador = treinador;
    }

    // Construtor vazio para o JPA
    public PokemonEncontrado() {
    }

    @Override
    public String toString() {
        return "PokemonEncontrado{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", tipo='" + tipo + '\'' +
                ", treinador=" + treinador.getNome() +  // Exibe o nome do treinador associado
                '}';
    }
}
