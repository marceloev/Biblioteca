package br.com.sinergia.Entity;

import javax.persistence.*;

@Entity(name = "BIBLIOTECA")
@NamedQueries({
        @NamedQuery(name = "Biblioteca.findAll",
                query = "SELECT B FROM BIBLIOTECA B"),
        @NamedQuery(name = "Biblioteca.findByCod",
                query = "SELECT B FROM BIBLIOTECA B WHERE B.codigo = :P_CODBIB"),
        @NamedQuery(name = "Biblioteca.findByName",
                query = "SELECT B FROM BIBLIOTECA B\n" +
                        "WHERE UPPER(B.razaoSocial) LIKE UPPER(:P_NOME)\n" +
                        "OR UPPER(B.nomeFantasia) LIKE UPPER(:P_NOME)")
})
@Table(name = "TBIB")
public class Biblioteca {

    @Id
    @Column(name = "CODBIB")
    private int codigo;

    @Column(name = "RAZAOSOCIAL")
    private String razaoSocial;

    @Column(name = "NOMEFANTASIA")
    private String nomeFantasia;

    @ManyToOne
    @JoinColumn(name = "CODEND")
    private Endereco endereco;

    @Column(name = "NUMEND")
    private String numero;

    @Column(name = "OBSEND")
    private String observacao;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    @Override
    public String toString() {
        return "Biblioteca{" +
                "codigo=" + codigo +
                ", razaoSocial='" + razaoSocial + '\'' +
                ", nomeFantasia='" + nomeFantasia + '\'' +
                ", endereco=" + endereco +
                ", numero='" + numero + '\'' +
                ", observacao='" + observacao + '\'' +
                '}';
    }
}
