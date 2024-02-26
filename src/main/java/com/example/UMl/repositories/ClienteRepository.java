package com.example.UMl.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.UMl.Domain.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer>{

  
} 