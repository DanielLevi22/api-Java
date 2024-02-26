package com.example.UMl.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.UMl.Domain.Cidade;

@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Integer>{

  
} 