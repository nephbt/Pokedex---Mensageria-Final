package servidor.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class StatusCaptura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne                                           // se atentar ao nome da
    @JoinColumn(name = "pokemon_id", nullable = false) //chave estrangeira definida
    private PokemonEncontrado pokemon;

    @ManyToOne                                            // se atentar ao nome da
    @JoinColumn(name = "treinador_id", nullable = false) //chave estrangeira definida
    private Treinador treinador;

    private String status; // capturado ou fugiu
    private String localizacao;

    public StatusCaptura(long id, PokemonEncontrado pokemon, Treinador treinador, String status, String localizacao) {
    }
}
