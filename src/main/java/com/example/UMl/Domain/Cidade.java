package com.example.UMl.Domain;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;


@Entity
public class Cidade implements Serializable{
  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  private String nome;

  @JsonManagedReference
  @ManyToOne
  @JoinColumn(name = "estado_id")
  private Estado estado;

  public Cidade() {}
  public Cidade(Integer id, String nome, Estado estado) {
    super();
    this.estado = estado;
    this.id = id;
    this.nome = nome;
  }

  public Estado getEstado() {
    return estado;
  }
  public void setEstado(Estado estado) {
    this.estado = estado;
  }
  public Integer getId() {
    return id;
  }
  public void setId(Integer id) {
    this.id = id;
  }
  public String getNome() {
    return nome;
  }
  public void setNome(String nome) {
    this.nome = nome;
  }
  @Override
  public int hashCode() {
    return super.hashCode();
  }
}
