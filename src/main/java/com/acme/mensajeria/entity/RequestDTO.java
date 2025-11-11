package com.acme.mensajeria.entity;

import lombok.Data;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@Data
@JacksonXmlRootElement(localName = "EnvioPedidoAcme")
public class RequestDTO {
	
	@JsonProperty("enviarPedido")
    @JacksonXmlProperty(localName = "EnvioPedidoRequest")
    private EnviarPedido enviarPedido;
}