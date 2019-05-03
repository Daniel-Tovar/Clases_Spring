package com.example.Proyecto1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Proyecto1.domain.Client;

@Repository//Le indica a spring que esta clase es un repositorio (contiene las operaciones de persistencia)
public interface ClientRepository extends JpaRepository <Client,Long>{
//Se extiende JpaRepository para que sepa que tipo de datos va a persistir
}
