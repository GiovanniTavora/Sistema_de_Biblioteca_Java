package av3POO;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class TelaAlunos extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtMatriculaAluno;
	private JTextField txtNomeAluno;
	private Aluno aluno;
	private String matriculaAluno;
	private JTextField txtDtNascimento;
	private JTextField txtCPF;
	private JTextField txtCurso;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaConsulta frame = new TelaConsulta();
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
	public TelaAlunos() {
		setTitle("CADASTRO DE ALUNOS");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 622, 379);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Cadastro de Alunos");
		lblNewLabel.setBounds(205, 10, 136, 13);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Matricula");
		lblNewLabel_1.setBounds(108, 45, 71, 13);
		contentPane.add(lblNewLabel_1);
		
		txtMatriculaAluno = new JTextField();
		txtMatriculaAluno.setBounds(108, 62, 96, 19);
		contentPane.add(txtMatriculaAluno);
		txtMatriculaAluno.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Nome");
		lblNewLabel_2.setBounds(136, 109, 34, 13);
		contentPane.add(lblNewLabel_2);
		
		txtNomeAluno = new JTextField();
		txtNomeAluno.setEditable(false);
		txtNomeAluno.setColumns(10);
		txtNomeAluno.setBounds(76, 128, 150, 19);
		contentPane.add(txtNomeAluno);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					matriculaAluno = txtMatriculaAluno.getText();
					aluno = Dados.get().getListaAlunos().buscarAluno(matriculaAluno);
					txtNomeAluno.setText(aluno.getNome());
					txtCPF.setText(aluno.getCpf());
					txtDtNascimento.setText(aluno.getDtNascimento());
					txtCurso.setText(aluno.getCurso());
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Matrícula não cadastrada no sistema, tente novamente.", "Erro", JOptionPane.ERROR_MESSAGE);
					}
				
				}
		});
		btnBuscar.setBounds(295, 61, 85, 21);
		contentPane.add(btnBuscar);
		
		JLabel lblNewLabel_4 = new JLabel("Data de Nascimento");
		lblNewLabel_4.setBounds(287, 109, 145, 13);
		contentPane.add(lblNewLabel_4);
		
		txtDtNascimento = new JTextField();
		txtDtNascimento.setEditable(false);
		txtDtNascimento.setColumns(10);
		txtDtNascimento.setBounds(269, 128, 150, 19);
		contentPane.add(txtDtNascimento);
		
		JLabel lblNewLabel_4_1 = new JLabel("CPF");
		lblNewLabel_4_1.setBounds(132, 167, 47, 13);
		contentPane.add(lblNewLabel_4_1);
		
		txtCPF = new JTextField();
		txtCPF.setEditable(false);
		txtCPF.setColumns(10);
		txtCPF.setBounds(76, 188, 150, 19);
		contentPane.add(txtCPF);
		
		JLabel lblNewLabel_4_1_1 = new JLabel("Curso");
		lblNewLabel_4_1_1.setBounds(329, 167, 39, 13);
		contentPane.add(lblNewLabel_4_1_1);
		
		txtCurso = new JTextField();
		txtCurso.setEditable(false);
		txtCurso.setColumns(10);
		txtCurso.setBounds(269, 188, 150, 19);
		contentPane.add(txtCurso);
		
		JButton btnExportarAlunos = new JButton("Exportar dados dos Alunos");
		btnExportarAlunos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Dados.get().getListaAlunos().exportarArquivo();
				JOptionPane.showMessageDialog(null, "Dados exportados com sucesso!");
			}
		});
		btnExportarAlunos.setBounds(154, 236, 200, 21);
		contentPane.add(btnExportarAlunos);
	}
}
