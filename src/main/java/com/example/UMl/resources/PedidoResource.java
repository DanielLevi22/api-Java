package com.example.UMl.resources;
import org.springframework.web.bind.annotation.RestController;
import com.example.UMl.Domain.Pedido;
import com.example.UMl.services.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@RestController
@RequestMapping(value ="/pedidos")

public class PedidoResource {
  @Autowired
  private PedidoService service;
  
  @RequestMapping(value = "/{id}",method = RequestMethod.GET)

  public ResponseEntity<?> find(@PathVariable Integer id) {

    Pedido obj = service.find(id);
    return ResponseEntity.ok().body(obj);
  }
  
}
