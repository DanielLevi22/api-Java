package com.example.UMl.services;

import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.UMl.Domain.Pedido;
import com.example.UMl.exception.ObjectNotFoundException;
import com.example.UMl.repositories.PedidoRepository;

@Service
public class PedidoService {
  
  @Autowired
  private PedidoRepository repo;


 public Pedido find(Integer id) {
Optional<Pedido> obj = repo.findById(id);
return obj.orElseThrow(() -> new ObjectNotFoundException(
"Objeto não encontrado! Id: " + id + ", Tipo: " + Pedido.class.getName()));
}
}
