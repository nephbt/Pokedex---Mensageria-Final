//package servidor.model;
//
//import jakarta.persistence.*;
//import lombok.Getter;
//import lombok.Setter;
//
//import java.util.List;
//
//@Entity
//@Getter
//@Setter
//public class Treinador {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY) //ID autoincrementado no banco de dados
//    private Long id;
//    private String nome;
//    private int nivel;
//
//    @OneToMany(mappedBy = "treinador", cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<PokemonEncontrado> pokemonsEncontrados; //um treinador pode encontrar vários Pokémons
//
//    public Treinador(String nome, int nivel) {
//    }
//
//    public Treinador() {
//
//    }
//}
package servidor.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Treinador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // ID autoincrementado no banco de dados
    private Long id;

    private String nome;
    private int nivel;

    @OneToMany(mappedBy = "treinador", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PokemonEncontrado> pokemonsEncontrados; // Um treinador pode encontrar vários Pokémons

    // Construtor para inicializar o Treinador com nome e nível
    public Treinador(String nome, int nivel) {
        this.nome = nome;
        this.nivel = nivel;
    }

    // Construtor vazio para inicializações sem parâmetros (necessário para JPA)
    public Treinador() {
    }

    @Override
    public String toString() {
        return "Treinador{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", nivel=" + nivel +
                '}';
    }
}
