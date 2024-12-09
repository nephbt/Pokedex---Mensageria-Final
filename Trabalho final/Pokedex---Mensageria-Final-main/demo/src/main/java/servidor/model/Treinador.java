package servidor.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "treinador")
public class Treinador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //ID autoincrementado no banco de dados
    private Long id;
    private String nome;
    private int nivel;

    public Treinador() {
    }

    @OneToMany(mappedBy = "treinador", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PokemonEncontrado> pokemonsEncontrados; //um treinador pode encontrar vários Pokémons

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public List<PokemonEncontrado> getPokemonsEncontrados() {
        return pokemonsEncontrados;
    }

    public void setPokemonsEncontrados(List<PokemonEncontrado> pokemonsEncontrados) {
        this.pokemonsEncontrados = pokemonsEncontrados;
    }

    public Treinador(String nome, int nivel) {
    }
}
