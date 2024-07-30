package com.example.SitePGE.entities;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="movimentacao")
@NoArgsConstructor
@Setter
public class Movimentacao {
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   @Column(name="m_id")
   private int m_id;

   @Column(name="tipo")
   private String tipo;

   @Column(name="descricao")
   private String descricao;

   @Column(name="data_movimentacao")
   private Date dataMovimentacao;

   @ManyToOne(fetch = FetchType.LAZY)
   @JoinColumn(name="p_id")
   @JsonBackReference
   private Processo processo;

   public Movimentacao(int id, String tipo, String descricao, Date dataMovimentacao, Processo processo_id) {
       this.m_id = id;
       this.tipo = tipo;
       this.descricao = descricao;
       this.dataMovimentacao = dataMovimentacao;
       this.processo = processo_id;
   }

   public int getM_id() {
       return m_id;
   }

   public String getTipo() {
       return tipo;
   }

   public String getDescricao() {
       return descricao;
   }

   public Date getDataMovimentacao() {
       return dataMovimentacao;
   }

   public Processo getProcesso() {
       return processo;
   }

   @Override
   public String toString() {
       return "Movimentacao{" +
               "id=" + m_id +
               ", tipo='" + tipo + '\'' +
               ", descricao='" + descricao + '\'' +
               ", dataMovimentacao=" + dataMovimentacao +
               ", processo=" + processo +
               '}';
   }
}
