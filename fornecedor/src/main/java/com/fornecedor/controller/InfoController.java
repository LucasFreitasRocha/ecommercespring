package com.fornecedor.controller;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fornecedor.modelo.InfoFornecedor;
import com.fornecedor.service.InfoService;

@RestController
@RequestMapping("/info")
public class InfoController {

	@Autowired
	private InfoService infoService;
	
	private static final Logger LOG = org.slf4j.LoggerFactory.getLogger(InfoController.class);
	
	@RequestMapping("/{estado}")
	public InfoFornecedor getInfoPorEstado(@PathVariable String estado) {
		LOG.info("recebido pedido de informações do fornecedor de {}", estado);
		
		return infoService.getInfoPorEstado(estado);
	}
}
