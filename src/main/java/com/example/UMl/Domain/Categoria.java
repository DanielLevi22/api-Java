package com.example.UMl.Domain;

import java.io.Serializable;

public class Categoria implements Serializable {
  private Integer id;
  public Categoria(Integer id) {
    this.id = id;
  }
  private String nome;

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
