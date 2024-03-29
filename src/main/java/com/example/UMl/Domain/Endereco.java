package com.example.UMl.Domain;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
@Entity
public class Endereco implements Serializable{
  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  private String lagradouro;
  private String  numero;
  private String complemento;
  private String bairro;
  private String cep;

  @ManyToOne
  @JoinColumn(name = "cliente_id")
  private  Cliente cliente;
  @JsonBackReference
  @ManyToOne
  @JoinColumn(name = "cidade_id")
  private Cidade cidade;
  public Endereco() {

  }

  public Endereco(Integer id, String lagradouro, String numero, String complemento, String bairro,  String cep, Cliente cliente,Cidade cidade) {
    super();
    this.bairro = bairro;
    this.id = id;
    this.lagradouro = lagradouro;
    this.complemento = complemento;
    this.cep = cep;
    this.numero = numero;
    this.cliente = cliente;
    this.cidade = cidade;
  }
  public String getBairro() {
    return bairro;
  }
  public void setBairro(String bairro) {
    this.bairro = bairro;
  }
  public String getCep() {
    return cep;
  }
  public void setCep(String cep) {
    this.cep = cep;
  }
  public Cliente getCliente() {
    return cliente;
  }
  public void setCliente(Cliente cliente) {
    this.cliente = cliente;
  }
  public String getComplemento() {
    return complemento;
  }
  public void setComplemento(String complemento) {
    this.complemento = complemento;
  }
  public Integer getId() {
    return id;
  }
  public void setId(Integer id) {
    this.id = id;
  }
  public String getLagradouro() {
    return lagradouro;
  }
  public void setLagradouro(String lagradouro) {
    this.lagradouro = lagradouro;
  }
  public String getNumero() {
    return numero;
  }
  public void setNumero(String numero) {
    this.numero = numero;
  }
  public Cidade getCidade() {
    return cidade;
  }
  public void setCidade(Cidade cidade) {
    this.cidade = cidade;
  }
  @Override
  public int hashCode() {
    // TODO Auto-generated method stub
    return super.hashCode();
  }

}