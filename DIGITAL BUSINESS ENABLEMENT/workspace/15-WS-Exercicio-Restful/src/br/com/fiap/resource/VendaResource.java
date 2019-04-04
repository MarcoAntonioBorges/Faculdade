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

import br.com.fiap.ws.dao.VendaDAO;
import br.com.fiap.ws.dao.impl.VendaDAOImpl;
import br.com.fiap.ws.entity.Venda;
import br.com.fiap.ws.singleton.EntityManagerFactorySingleton;

@Path("/venda")
public class VendaResource {

	public VendaDAO dao;
	
	public VendaResource() {
		dao = new VendaDAOImpl(EntityManagerFactorySingleton.getInstance().createEntityManager());
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response cadastrar(Venda venda, @Context UriInfo url) {
		try {
			dao.cadastrar(venda);
			dao.commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return Response.serverError().build();
		}
		UriBuilder builder = url.getAbsolutePathBuilder();
		builder.path(String.valueOf(venda.getId()));
		
		return Response.created(builder.build()).build();
	}
	
	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Venda busca(@PathParam("id") int codigo) {
		try {
			return dao.buscar(codigo);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Venda> listar(){
		return dao.listar();
	}
	
	@PUT
	@Path("{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response atualizar(@PathParam("id") int codigo, Venda venda) {
		
		try {
			venda.setId(codigo);
			dao.atualizar(venda);
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
