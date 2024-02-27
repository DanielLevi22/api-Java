package com.example.UMl.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.UMl.Domain.Pedido;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Integer>{

  
} 