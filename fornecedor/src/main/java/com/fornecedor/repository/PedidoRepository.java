package com.fornecedor.repository;

import org.springframework.data.repository.CrudRepository;

import com.fornecedor.modelo.Pedido;

public interface PedidoRepository extends CrudRepository<Pedido, Long>{

}
