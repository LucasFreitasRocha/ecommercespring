package com.loja.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.loja.controller.dto.CompraDTO;
import com.loja.modelo.Compra;
import com.loja.service.CompraService;

@RestController
@RequestMapping("/compra")
public class CompraController {

	@Autowired private CompraService compraService;
	
	@PostMapping
	public Compra comprar(@RequestBody CompraDTO compra) {
		 return compraService.realizaCompra(compra);
	}
}
