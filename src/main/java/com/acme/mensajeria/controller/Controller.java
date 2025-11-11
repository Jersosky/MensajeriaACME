package com.acme.mensajeria.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.acme.mensajeria.entity.EnviarPedido;
import com.acme.mensajeria.entity.EnviarPedidoRespuesta;
import com.acme.mensajeria.entity.RequestDTO;
import com.acme.mensajeria.entity.ResponseDTO;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/")
public class Controller {

	private final XmlMapper xmlMapper = new XmlMapper();
	private final XmlMapper xmljsonMapper = new XmlMapper();
	private final ObjectMapper jsonMapper = new ObjectMapper();
	
	@PostMapping(value = "mensajeria", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> postMethodName(@RequestBody RequestDTO entity) {
		String xml = "";
		
		try {
			
			// Transformacion de json a XML 
			// Se imprime en consola el xml transformado
			xml = xmlMapper.writeValueAsString(entity);
			System.out.println(xml);
			
			System.out.println("---------------------------------------------------------");
			// Transformacion de XML en json -- Se dejan datos estaticos ya que en la ruta de obtencion no responde (evidencia en archivo .md)
			String xmlResponse = """
					<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:env="http://WSDLs/EnvioPedidos/EnvioPedidosAcme">
   <soapenv:Header/>
   <soapenv:Body>
      <env:EnvioPedidoAcmeResponse>
         <EnvioPedidoResponse>
            <!--Optional:-->
            <Codigo>80375472</Codigo>
            <!--Optional:-->
            <Mensaje>Entregado exitosamente al cliente</Mensaje>
         </EnvioPedidoResponse>
      </env:EnvioPedidoAcmeResponse>
   </soapenv:Body>
</soapenv:Envelope>
					""";
			
			JsonNode jsonNode = xmljsonMapper.readTree(xmlResponse);
			JsonNode envioPedidoNode = jsonNode.get("Body").get("EnvioPedidoAcmeResponse").get("EnvioPedidoResponse");
			
			String jsonResponse = jsonMapper.writerWithDefaultPrettyPrinter().writeValueAsString(jsonNode);
			
			EnviarPedidoRespuesta enviarPedidoRespuesta = new EnviarPedidoRespuesta(envioPedidoNode.get("Codigo").asText(),envioPedidoNode.get("Mensaje").asText());
			
			ResponseDTO dto = new ResponseDTO(enviarPedidoRespuesta);
			
			// Se imprime en consola el json transformado
			System.out.println(jsonResponse);
			
			return ResponseEntity.ok(dto);
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
		
	}
	
}
