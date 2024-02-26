package com.example.UMl.services;

import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.UMl.Domain.Cliente;
import com.example.UMl.exception.ObjectNotFoundException;
import com.example.UMl.repositories.ClienteRepository;

@Service
public class ClienteService {
  
  @Autowired
  private ClienteRepository repo;


 public Cliente find(Integer id) {
Optional<Cliente> obj = repo.findById(id);
return obj.orElseThrow(() -> new ObjectNotFoundException(
"Objeto não encontrado! Id: " + id + ", Tipo: " + Cliente.class.getName()));
}
}
