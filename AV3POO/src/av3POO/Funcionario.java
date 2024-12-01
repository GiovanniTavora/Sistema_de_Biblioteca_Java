package av3POO;

import java.util.ArrayList;

public class Funcionario extends Pessoa {
	private String cargo;
	private String matriculaFunc;
	private String setor;
	
	public Funcionario(String nome, String dtNascimento, String cpf, String cargo, String matriculaFunc, String setor) {
		super(nome, dtNascimento, cpf);
		this.cargo = cargo;
		this.matriculaFunc = matriculaFunc;
		this.setor = setor;
	}
		
	public String getCargo() {
		return cargo;
	}
	
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	
	public String getMatriculaFunc() {
		return matriculaFunc;
	}
	
	public void setMatriculaFunc(String matriculaFunc) {
		this.matriculaFunc = matriculaFunc;
	}
	
	public String getSetor() {
		return setor;
	}
	
	public void setSetor(String setor) {
		this.setor = setor;
	}

}
