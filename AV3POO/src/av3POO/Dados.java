package av3POO;

import java.util.HashSet;

public class Dados {
	private static Dados instance;
	private CadastroAluno listaAlunos = new CadastroAluno();
	private CadastroLivro listaLivros = new CadastroLivro();
	private CadastroEmprestimo listaEmprestimo = new CadastroEmprestimo();
	private CadastroFuncionario listaFuncionarios = new CadastroFuncionario();
	private HashSet<Integer> livrosEmprestados = new HashSet<>();
	
	private Dados() {
		
	}
	
	public static Dados get() {
		if(instance == null) {
			instance = new Dados();
		}
		return instance;
	}

	public CadastroAluno getListaAlunos() {
		return listaAlunos;
	}

	public CadastroLivro getListaLivros() {
		return listaLivros;
	}

	public CadastroEmprestimo getListaEmprestimo() {
		return listaEmprestimo;
	}

	public CadastroFuncionario getListaFuncionarios() {
		return listaFuncionarios;
	}

	public static Dados getInstance() {
		return instance;
	}

	public HashSet<Integer> getLivrosEmprestados() {
		return livrosEmprestados;
	}
	
}
