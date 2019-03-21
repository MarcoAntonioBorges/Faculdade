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

import br.com.fiap.dao.EmpresaDAO;
import br.com.fiap.dao.impl.EmpresaDAOImpl;
import br.com.fiap.entity.Empresa;
import br.com.fiap.exception.CodigoInvalidoException;
import br.com.fiap.exception.CommitException;
import br.com.fiap.singleton.EntityManagerFactorySingleton;

@Path("/empresa")
public class EmpresaResource {

	public EmpresaDAO dao;
	
	public EmpresaResource() {
		dao = new EmpresaDAOImpl(EntityManagerFactorySingleton.getInstance().createEntityManager());
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response cadastrar(Empresa empresa, @Context UriInfo url) {
		try {
			dao.cadastrar(empresa);
			dao.commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return Response.serverError().build();
		}
		
		//Criar a url para acessar a empresa cadastrada
		UriBuilder builder =  url.getAbsolutePathBuilder();
		builder.path(String.valueOf(empresa.getCodigo()));
		
		//HTTP Status Code : 201 Created 
		return Response.created(builder.build()).build();
	}
	
	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Empresa busca(@PathParam("id") int codigo) {
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
	public List<Empresa> buscar() {
		return dao.listar();
	}
	
	
	@PUT
	@Path("{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response atualizar(@PathParam("id") int codigo, Empresa em) {
		try {
			em.setCodigo(codigo);
			dao.alterar(em);
			dao.commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return Response.serverError().build(); //500
		}
		
		return Response.ok().build(); //200
		
	}
	
	
	@DELETE
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response deletar(@PathParam("id") int codigo) {
		
		try {
			dao.remover(codigo);
			dao.commit();
		} catch (CommitException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return Response.serverError().build(); //500
		} catch (CodigoInvalidoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return Response.serverError().build(); //500
		}
	
		
		return Response.ok().build();
	}
	
}
