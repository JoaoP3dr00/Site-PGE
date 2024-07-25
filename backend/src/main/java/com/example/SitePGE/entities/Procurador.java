package com.example.SitePGE.entities;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity // Sinaliza para o JPA que essa classe é uma entidade
@Table(name="procurador")   // Sinaliza para o JPA a tabela em questão
@NoArgsConstructor  // Cria o construtor sem parâmetros
@Setter // Cria os setters para os atributos da classe
@ToString // Cria o método toString da classe
public class Procurador {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private int id;

    @Column(name="p_name", length = 255)
    private String name;

    @Column(name="email", length=255)
    private String email;
    
    @Column(name="p_password", length = 255)
    private String password;

    /**
     * Método construtor para todos os atributos da classe Procurador
     * @param id
     * @param name
     * @param email
     * @param password
     */
    public Procurador(int id, String name, String email, String password){
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    /**
     * Método get para o atributo procurador_id
     * @return
     */
    public int getProcuradorid(){
        return this.id;
    }

    /**
     * Método get para o atributo procurador_name
     * @return
     */
    public String getProcuradorname(){
        return this.name;
    }

    /**
     * Método get para o atributo procurador_email
     * @return
     */
    public String getProcuradoremail(){
        return this.email;
    }

    /**
     * Método get para o atributo procurador_password
     * @return
     */
    public String getProcuradorpassword(){
        return this.password;
    }
}
