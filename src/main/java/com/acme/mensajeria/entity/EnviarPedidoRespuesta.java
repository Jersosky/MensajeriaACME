package com.acme.mensajeria.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class EnviarPedidoRespuesta {
	@JsonProperty("codigoEnvio")
	private String codigo;
	@JsonProperty("estado")
	private String mensaje;
	
	
	
}
