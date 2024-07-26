package com.example.SitePGE.entities;

import java.sql.Date;
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
   @Column(name="id")
   private int id;

   @Column(name="tipo")
   private String tipo;

   @Column(name="descricao")
   private String descricao;

   @Column(name="data_movimentacao")
   private Date dataMovimentacao;

   @ManyToOne(fetch = FetchType.LAZY)
   @JoinColumn(name="processo_id")
   private Processo processo;

   public Movimentacao(int id, String tipo, String descricao, Date dataMovimentacao, Processo processo) {
       this.id = id;
       this.tipo = tipo;
       this.descricao = descricao;
       this.dataMovimentacao = dataMovimentacao;
       this.processo = processo;
   }

   public int getId() {
       return id;
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
               "id=" + id +
               ", tipo='" + tipo + '\'' +
               ", descricao='" + descricao + '\'' +
               ", dataMovimentacao=" + dataMovimentacao +
               ", processo=" + processo +
               '}';
   }
}
