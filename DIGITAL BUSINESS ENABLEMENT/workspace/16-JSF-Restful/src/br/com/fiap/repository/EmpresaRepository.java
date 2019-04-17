package br.com.fiap.repository;

import java.util.Arrays;
import java.util.List;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import br.com.fiap.exception.ResponseException;
import br.com.fiap.to.Empresa;

public class EmpresaRepository {
	
	private Client cliente = Client.create();
	private static final String URL = "http://localhost:8080/12-WS-Restful/rest/empresa/";
	
	
	
	public Empresa pesquisar(int codigo) throws ResponseException{
		WebResource resource = cliente.resource(URL).path(Integer.toString(codigo));
		
		ClientResponse response = resource.accept(MediaType.APPLICATION_JSON).get(ClientResponse.class);
		
		if(response.getStatus() != 200) {
			throw new ResponseException();
		}
		
		return response.getEntity(Empresa.class);
	}

	public List<Empresa> listar() throws ResponseException{
		WebResource resource = cliente.resource(URL);
		
		ClientResponse response = resource.accept(MediaType.APPLICATION_JSON).get(ClientResponse.class);
		
		if(response.getStatus() != 200) {
			throw new ResponseException();
		}
		
		//Recupera as empresas do WebService
		Empresa[] empresas = response.getEntity(Empresa[].class);
		
		return Arrays.asList(empresas); // Transforma o vetor em lista
	}
	
	public void cadastrar(Empresa empresa) throws ResponseException{
		WebResource resource = cliente.resource(URL);
		
		ClientResponse response = resource.type(MediaType.APPLICATION_JSON).post(ClientResponse.class, empresa);
		
		if(response.getStatus() != 201) {
			throw new ResponseException();
		}
		
		
	}
	
	public void atualizar(Empresa empresa, int codigo) throws ResponseException{
		WebResource resource = cliente.resource(URL).path(Integer.toString(codigo));
		
		ClientResponse response = resource.type(MediaType.APPLICATION_JSON).put(ClientResponse.class, empresa);
		
		if(response.getStatus() != 200) {
			throw new ResponseException();
		}
		
	}
	
	public void remover(int codigo) throws ResponseException{
		WebResource resource = cliente.resource(URL).path(Integer.toString(codigo));
		
		ClientResponse response = resource.type(MediaType.APPLICATION_JSON).delete(ClientResponse.class);
		
//		if(response.getStatus() != 204) {
//			throw new ResponseException();
//		}
		
	}
	
	
	
}
