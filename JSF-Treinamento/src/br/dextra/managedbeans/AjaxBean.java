package br.dextra.managedbeans;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class AjaxBean {
	private String nome;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
