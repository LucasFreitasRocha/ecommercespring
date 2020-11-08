package com.loja.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.loja.client.FornecedorClient;
import com.loja.controller.dto.CompraDTO;
import com.loja.controller.dto.InfoFornecedorDTO;
import com.loja.controller.dto.InfoPedidoDTO;
import com.loja.modelo.Compra;
import org.slf4j.Logger;


@Service
public class CompraService {
	
	/*@Autowired
	private RestTemplate client;*/
	
	@Autowired
	private FornecedorClient fornecedorClient;

	private static final Logger LOG = org.slf4j.LoggerFactory.getLogger(CompraService.class);
	
	public Compra  realizaCompra(CompraDTO compra) {
		// TODO Auto-generated method stub
	/* ResponseEntity<InfoFornecedorDTO> info	=  client
			 .exchange("http://fornecedor/info/"+compra.getEndereco().getEstado(), 
					 HttpMethod.GET, null, InfoFornecedorDTO.class);
	 return info.getBody();*/
		
		LOG.info("Buscando informações do fornecedor de {}", compra.getEndereco().getEstado());
		InfoFornecedorDTO info = fornecedorClient.getInfoPorEstado(compra.getEndereco().getEstado());
		LOG.info("realizando um pedido");
		InfoPedidoDTO pedido = fornecedorClient.realizaPedido(compra.getItens());
		Compra c = new Compra();
		c.setPedidoId(pedido.getId());
		c.setTempoDePreparo(pedido.getTempoDePreparo());
		c.setEnderecoDestino(info.getEndereco());
		return c;
	}

}
