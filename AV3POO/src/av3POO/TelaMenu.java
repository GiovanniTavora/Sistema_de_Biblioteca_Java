package av3POO;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenu;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaMenu extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		Dados.get().getListaAlunos().importarArquivo();
		Dados.get().getListaLivros().importarArquivo();
		Dados.get().getListaFuncionarios().importarArquivo();
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaMenu frame = new TelaMenu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaMenu() {
		setTitle("SISTEMA DE BIBLIOTECA");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 640, 410);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Cadastro de Livros");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaConsulta telaConsulta = new TelaConsulta();
				telaConsulta.setVisible(true);
			}
		});
		btnNewButton.setBounds(201, 134, 187, 21);
		contentPane.add(btnNewButton);
		
		JButton btnCadastroDeAlunos = new JButton("Cadastro de Alunos");
		btnCadastroDeAlunos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaAlunos telaAlunos = new TelaAlunos();
				telaAlunos.setVisible(true);
			}
		});
		btnCadastroDeAlunos.setBounds(201, 164, 187, 21);
		contentPane.add(btnCadastroDeAlunos);
		
		JButton btnCadastroDeFuncionrios = new JButton("Cadastro de Funcionários");
		btnCadastroDeFuncionrios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaFuncionarios telaFuncionarios = new TelaFuncionarios();
				telaFuncionarios.setVisible(true);
			}
		});
		btnCadastroDeFuncionrios.setBounds(201, 195, 187, 21);
		contentPane.add(btnCadastroDeFuncionrios);
		
		JButton btnEmprestimo = new JButton("Realizar Empréstimo");
		btnEmprestimo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaEmprestimo telaEmprestimo = new TelaEmprestimo();
				telaEmprestimo.setVisible(true);
			}
		});
		btnEmprestimo.setBounds(201, 103, 187, 21);
		contentPane.add(btnEmprestimo);
		
		JButton btnDevolucao = new JButton("Devolução de Livros");
		btnDevolucao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaDevolucao telaDevolucao = new TelaDevolucao();
				telaDevolucao.setVisible(true);
			}
		});
		btnDevolucao.setBounds(201, 77, 187, 21);
		contentPane.add(btnDevolucao);
	}
}
