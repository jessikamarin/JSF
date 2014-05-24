package br.dextra.managedbeans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

@ManagedBean
public class UsuarioBean {

	@ManagedProperty(value = "Jéssica")
	private String nome;
	private String idade;

	public String mostraUsuario() {
		return"/usuario";

	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getIdade() {
		return idade;
	}

	public void setIdade(String idade) {
		this.idade = idade;
	}

}