package com.loja.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.loja.controller.dto.CompraDTO;
import com.loja.controller.dto.InfoFornecedorDTO;

@Service
public class CompraService {
	
	@Autowired
	private RestTemplate client;

	public InfoFornecedorDTO  realizaCompra(CompraDTO compra) {
		// TODO Auto-generated method stub
	 ResponseEntity<InfoFornecedorDTO> info	=  client
			 .exchange("http://fornecedor/info/"+compra.getEndereco().getEstado(), 
					 HttpMethod.GET, null, InfoFornecedorDTO.class);
	 return info.getBody();
	}

}
