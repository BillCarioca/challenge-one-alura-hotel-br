package views;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controllers.HospedeController;
import controllers.ReservaController;
import domain.models.Hospede;
import domain.models.Reserva;

import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTabbedPane;
import java.awt.Toolkit;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import javax.swing.ListSelectionModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("serial")
public class Buscar extends JFrame {

	private JPanel contentPane;
	private JTextField txtBuscar;
	private JTable tbHospedes;
	private JTable tbReservas;
	private DefaultTableModel modelo;
	private DefaultTableModel modeloHospedes;
	private JLabel labelAtras;
	private JLabel labelExit;
	int xMouse, yMouse;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Buscar frame = new Buscar();
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
	public Buscar() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Buscar.class.getResource("/imagenes/lOGO-50PX.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 910, 571);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		setUndecorated(true);
		
		txtBuscar = new JTextField();
		txtBuscar.setBounds(536, 127, 193, 31);
		txtBuscar.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		contentPane.add(txtBuscar);
		txtBuscar.setColumns(10);
		
		
		JLabel lblTitulo = new JLabel("SISTEMA DE BUSCA");
		lblTitulo.setForeground(new Color(12, 138, 199));
		lblTitulo.setFont(new Font("Roboto Black", Font.BOLD, 24));
		lblTitulo.setBounds(331, 62, 280, 42);
		contentPane.add(lblTitulo);
		
		JTabbedPane panel = new JTabbedPane(JTabbedPane.TOP);
		panel.setBackground(new Color(12, 138, 199));
		panel.setFont(new Font("Roboto", Font.PLAIN, 16));
		panel.setBounds(20, 169, 865, 328);
		contentPane.add(panel);
		
		String btnBuscar = "";	
		
		tbReservas = new JTable();
		tbReservas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tbReservas.setFont(new Font("Roboto", Font.PLAIN, 16));
		modelo = (DefaultTableModel) tbReservas.getModel();
		modelo.addColumn("Numero de Reserva");
		modelo.addColumn("Data Check In");
		modelo.addColumn("Data Check Out");
		modelo.addColumn("Valor");
		modelo.addColumn("Forma de Pago");
		JScrollPane scroll_table = new JScrollPane(tbReservas);
		panel.addTab("Reservas", new ImageIcon(Buscar.class.getResource("/imagenes/reservado.png")), scroll_table, null);
		scroll_table.setVisible(true);
		
			 
		tbHospedes = new JTable();
		tbHospedes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tbHospedes.setFont(new Font("Roboto", Font.PLAIN, 16));
		modeloHospedes = (DefaultTableModel) tbHospedes.getModel();
		modeloHospedes.addColumn("Numero de Hóspede");
		modeloHospedes.addColumn("Nome");
		modeloHospedes.addColumn("Sobrenome");
		modeloHospedes.addColumn("Data de Nascimento");
		modeloHospedes.addColumn("Nacionalidade");
		modeloHospedes.addColumn("Telefone");
		modeloHospedes.addColumn("Numero de Reserva");
		atualizarHospedes(btnBuscar);
		JScrollPane scroll_tableHuespedes = new JScrollPane(tbHospedes);
		panel.addTab("Huéspedes", new ImageIcon(Buscar.class.getResource("/imagenes/pessoas.png")), scroll_tableHuespedes, null);
		scroll_tableHuespedes.setVisible(true);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(Buscar.class.getResource("/imagenes/Ha-100px.png")));
		lblNewLabel_2.setBounds(56, 51, 104, 107);
		contentPane.add(lblNewLabel_2);
		
		JPanel header = new JPanel();
		header.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				headerMouseDragged(e);
			     
			}
		});
		header.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				headerMousePressed(e);
			}
		});
		header.setLayout(null);
		header.setBackground(Color.WHITE);
		header.setBounds(0, 0, 910, 36);
		contentPane.add(header);
		
		JPanel btnAtras = new JPanel();
		btnAtras.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MenuUsuario usuario = new MenuUsuario();
				usuario.setVisible(true);
				dispose();				
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				btnAtras.setBackground(new Color(12, 138, 199));
				labelAtras.setForeground(Color.white);
			}			
			@Override
			public void mouseExited(MouseEvent e) {
				 btnAtras.setBackground(Color.white);
			     labelAtras.setForeground(Color.black);
			}
		});
		btnAtras.setLayout(null);
		btnAtras.setBackground(Color.WHITE);
		btnAtras.setBounds(0, 0, 53, 36);
		header.add(btnAtras);
		
		labelAtras = new JLabel("<");
		labelAtras.setHorizontalAlignment(SwingConstants.CENTER);
		labelAtras.setFont(new Font("Roboto", Font.PLAIN, 23));
		labelAtras.setBounds(0, 0, 53, 36);
		btnAtras.add(labelAtras);
		
		JPanel btnexit = new JPanel();
		btnexit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MenuUsuario usuario = new MenuUsuario();
				usuario.setVisible(true);
				dispose();
			}
			@Override
			public void mouseEntered(MouseEvent e) { // Quando o usuário passa o mouse sobre o botão, ele muda de cor
				btnexit.setBackground(Color.red);
				labelExit.setForeground(Color.white);
			}			
			@Override
			public void mouseExited(MouseEvent e) { //Quando o usuário remove o mouse do botão, ele retornará ao estado original
				 btnexit.setBackground(Color.white);
			     labelExit.setForeground(Color.black);
			}
		});
		btnexit.setLayout(null);
		btnexit.setBackground(Color.WHITE);
		btnexit.setBounds(857, 0, 53, 36);
		header.add(btnexit);
		
		labelExit = new JLabel("X");
		labelExit.setHorizontalAlignment(SwingConstants.CENTER);
		labelExit.setForeground(Color.BLACK);
		labelExit.setFont(new Font("Roboto", Font.PLAIN, 18));
		labelExit.setBounds(0, 0, 53, 36);
		btnexit.add(labelExit);
		
		JSeparator separator_1_2 = new JSeparator();
		separator_1_2.setForeground(new Color(12, 138, 199));
		separator_1_2.setBackground(new Color(12, 138, 199));
		separator_1_2.setBounds(539, 159, 193, 2);
		contentPane.add(separator_1_2);
		
		JPanel btnbuscar = new JPanel();
		btnbuscar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				modeloHospedes.setRowCount(0);
				modelo.setRowCount(0);
				atualizarHospedes(txtBuscar.getText());
				
			}
		});
		btnbuscar.setLayout(null);
		btnbuscar.setBackground(new Color(12, 138, 199));
		btnbuscar.setBounds(748, 125, 122, 35);
		btnbuscar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		contentPane.add(btnbuscar);
		
		JLabel lblBuscar = new JLabel("BUSCAR");
		lblBuscar.setBounds(0, 0, 122, 35);
		btnbuscar.add(lblBuscar);
		lblBuscar.setHorizontalAlignment(SwingConstants.CENTER);
		lblBuscar.setForeground(Color.WHITE);
		lblBuscar.setFont(new Font("Roboto", Font.PLAIN, 18));
		
		JPanel btnEditar = new JPanel();
		btnEditar.setLayout(null);
		btnEditar.setBackground(new Color(12, 138, 199));
		btnEditar.setBounds(635, 508, 122, 35);
		btnEditar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		contentPane.add(btnEditar);
		
		btnEditar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				alterarHospede();
				alterarReserva();
				modeloHospedes.setRowCount(0);
				modelo.setRowCount(0);
				atualizarHospedes(txtBuscar.getText());
			}
		});
		
		JLabel lblEditar = new JLabel("EDITAR");
		lblEditar.setHorizontalAlignment(SwingConstants.CENTER);
		lblEditar.setForeground(Color.WHITE);
		lblEditar.setFont(new Font("Roboto", Font.PLAIN, 18));
		lblEditar.setBounds(0, 0, 122, 35);
		btnEditar.add(lblEditar);
		
		JPanel btnDeletar = new JPanel();
		btnDeletar.setLayout(null);
		btnDeletar.setBackground(new Color(12, 138, 199));
		btnDeletar.setBounds(767, 508, 122, 35);
		btnDeletar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		contentPane.add(btnDeletar);
		
		btnDeletar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				deletarReserva();
				deletarHospede();
				modeloHospedes.setRowCount(0);
				modelo.setRowCount(0);
			}
		});
		
		JLabel lblExcluir = new JLabel("DELETAR");
		lblExcluir.setHorizontalAlignment(SwingConstants.CENTER);
		lblExcluir.setForeground(Color.WHITE);
		lblExcluir.setFont(new Font("Roboto", Font.PLAIN, 18));
		lblExcluir.setBounds(0, 0, 122, 35);
		btnDeletar.add(lblExcluir);
		setResizable(false);
	}
	private void atualizarReservas(Long id) {
		ReservaController reservaController = new ReservaController();
		List<Reserva> reservas = new ArrayList<>();
		if (id==0l||id==null) {
			reservas = reservaController.buscarTodas();
		}else {
			reservas.add(reservaController.buscarPorId(id));
		}
		reservaController.desconectar();
		for (Reserva reserva : reservas) {
		    Object[] linha = new Object[5];
		    linha[0] = reserva.getId();
		    linha[1] = reserva.getDataEntrada();
		    linha[2] = reserva.getDataSaida();
		    linha[3] = reserva.getValor();
		    linha[4] = reserva.getFormaPagamento();
		    modelo.addRow(linha);
		}
	}
	
	private void atualizarHospedes(String buscar) {
		
		List<Hospede> hospedes = new ArrayList<>();
		HospedeController hospedeController = new HospedeController();
		if (buscar==""||buscar==null) {
			hospedes = hospedeController.buscarTodos();
			atualizarReservas(0l);
		}else {
			hospedes = hospedeController.buscarPorSobrenome(buscar);
		}
		hospedeController.desconectar();
		for (Hospede hospede : hospedes) {
		    Object[] linha = new Object[7];
		    linha[0] = hospede.getId();
		    linha[1] = hospede.getNome();
		    linha[2] = hospede.getSobrenome();
		    linha[3] = hospede.getDataNascimento();
		    linha[4] = hospede.getNacionalidade();
		    linha[5] = hospede.getTelefone();
		    linha[6] = hospede.getIdReserva();
		    modeloHospedes.addRow(linha);
		    if (buscar!=""&&buscar!=null) atualizarReservas(hospede.getIdReserva());
		}
	}
	
	private void alterarReserva() {
		
		ReservaController reservaController = new ReservaController();
		int selectedRowIndexRereservas = tbReservas.getSelectedRow();
		
		if(selectedRowIndexRereservas != -1) {
			String id = modelo.getValueAt(selectedRowIndexRereservas, 0).toString();
			String diaChegada = modelo.getValueAt(selectedRowIndexRereservas, 1).toString();
			String diaSaida = modelo.getValueAt(selectedRowIndexRereservas, 2).toString();
			String valor = modelo.getValueAt(selectedRowIndexRereservas, 3).toString();
			String formaPagamento = modelo.getValueAt(selectedRowIndexRereservas, 4).toString();
			
			Long newId = Long.parseLong(id);
			Double newValor = Double.valueOf(valor);
									
			if(!id.trim().isEmpty() && !diaChegada.trim().isEmpty() && !diaSaida.trim().isEmpty() && !valor.trim().isEmpty() && !formaPagamento.trim().isEmpty()) {
				Reserva reserva = new Reserva(newId, java.sql.Date.valueOf(diaChegada), java.sql.Date.valueOf(diaSaida), newValor, formaPagamento);
				reservaController.alterar(reserva);
				reservaController.desconectar();
				JOptionPane.showMessageDialog(contentPane, "Reserva atualizada!");
				
			} else {
				JOptionPane.showMessageDialog(null, "Não é permitido atualizar campos vazios.!","Erro", JOptionPane.ERROR_MESSAGE);
			}	
		}
	}
	
	private void alterarHospede() {
		HospedeController hospedeController = new HospedeController();
		int selectedRowIndex = tbHospedes.getSelectedRow();
		
		if(selectedRowIndex != -1) {
			String id = modeloHospedes.getValueAt(selectedRowIndex, 0).toString();
			String nome = modeloHospedes.getValueAt(selectedRowIndex, 1).toString();
			String sobrenome = modeloHospedes.getValueAt(selectedRowIndex, 2).toString();
			String dataNascimento = modeloHospedes.getValueAt(selectedRowIndex, 3).toString();
			String nacionalidade = modeloHospedes.getValueAt(selectedRowIndex, 4).toString();
			String telefone = modeloHospedes.getValueAt(selectedRowIndex, 5).toString();
			String reservaId = modeloHospedes.getValueAt(selectedRowIndex, 6).toString();
			
			Long newId = Long.parseLong(id);
			Long newreservaId = Long.parseLong(reservaId);
													
			if(!id.trim().isEmpty() && !nome.trim().isEmpty() && !sobrenome.trim().isEmpty() && 
					!dataNascimento.trim().isEmpty() && !nacionalidade.trim().isEmpty() && 
					!telefone.trim().isEmpty() && !reservaId.trim().isEmpty()) {	
				Hospede hospede = new Hospede(newId, nome, sobrenome, java.sql.Date.valueOf(dataNascimento), nacionalidade, telefone, newreservaId);
				hospedeController.alterar(hospede);
				hospedeController.desconectar();
				JOptionPane.showMessageDialog(contentPane, "hospede atualizado!");
			} else {
				JOptionPane.showMessageDialog(null, "Não é permitido atualizar campos vazios.!","Erro", JOptionPane.ERROR_MESSAGE);
			}
				
			
		}
	}

	private void deletarReserva() {

		ReservaController reservaController = new ReservaController();
		int selectedRowIndexRereservas = tbReservas.getSelectedRow();
		if(selectedRowIndexRereservas != -1) {
			String id = modelo.getValueAt(selectedRowIndexRereservas, 0).toString();
			Long newId = Long.parseLong(id);
			if(!id.trim().isEmpty()) {
				reservaController.deletar(newId);
				reservaController.desconectar();
				JOptionPane.showMessageDialog(contentPane, "Reserva Deletada!");
			}else {
				JOptionPane.showMessageDialog(null, "Não é permitido deletar campos vazios.!","Erro", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	
	private void deletarHospede() {
		HospedeController hospedeController = new HospedeController();
		int selectedRowIndex = tbHospedes.getSelectedRow();
		
		if(selectedRowIndex != -1) {
			String id = modeloHospedes.getValueAt(selectedRowIndex, 0).toString();
			Long newId = Long.parseLong(id);
			if(!id.trim().isEmpty()) {
				hospedeController.deletar(newId);
				hospedeController.desconectar();
				JOptionPane.showMessageDialog(contentPane, "Hospede Deletado!");
			}else {
				JOptionPane.showMessageDialog(null, "Não é permitido deletar campos vazios.!","Erro", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	
	//Código que permite movimentar a janela pela tela seguindo a posição de "x" e "y"	
	 private void headerMousePressed(java.awt.event.MouseEvent evt) {
	        xMouse = evt.getX();
	        yMouse = evt.getY();
	    }

	    private void headerMouseDragged(java.awt.event.MouseEvent evt) {
	        int x = evt.getXOnScreen();
	        int y = evt.getYOnScreen();
	        this.setLocation(x - xMouse, y - yMouse);
}
}
