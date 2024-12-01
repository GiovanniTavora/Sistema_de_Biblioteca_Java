package av3POO;

abstract class Pessoa implements Usuario{
	private String nome; 
	private String dtNascimento;
	private String cpf;
	
	public Pessoa(String nome, String dtNascimento, String cpf) {
		this.nome = nome;
		this.dtNascimento = dtNascimento;
		this.cpf = cpf;
	}

	public Pessoa() {
		
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getDtNascimento() {
		return dtNascimento;
	}
	
	public void setDtNascimento(String dtNascimento) {
		this.dtNascimento = dtNascimento;
	}
	
	public String getCpf() {
		return cpf;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
}
