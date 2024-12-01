package av3POO;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class CadastroFuncionario {
	private ArrayList<Funcionario> listaFuncionarios;
	
	public CadastroFuncionario() {
		this.listaFuncionarios = new ArrayList<>();
	}
	
	public void adicionarFunc(Funcionario funcionario) {
		listaFuncionarios.add(funcionario);
	}
	
	public Funcionario buscarFuncionario(String matriculaFunc) {
		for(Funcionario funcionario: listaFuncionarios) {
			if(funcionario.getMatriculaFunc().compareTo(matriculaFunc) == 0) {
				return funcionario;
			}
		}
		return null;
	}
	
	public void imprimir() {
		for(Funcionario funcionario: listaFuncionarios) {
			System.out.println("Nome: " + funcionario.getNome() + ", Matricula Funcionário: " + funcionario.getMatriculaFunc());
		}
	}
	
	public void exportarArquivo() {
		String csvFile = "C:\\Users\\User\\Downloads\\dadosFuncionarios.csv";
        
        FileWriter writer = null;

        try {
            writer = new FileWriter(csvFile);

            writer.append("Nome, Cargo, Matricula, Setor\n");
            
            for(Funcionario funcionario: listaFuncionarios) {
    			writer.append(funcionario.getNome() + ", " + funcionario.getCargo() + ", " + funcionario.getMatriculaFunc() + ", " + funcionario.getSetor() + "\n");
    		}
            
            System.out.println("Arquivo CSV criado com sucesso!");

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (writer != null) writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
	
	public void importarArquivo() {
		listaFuncionarios.clear();
		String txtFile = "C:\\Users\\User\\Downloads\\funcionarios.txt";

        String linha;

        try (BufferedReader br = new BufferedReader(new FileReader(txtFile))) {
            while ((linha = br.readLine()) != null) {
            	String[] dados = linha.split(", ");
            	
            	String nome = dados[0];
            	String dtNascimento = dados[1];
            	String cpf = dados[2];
            	String cargo = dados[3];
            	String matriculaFunc = dados[4];
            	String setor = dados[5];
            	
            	Funcionario funcionario = new Funcionario(nome, dtNascimento, cpf, cargo, matriculaFunc, setor);
            	listaFuncionarios.add(funcionario);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
}
