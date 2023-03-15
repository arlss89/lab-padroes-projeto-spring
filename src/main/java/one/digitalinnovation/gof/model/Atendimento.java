package one.digitalinnovation.gof.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Atendimento {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long idCliente;
    private String descricao;
    private String feedback;
    private Boolean resolvido = false;

    private Atendimento() {}

    public Atendimento(Cliente cliente) { }

    public Atendimento(Long idCliente, String descricao, String feedback, Boolean resolvido) {
        this.idCliente = idCliente;
        this.descricao = descricao;
        this.feedback = feedback;
        this.resolvido = resolvido;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Boolean getResolvido() {
        return resolvido;
    }

    public void setResolvido(Boolean resolvido) {
        this.resolvido = resolvido;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    @Override
    public String toString() {
        return "Atendimento{" +
                "idCliente=" + idCliente +
                ", descricao='" + descricao + '\'' +
                ", feedback='" + feedback + '\'' +
                ", resolvido=" + resolvido +
                '}';
    }
}
