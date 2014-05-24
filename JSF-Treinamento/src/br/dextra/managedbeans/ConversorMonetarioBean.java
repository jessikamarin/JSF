package br.dextra.managedbeans;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class ConversorMonetarioBean {

	private Map<String, Double> moedas = new LinkedHashMap<String, Double>();

	private String de;
	private String para;
	private double valor;
	private double resultado;

	public ConversorMonetarioBean() {
		this.moedas.put("Real", 1.0);
		this.moedas.put("Euro", 2.33);
		this.moedas.put("Peso Argentino", 0.42);
		this.moedas.put("Dolar", 2.22);
	}

	public void converte() {
		this.resultado = this.valor * this.moedas.get(this.de)
				/ this.moedas.get(this.para);
	}

	public String getDe() {
		return de;
	}

	public void setDe(String de) {
		this.de = de;
	}

	public String getPara() {
		return para;
	}

	public void setPara(String para) {
		this.para = para;
	}

	public double getResultado() {
		return resultado;
	}

	public void setResultado(double resultado) {
		this.resultado = resultado;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public Map<String, Double> getMoedas() {
		return moedas;
	}

	public void setMoedas(Map<String, Double> moedas) {
		this.moedas = moedas;
	}

}
