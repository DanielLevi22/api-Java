package com.example.UMl.services;

import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.UMl.Domain.Categoria;
import com.example.UMl.exception.ObjectNotFoundException;
import com.example.UMl.repositories.CategoriaRepository;

@Service
public class CategoriaService {
  
  @Autowired
  private CategoriaRepository repo;


 public Categoria find(Integer id) {
Optional<Categoria> obj = repo.findById(id);
return obj.orElseThrow(() -> new ObjectNotFoundException(
"Objeto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName()));
}
}
