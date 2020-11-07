package com.loja.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.loja.controller.dto.CompraDTO;
import com.loja.modelo.Compra;
import com.loja.service.compraService;

@RestController
@RequestMapping("/compra")
public class compra {

	
	@PostMapping
	public Compra realizaCompra(@RequestBody CompraDTO compra) {
		return compraService.realizaCompra(compra);
	}
}
