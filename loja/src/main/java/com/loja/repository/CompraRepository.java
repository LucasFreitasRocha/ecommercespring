package com.loja.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.loja.modelo.Compra;

@Repository
public interface CompraRepository extends CrudRepository<Compra, Long>{

}