package av3POO;

import java.util.ArrayList;

public class Aluno extends Pessoa {
	private String matriculaAluno;
	private String curso;
		
	public Aluno(String nome, String dtNascimento, String cpf, String matriculaAluno, String curso) {
		super(nome, dtNascimento, cpf);
		this.matriculaAluno = matriculaAluno;
		this.curso = curso;
	}
	
	public Aluno() {
		
	}
	
	public String getMatriculaAluno() {
		return matriculaAluno;
	}

	public void setMatriculaAluno(String matriculaAluno) {
		this.matriculaAluno = matriculaAluno;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}
	
}
