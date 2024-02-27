package com.example.UMl.Domain;

import java.io.Serializable;

import com.example.UMl.enums.EstadoPagamento;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Pagamento implements Serializable{
  private static final long serialVersionUID = 1L;
  @Id
  private Integer id;

  private Integer estado;

  @OneToOne
  @JoinColumn(name = "pedido_id")
  @MapsId
  private Pedido pedido;

  public Pagamento(){}


  public Pagamento(Integer id, EstadoPagamento estado,Pedido pedido) {
    super();
    this.id = id;
    this.estado = estado.getCod();
    this.pedido = pedido;
  }
  public EstadoPagamento getEstado() {
    return EstadoPagamento.toEnum(estado);
  }
  public void setEstado(EstadoPagamento estado) {
    this.estado = estado.getCod();
  }
  public Integer getId() {
    return id;
  }
  public void setId(Integer id) {
    this.id = id;
  }
  public Pedido getPedido() {
    return pedido;
  }
  public void setPedido(Pedido pedido) {
    this.pedido = pedido;
  }
  @Override
  public int hashCode() {
    // TODO Auto-generated method stub
    return super.hashCode();
  }
 }
