package av3POO;

import java.util.ArrayList;

public class CadastroEmprestimo {
	private ArrayList<Emprestimo> listaEmprestimos;
	
	public CadastroEmprestimo(){
		this.listaEmprestimos = new ArrayList<>();
	}
	
	public void adicionarEmprestimo(Emprestimo emprestimo) {
		listaEmprestimos.add(emprestimo);
		Dados.get().getLivrosEmprestados().add(emprestimo.getIdLivro());
	}
	
	public Emprestimo buscarPorId(int idLivro) {
		for(Emprestimo emprestimo: listaEmprestimos) {
			if(idLivro == emprestimo.getIdLivro()) {
				return emprestimo;
			}
		}
		return null;
	}
	
	public void imprimir() {
		for(Emprestimo emprestimo: listaEmprestimos) {
			System.out.println("Matricula: " + emprestimo.getMatricula() + ", ID do Livro: " + emprestimo.getIdLivro() + ", Data de emprestimo: " + emprestimo.getDtEmprestimo() + ", Data de devolução: " + emprestimo.getDtDevolucao());
		}
	}
	
}
