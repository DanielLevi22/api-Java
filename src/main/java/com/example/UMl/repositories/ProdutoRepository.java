package com.example.UMl.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.UMl.Domain.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer>{

} 