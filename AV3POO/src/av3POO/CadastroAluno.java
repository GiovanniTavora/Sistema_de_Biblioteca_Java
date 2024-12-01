package av3POO;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class CadastroAluno {
	private ArrayList<Aluno> listaAlunos;
	
	public CadastroAluno() {
		this.listaAlunos = new ArrayList<>();
	}
	
	public void adicionarAluno(Aluno aluno) {
		listaAlunos.add(aluno);
	}
	
	public Aluno buscarAluno(String matriculaAluno) {
		for(Aluno aluno: listaAlunos) {
			if(aluno.getMatriculaAluno().compareTo(matriculaAluno) == 0) {
				return aluno;
			}
		}
		return null;
	}
	
	public void imprimir() {
		for(Aluno aluno: listaAlunos) {
			System.out.println("Nome: " + aluno.getNome() + ", Data de Nascimento: " + aluno.getDtNascimento() + ", CPF: " + aluno.getCpf() + ", Matricula: " + aluno.getMatriculaAluno() + ", Curso: " + aluno.getCurso());
		}
	}
	
	public void exportarArquivo() {
		String csvFile = "C:\\Users\\User\\Downloads\\dadosAlunos.csv";
        
        FileWriter writer = null;

        try {
            writer = new FileWriter(csvFile);

            writer.append("Nome, Matricula, Curso\n");
            
            for(Aluno aluno: listaAlunos) {
    			writer.append(aluno.getNome() + ", " + aluno.getMatriculaAluno() + ", " + aluno.getCurso() + "\n");
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
		listaAlunos.clear();
        String txtFile = "C:\\Users\\User\\Downloads\\alunos.txt";

        String linha;

        try (BufferedReader br = new BufferedReader(new FileReader(txtFile))) {
            while ((linha = br.readLine()) != null) {
            	String[] dados = linha.split(", ");
            	
            	String nome = dados[0];
            	String dtNascimento = dados[1];
            	String cpf = dados[2];
            	String matriculaAluno = dados[3];
            	String curso = dados[4];
            	            	
            	Aluno aluno = new Aluno(nome, dtNascimento, cpf, matriculaAluno, curso);
            	listaAlunos.add(aluno);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
}
