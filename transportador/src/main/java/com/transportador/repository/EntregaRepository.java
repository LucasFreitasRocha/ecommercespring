package com.transportador.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.transportador.modelo.Entrega;



@Repository
public interface EntregaRepository extends CrudRepository<Entrega, Long>{

}
