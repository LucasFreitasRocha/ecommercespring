package com.loja.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.loja.client.FornecedorClient;
import com.loja.controller.dto.CompraDTO;
import com.loja.controller.dto.InfoFornecedorDTO;

@Service
public class CompraService {
	
	/*@Autowired
	private RestTemplate client;*/
	
	@Autowired
	private FornecedorClient fornecedorClient;

	public InfoFornecedorDTO  realizaCompra(CompraDTO compra) {
		// TODO Auto-generated method stub
	/* ResponseEntity<InfoFornecedorDTO> info	=  client
			 .exchange("http://fornecedor/info/"+compra.getEndereco().getEstado(), 
					 HttpMethod.GET, null, InfoFornecedorDTO.class);
	 return info.getBody();*/
		return fornecedorClient.getInfoPorEstado(compra.getEndereco().getEstado());
	}

}
