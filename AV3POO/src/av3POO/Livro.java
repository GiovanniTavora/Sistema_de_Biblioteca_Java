package av3POO;

import java.util.ArrayList;

public class Livro implements Acervo{
	private String titulo;
	private int numPag;
	private double preco; 
	private String autor; 
	private String genero; 
	private String editora;
	private String anoDeEdicao;
	private String isbn;
	private int idLivro;
	
	public Livro(String titulo, int numPag, double preco, String autor, String genero, String editora,
			String anoDeEdicao, String isbn, int idLivro) {
		this.titulo = titulo;
		this.numPag = numPag;
		this.preco = preco;
		this.autor = autor;
		this.genero = genero;
		this.editora = editora;
		this.anoDeEdicao = anoDeEdicao;
		this.isbn = isbn;
		this.idLivro = idLivro;
	}
	
	public Livro() {
		
	}
	
	public String getTitulo() {
		return titulo;
	}
	
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	public int getNumPag() {
		return numPag;
	}
	
	public void setNumPag(int numPag) {
		this.numPag = numPag;
	}
	
	public double getPreco() {
		return preco;
	}
	
	public void setPreco(double preco) {
		this.preco = preco;
	}
	
	public String getAutor() {
		return autor;
	}
	
	public String getGenero() {
		return genero;
	}
	
	public void setGenero(String genero) {
		this.genero = genero;
	}
	
	public String getEditora() {
		return editora;
	}
	
	public void setEditora(String editora) {
		this.editora = editora;
	}
	
	public String getAnoDeEdicao() {
		return anoDeEdicao;
	}
	
	public void setAnoDeEdicao(String anoDeEdicao) {
		this.anoDeEdicao = anoDeEdicao;
	}
	
	public String getISBN() {
		return isbn;
	}
	
	public void setISBN(String iSBN) {
		isbn = iSBN;
	}

	public int getIdLivro() {
		return idLivro;
	}

	public void setIdLivro(int idLivro) {
		this.idLivro = idLivro;
	}

	
}
