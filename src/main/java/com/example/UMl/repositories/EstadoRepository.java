package com.example.UMl.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.UMl.Domain.Estado;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Integer>{

  
} 