package br.com.fiap.bean;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import br.com.fiap.exception.ResponseException;
import br.com.fiap.repository.EmpresaRepository;
import br.com.fiap.to.Empresa;

@ManagedBean
public class EmpresaBean {
	private Empresa empresa;
	private EmpresaRepository repository;

	@PostConstruct //metodo chamado automaticamente 
	public void iniciar() {
		repository = new EmpresaRepository();
		empresa = new Empresa();
	}

	public List<Empresa> listar(){
		try {
			return repository.listar();
		} catch (ResponseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public void cadastrar() {
		FacesMessage msg;
		try {
			repository.cadastrar(getEmpresa());
			msg = new FacesMessage("Cadastrado!");
			System.out.println("Cadastrou! " + getEmpresa().getNome());
		} catch (ResponseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			msg = new FacesMessage("Erro!");
		}

		FacesContext.getCurrentInstance().addMessage(null, msg);

	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}	
}
