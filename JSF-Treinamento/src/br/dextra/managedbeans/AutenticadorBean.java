package br.dextra.managedbeans;

import java.util.HashMap;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.application.FacesMessage;
import javax.servlet.http.HttpSession;

@ManagedBean
public class AutenticadorBean {

	
	/*
	 * Por simplicidade, utilizaremos um atributo de um managed bean para armazenar os usuários
	 * da aplicação e suas respectivas senhas. A implementação que será apresentada a seguir pode ser
	 * alterada para que esses dados sejam armazenadas em um arquivo ou em um banco de dados.
	 */
	
	// Criando lista de usuarios autorizados
	private static Map<String,String> mapa =  new HashMap<String,String>();
	
	@ManagedProperty(value="jorooooge")
	private String usuario;
	private String senha;
	
	
	
	// Vamos acrescentar algums usuarios altorizados
	static {
		AutenticadorBean.mapa.put("dextra", "dextra");
		AutenticadorBean.mapa.put("jorge", "jorge");
		AutenticadorBean.mapa.put("aluno", "aluno");
	}
	
	
	// Criando metodo de autenticacao
	public String autentica() {
		FacesContext fc = FacesContext.getCurrentInstance();
		
		if (AutenticadorBean.mapa.containsKey(this.usuario) 
			&& AutenticadorBean.mapa.get(this.usuario).equals(this.senha)) {
			
			ExternalContext ec = fc.getExternalContext();
			HttpSession session = (HttpSession)ec.getSession(false);
			session.setAttribute("usuario",this.usuario);			
			return "/formulario";
		} else {
			FacesMessage fm = new FacesMessage("usuário e/ou senha inválidos");
			fm.setSeverity ( FacesMessage . SEVERITY_ERROR );
			fc.addMessage (null , fm);
			return "/login";
		}
		
	}
	
	// Criando metodo de logout
	public String registraSaida() {
		FacesContext fc = FacesContext.getCurrentInstance();
		ExternalContext ec = fc.getExternalContext();
		HttpSession session = (HttpSession) ec.getSession(false);
		session.removeAttribute("usuario");
		return "/login";
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}	
	
}