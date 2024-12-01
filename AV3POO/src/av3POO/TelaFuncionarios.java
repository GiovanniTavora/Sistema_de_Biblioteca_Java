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

public class TelaFuncionarios extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtMatriculaFunc;
	private JTextField txtNomeFunc;
	private Funcionario funcionario;
	private String matriculaFunc;
	private JTextField txtDtNascimento;
	private JTextField txtCPF;
	private JTextField txtCargo;
	private JTextField txtSetor;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaFuncionarios frame = new TelaFuncionarios();
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
	public TelaFuncionarios() {
		setTitle("CADASTRO DE ALUNOS");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 622, 379);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Cadastro de Funcionários");
		lblNewLabel.setBounds(200, 10, 170, 13);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Matricula");
		lblNewLabel_1.setBounds(108, 45, 71, 13);
		contentPane.add(lblNewLabel_1);
		
		txtMatriculaFunc = new JTextField();
		txtMatriculaFunc.setBounds(108, 62, 96, 19);
		contentPane.add(txtMatriculaFunc);
		txtMatriculaFunc.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Nome");
		lblNewLabel_2.setBounds(132, 109, 34, 13);
		contentPane.add(lblNewLabel_2);
		
		txtNomeFunc = new JTextField();
		txtNomeFunc.setEditable(false);
		txtNomeFunc.setColumns(10);
		txtNomeFunc.setBounds(76, 128, 150, 19);
		contentPane.add(txtNomeFunc);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					matriculaFunc = txtMatriculaFunc.getText();
					funcionario = Dados.get().getListaFuncionarios().buscarFuncionario(matriculaFunc);
					txtNomeFunc.setText(funcionario.getNome());
					txtCPF.setText(funcionario.getCpf());
					txtDtNascimento.setText(funcionario.getDtNascimento());
					txtCargo.setText(funcionario.getCargo());
					txtSetor.setText(funcionario.getSetor());
					
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
		
		JLabel lblNewLabel_4_1_1 = new JLabel("Cargo");
		lblNewLabel_4_1_1.setBounds(329, 167, 39, 13);
		contentPane.add(lblNewLabel_4_1_1);
		
		txtCargo = new JTextField();
		txtCargo.setEditable(false);
		txtCargo.setColumns(10);
		txtCargo.setBounds(269, 188, 150, 19);
		contentPane.add(txtCargo);
		
		JLabel lblNewLabel_4_1_1_1 = new JLabel("Setor");
		lblNewLabel_4_1_1_1.setBounds(228, 216, 39, 13);
		contentPane.add(lblNewLabel_4_1_1_1);
		
		txtSetor = new JTextField();
		txtSetor.setEditable(false);
		txtSetor.setColumns(10);
		txtSetor.setBounds(171, 239, 150, 19);
		contentPane.add(txtSetor);
		
		JButton btnExportarFunc = new JButton("Exportar dados dos Funcionários");
		btnExportarFunc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Dados.get().getListaFuncionarios().exportarArquivo();
				JOptionPane.showMessageDialog(null, "Dados exportados com sucesso!");
			}
		});
		btnExportarFunc.setBounds(142, 268, 228, 21);
		contentPane.add(btnExportarFunc);
	}
}
