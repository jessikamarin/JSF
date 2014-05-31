package br.dextra.managedbeans;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;

import br.dextra.modelo.Estado;

@ManagedBean
@SessionScoped
public class FuncionarioBean {

	private double salario;
	private int codigo;
	private Date data;          
	private String nome;
	private String cidade;
	private String siglaDoEstadoEscolhido;
	private Estado estadoSelecionado = new Estado();
	private List<Estado> estados = new ArrayList<Estado>();

	public FuncionarioBean() {
		Estado sp = new Estado();
		sp.setSigla("SP");
		sp.setNome("São Paulo");
		sp.getCidades().add("São Paulo");
		sp.getCidades().add("Campinas");
	}

	public void mudaEstado(ValueChangeEvent event) {
		this.siglaDoEstadoEscolhido = event.getNewValue().toString();
		for (Estado e : this.estados) {
			if (e.getSigla().equals(this.siglaDoEstadoEscolhido)) {
				this.estadoSelecionado = e;
				break;
			}
		}
		FacesContext.getCurrentInstance().renderResponse();
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;

	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getSiglaDoEstadoEscolhido() {
		return siglaDoEstadoEscolhido;
	}

	public void setSiglaDoEstadoEscolhido(String siglaDoEstadoEscolhido) {
		this.siglaDoEstadoEscolhido = siglaDoEstadoEscolhido;
	}

	public Estado getEstadoSelecionado() {
		return estadoSelecionado;
	}

	public void setEstadoSelecionado(Estado estadoSelecionado) {
		this.estadoSelecionado = estadoSelecionado;
	}

	public List<Estado> getEstados() {
		return estados;
	}

	public void setEstados(List<Estado> estados) {
		this.estados = estados;
	}

}