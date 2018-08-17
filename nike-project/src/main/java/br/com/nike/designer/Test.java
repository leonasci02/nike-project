package br.com.nike.designer;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import br.com.nike.tests.TestNikeBuyProduct;

import javax.swing.ListSelectionModel;

public class Test {

	private JFrame frmNikebot;
	private JTextField txtEmailLogin;
	private JLabel lblTamanhoProduto;
	private JTextField txtTamanhoProduto;
	private JLabel lblTipoEntrega;
	private JLabel lblNumeroCartao;
	private JTextField txtNumeroCartao;
	private JLabel lblNomeCartao;
	private JTextField txtNomeCartao;
	private JLabel lblCodigoSeguranca;
	private JTextField txtCodigoSeguranca;
	private JLabel lblMesCartao;
	private JLabel lblAnoCartao;
	private JTextField txtAnoCartao;
	private JLabel lblParcelaDoCarto;
	private JTextField txtTipoEntrega;
	private JTextField txtUrl;
	private JScrollPane scrollPane;
	private JTable table;
	private JTextField txtParcelaCartao;
	private JComboBox<Object> cbxMesCartao;
	private int contador = 0;
	private JTextField txtSenhaLogin;
	private JButton btnAdd;
	private JButton btnDelete;
	private JButton btnStart;
	private JButton btnStop;
	private TestNikeBuyProduct buyProduct;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Test window = new Test();
					window.frmNikebot.setVisible(true);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Test() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings("serial")
	private void initialize() {

		frmNikebot = new JFrame();
		frmNikebot.getContentPane().setForeground(Color.BLACK);
		frmNikebot.getContentPane().setBackground(Color.DARK_GRAY);
		frmNikebot.setForeground(Color.WHITE);
		frmNikebot.setTitle("NikeBot");
		frmNikebot.setBounds(100, 100, 739, 496);
		frmNikebot.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		SpringLayout springLayout = new SpringLayout();
		frmNikebot.getContentPane().setLayout(springLayout);

		JLabel lblUrlDoProduto = new JLabel("Url do Produto");
		springLayout.putConstraint(SpringLayout.NORTH, lblUrlDoProduto, 1, SpringLayout.NORTH,
				frmNikebot.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, lblUrlDoProduto, 30, SpringLayout.WEST,
				frmNikebot.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, lblUrlDoProduto, 21, SpringLayout.NORTH,
				frmNikebot.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, lblUrlDoProduto, -601, SpringLayout.EAST,
				frmNikebot.getContentPane());
		lblUrlDoProduto.setForeground(Color.WHITE);
		lblUrlDoProduto.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 12));
		frmNikebot.getContentPane().add(lblUrlDoProduto);

		JLabel lblEmailLogin = new JLabel("E-mail");
		springLayout.putConstraint(SpringLayout.NORTH, lblEmailLogin, 30, SpringLayout.SOUTH, lblUrlDoProduto);
		springLayout.putConstraint(SpringLayout.WEST, lblEmailLogin, 30, SpringLayout.WEST,
				frmNikebot.getContentPane());
		lblEmailLogin.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 12));
		lblEmailLogin.setForeground(Color.WHITE);
		frmNikebot.getContentPane().add(lblEmailLogin);

		txtEmailLogin = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, txtEmailLogin, 6, SpringLayout.SOUTH, lblEmailLogin);
		springLayout.putConstraint(SpringLayout.WEST, txtEmailLogin, 30, SpringLayout.WEST,
				frmNikebot.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, txtEmailLogin, -363, SpringLayout.EAST,
				frmNikebot.getContentPane());
		frmNikebot.getContentPane().add(txtEmailLogin);
		txtEmailLogin.setColumns(10);

		JLabel lblSenhaLogin = new JLabel("Senha");
		springLayout.putConstraint(SpringLayout.NORTH, lblSenhaLogin, 0, SpringLayout.NORTH, lblEmailLogin);
		springLayout.putConstraint(SpringLayout.WEST, lblSenhaLogin, 316, SpringLayout.EAST, lblEmailLogin);
		lblSenhaLogin.setForeground(Color.WHITE);
		lblSenhaLogin.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 12));
		frmNikebot.getContentPane().add(lblSenhaLogin);

		lblTamanhoProduto = new JLabel("Tamanho");
		springLayout.putConstraint(SpringLayout.NORTH, lblTamanhoProduto, 16, SpringLayout.SOUTH, txtEmailLogin);
		springLayout.putConstraint(SpringLayout.WEST, lblTamanhoProduto, 30, SpringLayout.WEST,
				frmNikebot.getContentPane());
		lblTamanhoProduto.setForeground(Color.WHITE);
		lblTamanhoProduto.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 12));
		frmNikebot.getContentPane().add(lblTamanhoProduto);

		txtTamanhoProduto = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, txtTamanhoProduto, 6, SpringLayout.SOUTH, lblTamanhoProduto);
		springLayout.putConstraint(SpringLayout.WEST, txtTamanhoProduto, 30, SpringLayout.WEST,
				frmNikebot.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, txtTamanhoProduto, -568, SpringLayout.EAST,
				frmNikebot.getContentPane());
		frmNikebot.getContentPane().add(txtTamanhoProduto);
		txtTamanhoProduto.setColumns(10);

		lblTipoEntrega = new JLabel("Tipo Entrega");
		springLayout.putConstraint(SpringLayout.NORTH, lblTipoEntrega, 0, SpringLayout.NORTH, lblTamanhoProduto);
		springLayout.putConstraint(SpringLayout.WEST, lblTipoEntrega, 85, SpringLayout.EAST, lblTamanhoProduto);
		lblTipoEntrega.setForeground(Color.WHITE);
		lblTipoEntrega.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 12));
		frmNikebot.getContentPane().add(lblTipoEntrega);

		lblNumeroCartao = new JLabel("N\u00FAmero do Cart\u00E3o de Cr\u00E9dito");
		springLayout.putConstraint(SpringLayout.NORTH, lblNumeroCartao, 0, SpringLayout.NORTH, lblTamanhoProduto);
		springLayout.putConstraint(SpringLayout.WEST, lblNumeroCartao, 0, SpringLayout.WEST, lblSenhaLogin);
		lblNumeroCartao.setForeground(Color.WHITE);
		lblNumeroCartao.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 12));
		frmNikebot.getContentPane().add(lblNumeroCartao);

		txtNumeroCartao = new JTextField();
		springLayout.putConstraint(SpringLayout.WEST, txtNumeroCartao, 382, SpringLayout.WEST,
				frmNikebot.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, txtNumeroCartao, -21, SpringLayout.EAST,
				frmNikebot.getContentPane());
		springLayout.putConstraint(SpringLayout.NORTH, txtNumeroCartao, 0, SpringLayout.NORTH, txtTamanhoProduto);
		frmNikebot.getContentPane().add(txtNumeroCartao);
		txtNumeroCartao.setColumns(10);

		lblNomeCartao = new JLabel("Nome do Cart\u00E3o");
		springLayout.putConstraint(SpringLayout.NORTH, lblNomeCartao, 17, SpringLayout.SOUTH, txtTamanhoProduto);
		springLayout.putConstraint(SpringLayout.WEST, lblNomeCartao, 30, SpringLayout.WEST,
				frmNikebot.getContentPane());
		lblNomeCartao.setForeground(Color.WHITE);
		lblNomeCartao.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 12));
		frmNikebot.getContentPane().add(lblNomeCartao);

		txtNomeCartao = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, txtNomeCartao, 6, SpringLayout.SOUTH, lblNomeCartao);
		springLayout.putConstraint(SpringLayout.WEST, txtNomeCartao, 30, SpringLayout.WEST,
				frmNikebot.getContentPane());
		frmNikebot.getContentPane().add(txtNomeCartao);
		txtNomeCartao.setColumns(10);

		lblCodigoSeguranca = new JLabel("C\u00F3digo de Seguran\u00E7a");
		springLayout.putConstraint(SpringLayout.NORTH, lblCodigoSeguranca, 0, SpringLayout.NORTH, lblNomeCartao);
		springLayout.putConstraint(SpringLayout.EAST, lblCodigoSeguranca, -21, SpringLayout.EAST,
				frmNikebot.getContentPane());
		lblCodigoSeguranca.setForeground(Color.WHITE);
		lblCodigoSeguranca.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 12));
		frmNikebot.getContentPane().add(lblCodigoSeguranca);

		txtCodigoSeguranca = new JTextField();
		springLayout.putConstraint(SpringLayout.WEST, txtCodigoSeguranca, 580, SpringLayout.WEST,
				frmNikebot.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, txtCodigoSeguranca, -21, SpringLayout.EAST,
				frmNikebot.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, txtNomeCartao, -31, SpringLayout.WEST, txtCodigoSeguranca);
		springLayout.putConstraint(SpringLayout.NORTH, txtCodigoSeguranca, 0, SpringLayout.NORTH, txtNomeCartao);
		frmNikebot.getContentPane().add(txtCodigoSeguranca);
		txtCodigoSeguranca.setColumns(10);

		lblMesCartao = new JLabel("M\u00EAs do Cart\u00E3o");
		springLayout.putConstraint(SpringLayout.WEST, lblMesCartao, 30, SpringLayout.WEST, frmNikebot.getContentPane());
		lblMesCartao.setForeground(Color.WHITE);
		lblMesCartao.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 12));
		springLayout.putConstraint(SpringLayout.NORTH, lblMesCartao, 17, SpringLayout.SOUTH, txtNomeCartao);
		frmNikebot.getContentPane().add(lblMesCartao);

		cbxMesCartao = new JComboBox<Object>();
		springLayout.putConstraint(SpringLayout.WEST, cbxMesCartao, 30, SpringLayout.WEST, frmNikebot.getContentPane());
		cbxMesCartao.setBackground(Color.WHITE);
		cbxMesCartao.setModel(new DefaultComboBoxModel<Object>(new String[] { "Selecione...", "01", "02", "03", "04",
				"05", "06", "07", "08", "09", "10", "11", "12" }));
		cbxMesCartao.setForeground(Color.BLACK);
		springLayout.putConstraint(SpringLayout.NORTH, cbxMesCartao, 6, SpringLayout.SOUTH, lblMesCartao);
		frmNikebot.getContentPane().add(cbxMesCartao);

		lblAnoCartao = new JLabel("Ano do Cart\u00E3o");
		lblAnoCartao.setForeground(Color.WHITE);
		lblAnoCartao.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 12));
		springLayout.putConstraint(SpringLayout.WEST, lblAnoCartao, 23, SpringLayout.EAST, lblMesCartao);
		springLayout.putConstraint(SpringLayout.SOUTH, lblAnoCartao, 0, SpringLayout.SOUTH, lblMesCartao);
		frmNikebot.getContentPane().add(lblAnoCartao);

		txtAnoCartao = new JTextField();
		springLayout.putConstraint(SpringLayout.WEST, txtAnoCartao, 0, SpringLayout.WEST, lblAnoCartao);
		springLayout.putConstraint(SpringLayout.SOUTH, txtAnoCartao, 0, SpringLayout.SOUTH, cbxMesCartao);
		frmNikebot.getContentPane().add(txtAnoCartao);
		txtAnoCartao.setColumns(10);

		lblParcelaDoCarto = new JLabel("Parcela do Cart\u00E3o");
		springLayout.putConstraint(SpringLayout.NORTH, lblParcelaDoCarto, 0, SpringLayout.NORTH, lblMesCartao);
		springLayout.putConstraint(SpringLayout.WEST, lblParcelaDoCarto, 21, SpringLayout.EAST, lblAnoCartao);
		lblParcelaDoCarto.setForeground(Color.WHITE);
		lblParcelaDoCarto.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 12));
		frmNikebot.getContentPane().add(lblParcelaDoCarto);

		txtTipoEntrega = new JTextField();
		springLayout.putConstraint(SpringLayout.WEST, txtTipoEntrega, 170, SpringLayout.WEST,
				frmNikebot.getContentPane());
		springLayout.putConstraint(SpringLayout.NORTH, txtTipoEntrega, 7, SpringLayout.SOUTH, lblTipoEntrega);
		springLayout.putConstraint(SpringLayout.EAST, txtTipoEntrega, 207, SpringLayout.EAST, txtTamanhoProduto);
		frmNikebot.getContentPane().add(txtTipoEntrega);
		txtTipoEntrega.setColumns(10);

		btnAdd = new JButton("Adicionar");
		springLayout.putConstraint(SpringLayout.WEST, btnAdd, 39, SpringLayout.EAST, lblParcelaDoCarto);
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (validateTxtsFields() == true) {
					addRowTable(txtUrl.getText(), txtEmailLogin.getText(), txtSenhaLogin.getText(),
							txtTamanhoProduto.getText(), txtTipoEntrega.getText(), txtNumeroCartao.getText(),
							txtNomeCartao.getText(), txtCodigoSeguranca.getText(),
							cbxMesCartao.getSelectedItem().toString(), txtAnoCartao.getText(),
							txtParcelaCartao.getText());
					JOptionPane.showMessageDialog(null, "Informações cadastradas com sucesso");
					cleanTxt();
				} else {
					JOptionPane.showMessageDialog(null, "Por favor realizar o preenchimento de todos os campos!");
				}
			}
		});
		springLayout.putConstraint(SpringLayout.NORTH, btnAdd, 6, SpringLayout.SOUTH, txtNomeCartao);
		frmNikebot.getContentPane().add(btnAdd);

		btnDelete = new JButton("Excluir");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				removeRowTable();
			}
		});
		springLayout.putConstraint(SpringLayout.NORTH, btnDelete, 8, SpringLayout.SOUTH, btnAdd);
		springLayout.putConstraint(SpringLayout.WEST, btnDelete, 0, SpringLayout.WEST, lblSenhaLogin);
		springLayout.putConstraint(SpringLayout.EAST, btnDelete, 0, SpringLayout.EAST, btnAdd);
		frmNikebot.getContentPane().add(btnDelete);

		btnStart = new JButton("Iniciar JOB");
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (!(table.getRowCount() == 0)) {

					inputsSetProperty(false);
					Collection<String> collectionTable = valTableLine();
					for (String txtTable : collectionTable) {
						String campos[] = new String[] {};
						campos = txtTable.split(",");
						buyProduct = new TestNikeBuyProduct();
						buyProduct.receiveParameters(campos[0], campos[1], campos[2], campos[3], campos[4], campos[5],
								campos[6], campos[7], campos[8], campos[9], campos[10]);
						try {
							buyProduct.executeScritp();

						} catch (FileNotFoundException e) {
							System.out.println(
									"Houve uma falha na execução do script: " + getClass().getMethods() + e.toString());

						} catch (IOException e) {
							System.out.println(
									"Houve uma falha na execução do script: " + getClass().getMethods() + e.toString());
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						break;
					}
				} else {
					JOptionPane.showMessageDialog(null, "Por favor inserir registros na tabela");
				}
			}
		});
		springLayout.putConstraint(SpringLayout.EAST, btnAdd, -6, SpringLayout.WEST, btnStart);
		springLayout.putConstraint(SpringLayout.WEST, btnStart, 551, SpringLayout.WEST, frmNikebot.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, btnStart, -21, SpringLayout.EAST, frmNikebot.getContentPane());
		springLayout.putConstraint(SpringLayout.NORTH, btnStart, 6, SpringLayout.SOUTH, txtNomeCartao);
		frmNikebot.getContentPane().add(btnStart);

		btnStop = new JButton("Parar JOB");

		springLayout.putConstraint(SpringLayout.WEST, btnStop, 551, SpringLayout.WEST, frmNikebot.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, btnStop, -21, SpringLayout.EAST, frmNikebot.getContentPane());
		springLayout.putConstraint(SpringLayout.NORTH, btnStop, -1, SpringLayout.NORTH, cbxMesCartao);
		enableBtnStop();
		frmNikebot.getContentPane().add(btnStop);

		txtUrl = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, txtUrl, 4, SpringLayout.SOUTH, lblUrlDoProduto);
		springLayout.putConstraint(SpringLayout.WEST, txtUrl, 30, SpringLayout.WEST, frmNikebot.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, txtUrl, -21, SpringLayout.EAST, frmNikebot.getContentPane());
		frmNikebot.getContentPane().add(txtUrl);
		txtUrl.setColumns(10);

		txtParcelaCartao = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, txtParcelaCartao, 6, SpringLayout.SOUTH, lblParcelaDoCarto);
		springLayout.putConstraint(SpringLayout.WEST, txtParcelaCartao, 27, SpringLayout.EAST, txtAnoCartao);
		springLayout.putConstraint(SpringLayout.EAST, txtParcelaCartao, -1, SpringLayout.EAST, lblParcelaDoCarto);
		frmNikebot.getContentPane().add(txtParcelaCartao);
		txtParcelaCartao.setColumns(10);

		scrollPane = new JScrollPane();
		springLayout.putConstraint(SpringLayout.NORTH, scrollPane, 4, SpringLayout.SOUTH, btnDelete);
		springLayout.putConstraint(SpringLayout.WEST, scrollPane, 30, SpringLayout.WEST, frmNikebot.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, scrollPane, -10, SpringLayout.SOUTH,
				frmNikebot.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, scrollPane, -21, SpringLayout.EAST, frmNikebot.getContentPane());
		frmNikebot.getContentPane().add(scrollPane);

		table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Url do produto", "Email ", "Senha", "Tamanho", "Tipo de Entrega", "N. Cartao", "Nome do Cart\u00E3o", "Codigo de Seguran\u00E7a", "M\u00EAs do Cart\u00E3o", "Ano do Cart\u00E3o", "Parcela do Cart\u00E3o"
			}
		) {
			@SuppressWarnings("rawtypes")
			Class[] columnTypes = new Class[] {
				Object.class, Object.class, String.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, String.class
			};
			@SuppressWarnings({ "rawtypes", "unchecked" })
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table.getColumnModel().getColumn(0).setPreferredWidth(150);
		table.getColumnModel().getColumn(1).setPreferredWidth(164);
		table.getColumnModel().getColumn(2).setPreferredWidth(188);
		table.getColumnModel().getColumn(3).setPreferredWidth(103);
		table.getColumnModel().getColumn(4).setPreferredWidth(134);
		table.getColumnModel().getColumn(5).setPreferredWidth(113);
		table.getColumnModel().getColumn(6).setPreferredWidth(138);
		table.getColumnModel().getColumn(7).setPreferredWidth(134);
		table.getColumnModel().getColumn(8).setPreferredWidth(115);
		scrollPane.setColumnHeaderView(table);

		txtSenhaLogin = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, txtSenhaLogin, 6, SpringLayout.SOUTH, lblSenhaLogin);
		springLayout.putConstraint(SpringLayout.WEST, txtSenhaLogin, 0, SpringLayout.WEST, lblSenhaLogin);
		springLayout.putConstraint(SpringLayout.EAST, txtSenhaLogin, 0, SpringLayout.EAST, txtNumeroCartao);
		frmNikebot.getContentPane().add(txtSenhaLogin);
		txtSenhaLogin.setColumns(10);
		removeAllRow();

	}

	private void addRowTable(String Url, String Email, String Senha, String Tamanho, String TipoEntrega,
			String NumeroCartao, String NomeCartao, String CodigoCartao, String MesCartao, String AnoCartao,
			String ParcelaCartao) {

		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.addRow(new Object[] {Url, Email, Senha, Tamanho, TipoEntrega, NumeroCartao, NomeCartao,
				CodigoCartao, MesCartao, AnoCartao, ParcelaCartao });
		contador++;
		if (contador > 10) {

			JOptionPane.showMessageDialog(null, "O limite de informações na tabela excedeu!");
		}
	}

	private void removeRowTable() {
		DefaultTableModel mod = (DefaultTableModel) table.getModel();
		int index = table.getSelectedRow();

		if (table.getSelectedRowCount() == 0) {
			JOptionPane.showMessageDialog(null, "Selecionar uma linha da tabela");
		} else {
			mod.removeRow(index);
			JOptionPane.showMessageDialog(null, "Excluido o registro da tabela de usuários");
		}
	}

	private void cleanTxt() {
		txtUrl.setText(null);
		txtTipoEntrega.setText(null);
		txtTamanhoProduto.setText(null);
		txtSenhaLogin.setText(null);
		txtParcelaCartao.setText(null);
		txtNumeroCartao.setText(null);
		txtNomeCartao.setText(null);
		txtEmailLogin.setText(null);
		txtCodigoSeguranca.setText(null);
		txtAnoCartao.setText(null);
		cbxMesCartao.setSelectedIndex(0);
	}

	private boolean validateTxtsFields() {
		boolean txtsvalidate = false;
		ArrayList<JTextField> result = new ArrayList<JTextField>();
		ArrayList<JTextField> campos = listTextFields();
		for (JTextField cmp : campos) {
			if (validateInput(cmp) == true) {
				result.add(cmp);
			}
		}
		if (result.size() == 0) {
			txtsvalidate = true;
		}

		return txtsvalidate;
	}

	private ArrayList<JTextField> listTextFields() {
		ArrayList<JTextField> txts = new ArrayList<JTextField>();
		txts.add(txtUrl);
		txts.add(txtEmailLogin);
		txts.add(txtSenhaLogin);
		txts.add(txtTamanhoProduto);
		txts.add(txtTipoEntrega);
		txts.add(txtNumeroCartao);
		txts.add(txtNomeCartao);
		txts.add(txtCodigoSeguranca);
		txts.add(txtAnoCartao);
		txts.add(txtParcelaCartao);

		return txts;
	}

	private boolean validateInput(JTextField campo) {
		boolean condiction = false;
		if (campo == null || campo.getText().isEmpty()) {
			condiction = true;
		}
		return condiction;
	}

	private void removeAllRow() {
		DefaultTableModel mod = (DefaultTableModel) table.getModel();
		mod.setRowCount(0);
		contador = 0;
	}

	private Collection<String> valTableLine() {
		int line = table.getRowCount();
		int column = table.getColumnCount();
		Collection<String> listValues = new ArrayList<String>();
		StringBuilder valores = new StringBuilder();

		for (int i = 0; i < line; i++) {
			for (int j = 0; j < column; j++) {
				String valueColumn = table.getValueAt(i, j).toString();
				valores.append(valueColumn.concat(","));
			}
			listValues.add(valores.toString());
			valores = new StringBuilder();
		}
		return listValues;
	}

	private void inputsSetProperty(Boolean flag) {
		txtUrl.setEnabled(flag);
		txtTipoEntrega.setEnabled(flag);
		txtTamanhoProduto.setEnabled(flag);
		txtSenhaLogin.setEnabled(flag);
		txtParcelaCartao.setEnabled(flag);
		txtNumeroCartao.setEnabled(flag);
		txtNomeCartao.setEnabled(flag);
		txtEmailLogin.setEnabled(flag);
		txtCodigoSeguranca.setEnabled(flag);
		txtAnoCartao.setEnabled(flag);
		cbxMesCartao.setEnabled(flag);
		btnAdd.setEnabled(flag);
		btnDelete.setEnabled(flag);
		btnStart.setEnabled(flag);
	}

/*	private Collection<String> removeCharAt(String text, String caracter) {

		Collection<String> returnText = new ArrayList<String>();
		if (text.contains(caracter)) {
			text = text.substring(0, text.length() - 1);
			returnText.add(text);
		}
		return returnText;
	}
*/
	private void enableBtnStop() {
		btnStop.setEnabled(false);
		btnStop.setBackground(Color.GRAY);
		btnStop.setForeground(Color.WHITE);
	}
}