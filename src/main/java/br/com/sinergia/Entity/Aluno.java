package br.com.sinergia.Entity;

import javax.persistence.*;

@Entity(name = "ALUNO")
@NamedQueries({
        @NamedQuery(name = "Aluno.findAll",
                query = "SELECT A FROM ALUNO A"),
        @NamedQuery(name = "Aluno.findByCod",
                query = "SELECT A FROM ALUNO A WHERE A.codigo = :P_CODALU"),
        @NamedQuery(name = "Aluno.findByMatricula",
                query = "SELECT A From ALUNO A WHERE A.matricula = :P_MATRICULA"),
        @NamedQuery(name = "Aluno.findByName",
                query = "SELECT A FROM ALUNO A\n" +
                        "WHERE UPPER(A.nome) LIKE UPPER(:P_NOME)\n" +
                        "OR UPPER(A.sobrenome) LIKE UPPER(:P_NOME)")
})
@Table(name = "TALU")
public class Aluno {

    @Id
    @Column(name = "CODALU")
    private int codigo;

    @Column(name = "NOMEALU")
    private String nome;

    @Column(name = "SOBRENOME")
    private String sobrenome;

    @Column(name = "MATRICULA")
    private String matricula;

    @Column(name = "PASSE")
    private String passe;

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

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    @Override
    public String toString() {
        return "Aluno{" +
                "codigo=" + codigo +
                ", nome='" + nome + '\'' +
                ", sobrenome='" + sobrenome + '\'' +
                ", matricula='" + matricula + '\'' +
                '}';
    }

    public String getPasse() {
        return passe;
    }

    public void setPasse(String passe) {
        this.passe = passe;
    }
}
