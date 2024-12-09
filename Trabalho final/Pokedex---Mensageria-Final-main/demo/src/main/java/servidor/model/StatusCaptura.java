//package servidor.model;
//
//import jakarta.persistence.*;
//import lombok.Getter;
//import lombok.Setter;
//
//@Entity
//@Getter
//@Setter
//@Table(name = "statuscaptura")
//public class StatusCaptura {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    public StatusCaptura() {
//    }
//
//    @OneToOne                                           // se atentar ao nome da
//    @JoinColumn(name = "pokemon_id", nullable = false) //chave estrangeira definida
//    private PokemonEncontrado pokemon;
//
//    @ManyToOne                                            // se atentar ao nome da
//    @JoinColumn(name = "treinador_id", nullable = false) //chave estrangeira definida
//    private Treinador treinador;
//
//    private String status; // capturado ou fugiu
//    private String localizacao;
//
//    public StatusCaptura(long id, PokemonEncontrado pokemon, Treinador treinador, String status, String localizacao) {
//    }
//}
package servidor.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "statuscaptura")
public class StatusCaptura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Relação com PokemonEncontrado (um para um)
    @OneToOne
    @JoinColumn(name = "pokemon_id", nullable = false)
    private PokemonEncontrado pokemon;

    // Relação com Treinador (muitos para um)
    @ManyToOne
    @JoinColumn(name = "treinador_id", nullable = false)
    private Treinador treinador;

    private String status;  // Exemplo: capturado ou fugiu
    private String localizacao;

    // Construtor padrão, que o Lombok já vai gerar com @Getter e @Setter
    public StatusCaptura() {
    }

    // Se você precisar de um construtor com parâmetros, ele pode ser assim:
    public StatusCaptura(PokemonEncontrado pokemon, Treinador treinador, String status, String localizacao) {
        this.pokemon = pokemon;
        this.treinador = treinador;
        this.status = status;
        this.localizacao = localizacao;
    }
}

