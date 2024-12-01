package av3POO;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileWriter;
import java.util.ArrayList;

public class CadastroLivro {
	private ArrayList<Livro> listaLivros;
	
	public CadastroLivro() {
		this.listaLivros = new ArrayList<>();
	}
	
	public void adicionarLivro(Livro livro) {
		listaLivros.add(livro);	
	}
	
	public void imprimir() {
		for(Livro livro: listaLivros) {
			System.out.println("Titulo: " + livro.getTitulo() + ", ID: " + livro.getIdLivro());
		}	
	}
	
	public Livro buscarPorID(int idLivro) {
		for(Livro livro: listaLivros) {
			if(livro.getIdLivro() == idLivro) {
				return livro;
			}
		}
		return null;
	}
	
	public void exportarArquivo() {
		String csvFile = "C:\\Users\\User\\Downloads\\dadosLivros.csv";
        
        FileWriter writer = null;

        try {
            writer = new FileWriter(csvFile);

            writer.append("Título, ID, Gênero\n");
            
            for(Livro livro: listaLivros) {
    			writer.append(livro.getTitulo() + ", " + String.valueOf(livro.getIdLivro()) + ", " + livro.getGenero() + "\n");
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
		listaLivros.clear();
        String txtFile = "C:\\Users\\User\\Downloads\\livros.txt";

        String linha;

        try (BufferedReader br = new BufferedReader(new FileReader(txtFile))) {
            while ((linha = br.readLine()) != null) {
            	String[] dados = linha.split(", ");
            	
            	
            	String titulo = dados[0];
            	int numPag = Integer.parseInt(dados[1]);
            	double preco = Double.parseDouble(dados[2]);
            	String autor = dados[3];
            	String genero = dados[4]; 
            	String editora = dados[5]; 
            	String anoDeEdicao = dados[6]; 
            	String isbn = dados[7];
            	int idLivro = Integer.parseInt(dados[8]);
            	            	
            	Livro livro = new Livro(titulo, numPag, preco, autor, genero, editora, anoDeEdicao, isbn, idLivro);
            	listaLivros.add(livro);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
}

