package av3POO;

import java.util.ArrayList;

public class Emprestimo {
	private String matricula;
	private int idLivro;
	private String dtEmprestimo;
	private String dtDevolucao;
	
	public Emprestimo(String matricula, int idLivro, String dtEmprestimo, String dtDevolucao) {
		this.matricula = matricula;
 		this.idLivro = idLivro;
		this.dtEmprestimo = dtEmprestimo;
		this.dtDevolucao = dtDevolucao;
	}
	
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public int getIdLivro() {
		return idLivro;
	}
	public void setIdLivro(int idLivro) {
		this.idLivro = idLivro;
	}
	public String getDtEmprestimo() {
		return dtEmprestimo;
	}
	public void setDtEmprestimo(String dtEmprestimo) {
		this.dtEmprestimo = dtEmprestimo;
	}
	public String getDtDevolucao() {
		return dtDevolucao;
	}
	public void setDtDevolucao(String dtDevolucao) {
		this.dtDevolucao = dtDevolucao;
	}
	
}
