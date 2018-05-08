package com.meumenu.model;

import java.util.Objects;

/**
 *
 * @author LucasReinaldo
 */
public class Receita {

    private Integer id;
    private String titulo;
    private String texto;

    public Receita(Integer id,String titulo, String texto) {
        this.id = id;
        this.titulo = titulo;
        this.texto = texto;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

}
