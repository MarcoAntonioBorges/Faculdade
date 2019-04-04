package br.com.fiap.resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

import br.com.fiap.dao.PedidoDAO;
import br.com.fiap.dao.impl.PedidoDAOImpl;
import br.com.fiap.entity.Pedido;
import br.com.fiap.exception.CodigoInvalidoException;
import br.com.fiap.singleton.EntityManagerFactorySingleton;

@Path("/pedido")
public class PedidoResource {

	public PedidoDAO dao;
	
	public PedidoResource() {
		dao = new PedidoDAOImpl(EntityManagerFactorySingleton.getInstance().createEntityManager());
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response cadastrar(Pedido pedido, @Context UriInfo url) {
		try {
			dao.cadastrar(pedido);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return Response.serverError().build();
		}
		UriBuilder builder =  url.getAbsolutePathBuilder();
		builder.path(String.valueOf(pedido.getCodigo()));
		
		//HTTP Status Code : 201 Created 
		return Response.created(builder.build()).build();
	}
	
	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Pedido busca(@PathParam("id") int codigo) {
		try {
			return dao.buscar(codigo);
		} catch (CodigoInvalidoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Pedido> listar(){
		return dao.listar();
	}
	
	@PUT
	@Path("{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response atualizar(@PathParam("id") int codigo, Pedido pedido) {
		
		try {
			pedido.setCodigo(codigo);
			dao.alterar(pedido);
			dao.commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return Response.serverError().build();
		}
		
		return Response.ok().build();
		
	}
	
	@DELETE
	@Path("{id}")
	public Response deletar(@PathParam("id") int codigo) {
		try {
			dao.remover(codigo);
			dao.commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return Response.serverError().build();
		}
		
		return Response.ok().build();
	}
}
