package com.example.UMl.Domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.example.UMl.enums.TipoClient;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Cliente implements Serializable{
  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  private String nome;
  private String email;
  private String cpfOuCnpj;
  private Integer tipo;

  @JsonManagedReference
  @OneToMany(mappedBy = "cliente")
  private List<Endereco> enderecos = new ArrayList<>();

  @ElementCollection
  @CollectionTable(name = "TELEFONE")
  private Set<String> telefones = new HashSet<>();

  @OneToMany(mappedBy = "cliente")
  private List<Pedido> pedidos = new ArrayList<>();

    public Cliente() {

    }
    public Cliente(Integer id, String nome, String email, String cpfOuCnpj, TipoClient tipo) {
      super();
      this.id = id;
      this.nome = nome;
      this.email = email;
      this.cpfOuCnpj = cpfOuCnpj;
      this.tipo = tipo.getCod();
    }

    public String getCpfOuCnpj() {
      return cpfOuCnpj;
    }
    public void setCpfOuCnpj(String cpfOuCnpj) {
      this.cpfOuCnpj = cpfOuCnpj;
    }
    public String getEmail() {
      return email;
    }
    public void setEmail(String email) {
      this.email = email;
    }
    public List<Endereco> getEnderecos() {
      return enderecos;
    }
    public void setEnderecos(List<Endereco> enderecos) {
      this.enderecos = enderecos;
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
    public Set<String> getTelefones() {
      return telefones;
    }
    public void setTelefones(Set<String> telefones) {
      this.telefones = telefones;
    }
    public TipoClient getTipo() {
      return TipoClient.toEnum(tipo);
    }
    public void setTipo(TipoClient tipo) {
      this.tipo = tipo.getCod();
    }
    @Override
    public int hashCode() {
      // TODO Auto-generated method stub
      return super.hashCode();
    }
    public List<Pedido> getPedidos() {
      return pedidos;
    }
    public void setPedidos(List<Pedido> pedidos) {
      this.pedidos = pedidos;
    }
}
