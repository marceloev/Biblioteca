package br.com.sinergia.Entity;

import javax.persistence.*;

@Entity(name = "ENDERECO")
@NamedQueries({
        @NamedQuery(name = "Endereco.findAll",
                query = "SELECT E FROM ENDERECO E"),
        @NamedQuery(name = "Endereco.findByCod",
                query = "SELECT E FROM ENDERECO E WHERE E.codigo = :P_CODEND"),
        @NamedQuery(name = "Endereco.findByName",
                query = "SELECT E FROM ENDERECO E WHERE UPPER(E.descricao) LIKE UPPER(:P_DESCREND)")
})
@Table(name = "TEND")
public class Endereco {

    @Id
    @Column(name = "CODEND")
    private int codigo;

    @Column(name = "DESCREND")
    private String descricao;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "Endereco{" +
                "codigo=" + codigo +
                ", descricao='" + descricao + '\'' +
                '}';
    }
}
