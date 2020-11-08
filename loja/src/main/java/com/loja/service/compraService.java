package com.loja.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.loja.client.FornecedorClient;
import com.loja.controller.dto.CompraDTO;
import com.loja.controller.dto.InfoFornecedorDTO;
import com.loja.controller.dto.InfoPedidoDTO;
import com.loja.modelo.Compra;

@Service
public class CompraService {
	
	/*@Autowired
	private RestTemplate client;*/
	
	@Autowired
	private FornecedorClient fornecedorClient;

	
	
	public Compra  realizaCompra(CompraDTO compra) {
		// TODO Auto-generated method stub
	/* ResponseEntity<InfoFornecedorDTO> info	=  client
			 .exchange("http://fornecedor/info/"+compra.getEndereco().getEstado(), 
					 HttpMethod.GET, null, InfoFornecedorDTO.class);
	 return info.getBody();*/
		

		InfoFornecedorDTO info = fornecedorClient.getInfoPorEstado(compra.getEndereco().getEstado());
		InfoPedidoDTO pedido = fornecedorClient.realizaPedido(compra.getItens());
		Compra c = new Compra();
		c.setPedidoId(pedido.getId());
		c.setTempoDePreparo(pedido.getTempoDePreparo());
		c.setEnderecoDestino(compra.getEndereco().toString());
		return c;
	}

}
