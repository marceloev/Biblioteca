package br.com.sinergia.Entity;

import javax.persistence.*;

@Entity(name = "LIVRO")
@NamedQueries({
        @NamedQuery(name = "Livro.findAll",
                query = "SELECT L FROM LIVRO L"),
        @NamedQuery(name = "Livro.findByCod",
                query = "SELECT L FROM LIVRO L WHERE L.codigo = :P_CODLIV"),
        @NamedQuery(name = "Livro.findByNome",
                query = "SELECT L FROM LIVRO L WHERE UPPER(L.nome) LIKE UPPER(:P_NOMELIV)")
})
@Table(name = "TLIV")
public class Livro {

    @Id
    @Column(name = "CODLIV")
    private int codigo;

    @Column(name = "NOMELIV")
    private String nome;

    @Column(name = "SINOPSE")
    private String sinopse;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSinopse() {
        return sinopse;
    }

    public void setSinopse(String sinopse) {
        this.sinopse = sinopse;
    }

    @Override
    public String toString() {
        return "Livro{" +
                "codigo=" + codigo +
                ", nome='" + nome + '\'' +
                ", sinopse='" + sinopse + '\'' +
                '}';
    }
}
