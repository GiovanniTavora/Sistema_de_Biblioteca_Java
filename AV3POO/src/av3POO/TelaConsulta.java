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

public class TelaConsulta extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtIdLivro;
	private JTextField txtTitulo;
	private JTextField txtAutor;
	private Livro livro;
	private int idLivro;
	private JTextField txtNumPag;
	private JTextField txtPreco;
	private JTextField txtGenero;
	private JTextField txtEditora;
	private JTextField txtAnoDeEdicao;
	private JTextField txtIsbn;
	
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
	public TelaConsulta() {
		setTitle("CADASTRO DE LIVROS");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 622, 379);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Consulta de Livros");
		lblNewLabel.setBounds(205, 10, 136, 13);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("ID Livro");
		lblNewLabel_1.setBounds(318, 50, 45, 13);
		contentPane.add(lblNewLabel_1);
		
		txtIdLivro = new JTextField();
		txtIdLivro.setBounds(292, 73, 96, 19);
		contentPane.add(txtIdLivro);
		txtIdLivro.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Titulo");
		lblNewLabel_2.setBounds(508, 50, 34, 13);
		contentPane.add(lblNewLabel_2);
		
		txtTitulo = new JTextField();
		txtTitulo.setEditable(false);
		txtTitulo.setColumns(10);
		txtTitulo.setBounds(448, 73, 150, 19);
		contentPane.add(txtTitulo);
		
		JLabel lblNewLabel_3 = new JLabel("Autor");
		lblNewLabel_3.setBounds(318, 109, 45, 13);
		contentPane.add(lblNewLabel_3);
		
		txtAutor = new JTextField();
		txtAutor.setEditable(false);
		txtAutor.setBounds(265, 130, 155, 19);
		contentPane.add(txtAutor);
		txtAutor.setColumns(10);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					idLivro = Integer.parseInt(txtIdLivro.getText());
					livro = Dados.get().getListaLivros().buscarPorID(idLivro);
					txtTitulo.setText(livro.getTitulo());
					
					txtAutor.setText(livro.getAutor());
					txtPreco.setText(Double.toString(livro.getPreco()));
					txtNumPag.setText(Integer.toString(livro.getNumPag()));
					txtGenero.setText(livro.getGenero());
					txtEditora.setText(livro.getEditora());
					txtAnoDeEdicao.setText(livro.getAnoDeEdicao());
					txtIsbn.setText(livro.getISBN());
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "ID não cadastrado, tente novamente.", "Erro", JOptionPane.ERROR_MESSAGE);
					}
				
				}
		});
		btnBuscar.setBounds(97, 129, 85, 21);
		contentPane.add(btnBuscar);
		
		JLabel lblNewLabel_4 = new JLabel("Numero de Páginas");
		lblNewLabel_4.setBounds(458, 109, 140, 13);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Preço");
		lblNewLabel_5.setBounds(318, 169, 45, 13);
		contentPane.add(lblNewLabel_5);
		
		txtNumPag = new JTextField();
		txtNumPag.setEditable(false);
		txtNumPag.setColumns(10);
		txtNumPag.setBounds(448, 130, 150, 19);
		contentPane.add(txtNumPag);
		
		txtPreco = new JTextField();
		txtPreco.setEditable(false);
		txtPreco.setColumns(10);
		txtPreco.setBounds(267, 189, 150, 19);
		contentPane.add(txtPreco);
		
		JLabel lblNewLabel_4_1 = new JLabel("Gênero");
		lblNewLabel_4_1.setBounds(495, 169, 47, 13);
		contentPane.add(lblNewLabel_4_1);
		
		txtGenero = new JTextField();
		txtGenero.setEditable(false);
		txtGenero.setColumns(10);
		txtGenero.setBounds(448, 189, 150, 19);
		contentPane.add(txtGenero);
		
		JLabel lblNewLabel_6 = new JLabel("Editora");
		lblNewLabel_6.setBounds(314, 222, 45, 13);
		contentPane.add(lblNewLabel_6);
		
		txtEditora = new JTextField();
		txtEditora.setEditable(false);
		txtEditora.setColumns(10);
		txtEditora.setBounds(263, 245, 150, 19);
		contentPane.add(txtEditora);
		
		JLabel lblNewLabel_4_1_1 = new JLabel("Ano de Edição");
		lblNewLabel_4_1_1.setBounds(482, 222, 88, 13);
		contentPane.add(lblNewLabel_4_1_1);
		
		txtAnoDeEdicao = new JTextField();
		txtAnoDeEdicao.setEditable(false);
		txtAnoDeEdicao.setColumns(10);
		txtAnoDeEdicao.setBounds(448, 245, 150, 19);
		contentPane.add(txtAnoDeEdicao);
		
		JLabel lblNewLabel_6_1 = new JLabel("ISBN");
		lblNewLabel_6_1.setBounds(408, 274, 45, 13);
		contentPane.add(lblNewLabel_6_1);
		
		txtIsbn = new JTextField();
		txtIsbn.setEditable(false);
		txtIsbn.setColumns(10);
		txtIsbn.setBounds(346, 291, 150, 19);
		contentPane.add(txtIsbn);
		
		JButton btnExportarLivros = new JButton("Exportar dados dos Livros");
		btnExportarLivros.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Dados.get().getListaLivros().exportarArquivo();
				JOptionPane.showMessageDialog(null, "Dados exportados com sucesso!");
			}
		});
		btnExportarLivros.setBounds(42, 165, 198, 21);
		contentPane.add(btnExportarLivros);
	}
}
