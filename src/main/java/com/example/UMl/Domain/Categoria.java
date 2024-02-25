package com.example.UMl.Domain;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;



@Entity
public class Categoria implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  private String nome;

  public Categoria(Integer id) {
    this.id = id;
  }

  public Categoria() {

  }
  public Categoria(Integer id, String nome) {
    super();
    this.id = id;
    this.nome = nome;
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
    // TODO Auto-generated method stub
    return super.hashCode();
  }

}
