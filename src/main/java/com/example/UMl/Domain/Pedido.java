package com.example.UMl.Domain;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.mapping.OneToOne;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Pedido implements Serializable{
  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
  private Date instante;

@JsonManagedReference
@jakarta.persistence.OneToOne(cascade = CascadeType.ALL, mappedBy ="pedido")
  private Pagamento pagamento;

  @JsonManagedReference
  @ManyToOne
  @JoinColumn(name = "cliente_id")
  private Cliente cliente;

  @ManyToOne
  @JoinColumn(name ="endereco_de_entrega_id")
  private Endereco enderecoDeEntrega;

  @OneToMany(mappedBy = "id.pedido")
  private Set<ItemPedido> items = new HashSet<>();
  public Pedido() {}

  public Pedido(Integer id, Date instante, Cliente cliente, Endereco enderecoDeEntrega){
    super();
    this.id = id;
    this.instante = instante;
    this.cliente = cliente;
    this.enderecoDeEntrega = enderecoDeEntrega;
  }  

  public Set<ItemPedido> getItems() {
    return items;
  }
  public void setItems(Set<ItemPedido> items) {
    this.items = items;
  }
  public Cliente getCliente() {
    return cliente;
  }
  public void setCliente(Cliente cliente) {
    this.cliente = cliente;
  }
  public Endereco getEnderecoDeEntrega() {
    return enderecoDeEntrega;
  }
  public void setEnderecoDeEntrega(Endereco enderecoDeEntrega) {
    this.enderecoDeEntrega = enderecoDeEntrega;
  }
  public Integer getId() {
    return id;
  }
  public void setId(Integer id) {
    this.id = id;
  }
  public Date getInstante() {
    return instante;
  }
  public void setInstante(Date instante) {
    this.instante = instante;
  }
  public Pagamento getPagamento() {
    return pagamento;
  }
  public void setPagamento(Pagamento pagamento) {
    this.pagamento = pagamento;
  }
@Override
public int hashCode() {
  // TODO Auto-generated method stub
  return super.hashCode();
}
}
