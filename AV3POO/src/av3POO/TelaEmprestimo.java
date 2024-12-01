package av3POO;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaEmprestimo extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtIdLivro;
	private JTextField txtTitulo;
	private JTextField txtAutor;
	private JTextField txtIsbn;
	private Livro livro;
	private Aluno aluno;
	private Funcionario funcionario;
	private Emprestimo emprestimo;
	private int idLivro;
	private String matriculaAluno;
	private String matriculaFunc;
	private String matricula;
	private String nomeAluno;
	private String nomeFunc;
	private String dtEmprestimo;
	private String dtDevolucao;
	private boolean livroOk = false;
	private boolean matriculaOk = false;
	private JTextField txtMatriculaPessoa;
	private JTextField txtNomePessoa;
	private JTextField txtCpfPessoa;
	private JTextField txtDtEmprestimo;
	private JTextField txtDtDevolucao;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaEmprestimo frame = new TelaEmprestimo();
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
	public TelaEmprestimo() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 680, 479);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("REALIZAR EMPRÉSTIMOS");
		lblNewLabel.setBounds(254, 10, 150, 13);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("ID Livro");
		lblNewLabel_1.setBounds(210, 49, 45, 13);
		contentPane.add(lblNewLabel_1);
		
		txtIdLivro = new JTextField();
		txtIdLivro.setColumns(10);
		txtIdLivro.setBounds(184, 72, 96, 19);
		contentPane.add(txtIdLivro);
		
		JLabel lblNewLabel_2 = new JLabel("Titulo");
		lblNewLabel_2.setBounds(140, 121, 35, 13);
		contentPane.add(lblNewLabel_2);
		
		txtTitulo = new JTextField();
		txtTitulo.setEditable(false);
		txtTitulo.setColumns(10);
		txtTitulo.setBounds(87, 144, 150, 19);
		contentPane.add(txtTitulo);
		
		JLabel lblNewLabel_3 = new JLabel("Autor");
		lblNewLabel_3.setBounds(312, 121, 35, 13);
		contentPane.add(lblNewLabel_3);
		
		txtAutor = new JTextField();
		txtAutor.setEditable(false);
		txtAutor.setColumns(10);
		txtAutor.setBounds(254, 144, 155, 19);
		contentPane.add(txtAutor);
		
		JLabel lblNewLabel_6_1 = new JLabel("ISBN");
		lblNewLabel_6_1.setBounds(475, 121, 35, 13);
		contentPane.add(lblNewLabel_6_1);
		
		txtIsbn = new JTextField();
		txtIsbn.setEditable(false);
		txtIsbn.setColumns(10);
		txtIsbn.setBounds(428, 144, 150, 19);
		contentPane.add(txtIsbn);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					idLivro = Integer.parseInt(txtIdLivro.getText());
					livro = Dados.get().getListaLivros().buscarPorID(idLivro);
					txtTitulo.setText(livro.getTitulo());
					txtAutor.setText(livro.getAutor());
					txtIsbn.setText(livro.getISBN());
					
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "ID não cadastrado, tente novamente.", "Erro", JOptionPane.ERROR_MESSAGE);
				}
				if(Dados.get().getLivrosEmprestados().contains(idLivro)) {
					JOptionPane.showMessageDialog(null, "Livro não disponível", "Erro", JOptionPane.ERROR_MESSAGE);
				} else {
					livroOk = true;
				}
			}
		});
		btnBuscar.setBounds(324, 71, 85, 21);
		contentPane.add(btnBuscar);
		
		JLabel lblNewLabel_4 = new JLabel("Matricula");
		lblNewLabel_4.setBounds(184, 197, 54, 13);
		contentPane.add(lblNewLabel_4);
		
		txtMatriculaPessoa = new JTextField();
		txtMatriculaPessoa.setColumns(10);
		txtMatriculaPessoa.setBounds(167, 220, 96, 19);
		contentPane.add(txtMatriculaPessoa);
		
		JButton btnBuscarPessoa = new JButton("Buscar");
		btnBuscarPessoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

					try {
						matriculaAluno = txtMatriculaPessoa.getText();
						aluno = Dados.get().getListaAlunos().buscarAluno(matriculaAluno);
						
						if(aluno == null) {
							matriculaFunc = txtMatriculaPessoa.getText();
							funcionario = Dados.get().getListaFuncionarios().buscarFuncionario(matriculaFunc);
							txtNomePessoa.setText(funcionario.getNome());
							txtCpfPessoa.setText(funcionario.getCpf());
						} else {
							txtNomePessoa.setText(aluno.getNome());
							txtCpfPessoa.setText(aluno.getCpf());
							matriculaOk = true;
						}
						
					} catch (Exception e1) {
						JOptionPane.showMessageDialog(null, "Matrícula não cadastrada no sistema, tente novamente.", "Erro", JOptionPane.ERROR_MESSAGE);
					}
			}
		});
		btnBuscarPessoa.setBounds(307, 219, 85, 21);
		contentPane.add(btnBuscarPessoa);
		
		JLabel lblNewLabel_2_1 = new JLabel("Nome");
		lblNewLabel_2_1.setBounds(193, 264, 35, 13);
		contentPane.add(lblNewLabel_2_1);
		
		txtNomePessoa = new JTextField();
		txtNomePessoa.setEditable(false);
		txtNomePessoa.setColumns(10);
		txtNomePessoa.setBounds(140, 287, 150, 19);
		contentPane.add(txtNomePessoa);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("CPF");
		lblNewLabel_2_1_1.setBounds(365, 264, 35, 13);
		contentPane.add(lblNewLabel_2_1_1);
		
		txtCpfPessoa = new JTextField();
		txtCpfPessoa.setEditable(false);
		txtCpfPessoa.setColumns(10);
		txtCpfPessoa.setBounds(312, 287, 150, 19);
		contentPane.add(txtCpfPessoa);
		
		JLabel lblNewLabel_4_1 = new JLabel("Data de Empréstimo");
		lblNewLabel_4_1.setBounds(167, 328, 116, 13);
		contentPane.add(lblNewLabel_4_1);
		
		JLabel lblNewLabel_4_2 = new JLabel("Data de Devolução");
		lblNewLabel_4_2.setBounds(312, 328, 116, 13);
		contentPane.add(lblNewLabel_4_2);
		
		txtDtEmprestimo = new JTextField();
		txtDtEmprestimo.setColumns(10);
		txtDtEmprestimo.setBounds(186, 351, 96, 19);
		contentPane.add(txtDtEmprestimo);
		
		txtDtDevolucao = new JTextField();
		txtDtDevolucao.setColumns(10);
		txtDtDevolucao.setBounds(312, 351, 96, 19);
		contentPane.add(txtDtDevolucao);
		
		JButton btnNewButton = new JButton("Realizar Empréstimo");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(livroOk == false && matriculaOk == false) {
					JOptionPane.showMessageDialog(null, "Livro não disponível ou usuário inválido.", "Erro", JOptionPane.ERROR_MESSAGE);
					
				} else {
					idLivro = Integer.parseInt(txtIdLivro.getText());
					matricula = txtMatriculaPessoa.getText();		
					dtEmprestimo = txtDtEmprestimo.getText();
					dtDevolucao = txtDtDevolucao.getText();
					emprestimo = new Emprestimo(matricula, idLivro, dtEmprestimo, dtDevolucao);
					Dados.get().getListaEmprestimo().adicionarEmprestimo(emprestimo);
					//Dados.get().getListaEmprestimo().imprimir();
					JOptionPane.showMessageDialog(null, "Empréstimo realizado com sucesso!");
					
					txtMatriculaPessoa.setText("");
					txtIdLivro.setText("");
					txtDtEmprestimo.setText("");
					txtDtDevolucao.setText("");
				}
			}
		});
		btnNewButton.setBounds(210, 391, 169, 21);
		contentPane.add(btnNewButton);
	}
}
