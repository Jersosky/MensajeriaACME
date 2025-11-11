package com.acme.mensajeria.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import lombok.Data;

@Data
public class EnviarPedido {

	@JsonProperty("numPedido")
    @JacksonXmlProperty(localName = "pedido")
    private String numPedido;
    
    @JsonProperty("cantidadPedido")
    @JacksonXmlProperty(localName = "Cantidad")
    private String cantidadPedido;
    
    @JsonProperty("codigoEAN")
    @JacksonXmlProperty(localName = "EAN")
    private String codigoEAN;
    
    @JsonProperty("nombreProducto")
    @JacksonXmlProperty(localName = "Producto")
    private String nombreProducto;
    
    @JsonProperty("numDocumento")
    @JacksonXmlProperty(localName = "Cedula")
    private String numDocumento;
    
    @JsonProperty("direccion")
    @JacksonXmlProperty(localName = "Direccion")
    private String direccion;

}
