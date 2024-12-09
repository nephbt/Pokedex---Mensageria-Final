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

    @ManyToOne                                           // se atentar ao nome da
    @JoinColumn(name = "treinador_id", nullable = false) //chave estrangeira definida
    private Treinador treinador;

    public PokemonEncontrado(long id, String nome, String tipo, Treinador treinador) {
    }
}
