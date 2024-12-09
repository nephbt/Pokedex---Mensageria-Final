//package servidor.model;
//
//import jakarta.persistence.*;
//import lombok.Getter;
//import lombok.Setter;
//
//@Entity
//@Getter
//@Setter
//@Table(name = "pokemonencontrado")
//public class PokemonEncontrado {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    private String nome;
//    private String tipo;
//
//    public PokemonEncontrado() {
//
//    }
//
//    @ManyToOne                                           // se atentar ao nome da
//    @JoinColumn(name = "treinador_id", nullable = false) //chave estrangeira definida
//    private Treinador treinador;
//
//    public PokemonEncontrado(Long id, String nome, String tipo, Treinador treinador) {
//
//    }
//}

package servidor.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "pokemonencontrado")
public class PokemonEncontrado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String tipo;

    // Relacionamento com o Treinador (muitos para um)
    @ManyToOne
    @JoinColumn(name = "treinador_id", nullable = false)
    private Treinador treinador;

    // Construtor padrão
    public PokemonEncontrado() {
    }

    // Construtor com parâmetros
    public PokemonEncontrado(String nome, String tipo, Treinador treinador) {
        this.nome = nome;
        this.tipo = tipo;
        this.treinador = treinador;
    }
}
