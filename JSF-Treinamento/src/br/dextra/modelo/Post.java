package br.dextra.modelo;

public class Post {

	private String titulo;
	private String autor;
	private String conteudo;
	private String dataCriacao;
	private URLBookmark bookmarkURL;

	public URLBookmark getBookmarkURL() {
		return bookmarkURL;
	}

	public void setBookmarkURL(URLBookmark bookmarkURL) {
		this.bookmarkURL = bookmarkURL;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getConteudo() {
		return conteudo;
	}

	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}

	public String getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(String dataCriacao) {
		this.dataCriacao = dataCriacao;
	}
}
