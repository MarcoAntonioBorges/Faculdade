package br.com.fiap.bean;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class LoginBean {
	private String usuario;
	private String senha;
	private String resultado;

	public void autenticar() {
		if(usuario != null && senha != null) {
			if(usuario.equalsIgnoreCase("FIAP") && senha.equalsIgnoreCase("FIAP2019")) {
				this.setResultado("AUTENTICADO");
			}else {
				this.setResultado("NÃO AUTORIZADO");
			}
		}
	}

	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getResultado() {
		return resultado;
	}

	public void setResultado(String resultado) {
		this.resultado = resultado;
	}


}
