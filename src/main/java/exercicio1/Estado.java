package exercicio1;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Estado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String uf;

    @OneToMany(
            mappedBy = "estado",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )

    private List<Aluno> alunos = new ArrayList<>();

    public Estado() { }

    public Estado(String nome, String uf) {
        this.nome = nome;
        this.uf = uf;
    }

    public Estado(String nome, String uf, List<Aluno> alunos) {
        this.nome = nome;
        this.uf = uf;
        this.alunos = alunos;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String toString() {
        return "Estado{" +
                "Id=" + id +
                ", nome='" + nome + '\n' +
                ", uf='" + uf + '\n' +
                ", alunos='" + alunos +
                '}';
    }
}
