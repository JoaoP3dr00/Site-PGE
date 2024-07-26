package com.example.SitePGE.entities;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="processo")
@NoArgsConstructor
@Setter
public class Processo {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="id")
    private int id;

    @Column(name="numero_processo")
    private String numeroProcesso;

    @Column(name="valor_divida")
    private String valorDivida;

    @Column(name="juiz")
    private String juiz;

    @Column(name="vara")
    private String vara;

    @Column(name="executado")
    private String executado;
    
    @Temporal(TemporalType.DATE)
    @Column(name="data_distribuicao")
    private Date dataDistribuicao;

    @Temporal(TemporalType.DATE)
    @Column(name="data_prescicao")
    private Date dataPrescricao;
    
    @Column(name="status_prescricao")
    private String statusPrescricao;

    @Column(name="tipo_assunto")
    private String tipoAssunto;

    @Column(name="descricao")
    private String descricao;

    public Processo(int id, String numeroProcesso, String valorDivida, String juiz, String vara, String executado, Date dataDistribuicao, Date dataPrescricao, String statusPrescricao, String tipoAssunto, String descricao) {
        this.id = id;
        this.numeroProcesso = numeroProcesso;
        this.valorDivida = valorDivida;
        this.juiz = juiz;
        this.vara = vara;
        this.executado = executado;
        this.dataDistribuicao = dataDistribuicao;
        this.dataPrescricao = dataPrescricao;
        this.statusPrescricao = statusPrescricao;
        this.tipoAssunto = tipoAssunto;
        this.descricao = descricao;
    }

    public int getId() {
        return id;
    }

    public String getNumeroProcesso() {
        return numeroProcesso;
    }

    public String getValorDivida() {
        return valorDivida;
    }

    public String getJuiz() {
        return juiz;
    }

    public String getVara() {
        return vara;
    }

    public String getExecutado() {
        return executado;
    }

    public Date getDataDistribuicao() {
        return dataDistribuicao;
    }

    public Date getDataPrescricao() {
        return dataPrescricao;
    }

    public String getStatusPrescricao() {
        return statusPrescricao;
    }

    public String getTipoAssunto() {
        return tipoAssunto;
    }

    public String getDescricao() {
        return descricao;
    }

    @Override
    public String toString() {
        return "Processo{" +
                "id=" + id +
                ", numeroProcesso='" + numeroProcesso + '\'' +
                ", valorDivida=" + valorDivida +
                ", juiz='" + juiz + '\'' +
                ", vara='" + vara + '\'' +
                ", executado='" + executado + '\'' +
                ", dataDistribuicao=" + dataDistribuicao +
                ", dataPrescricao=" + dataPrescricao +
                ", statusPrescricao='" + statusPrescricao + '\'' +
                ", tipoAssunto='" + tipoAssunto + '\'' +
                ", descricao='" + descricao + '\'' +
                '}';
    }
}
