package telas;

import java.awt.EventQueue;
import java.beans.PropertyVetoException;
import java.text.ParseException;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import net.miginfocom.swing.MigLayout;
import java.awt.Dimension;
import javax.swing.SwingConstants;
import java.awt.ComponentOrientation;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.border.BevelBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;
import javax.swing.JFormattedTextField;
import java.awt.FlowLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

public class FormPadrao extends JInternalFrame {
	private JTextField TextoNome;
	
	//objetos/botoes
	
	Contato contato = new Contato(null, null);
	JPanel PainelF = new JPanel();
	JPanel Painel2 = new JPanel();
	JButton BotaoNovo = new JButton("Novo");
	JButton BotaoAlterar = new JButton("Alterar");
	JButton BotaoExcluir = new JButton("Excluir");
	JButton BotaoSalvar = new JButton("Salvar");
	JButton BotaoCancelar = new JButton("Cancelar");
	JButton BotaoFechar = new JButton("Fechar");
	private JTextField TextoTelefone;
	private final JPanel PainelInterno = new JPanel();
	private JTable TabelaContatos = new JTable();
	private final JScrollPane scrollPane = new JScrollPane();
	
	//
	
	//metodos de habilitar e desabilitar botoes
	public void habilitarBotoes(boolean e) {
		BotaoNovo.setEnabled(!e);
		BotaoAlterar.setEnabled(!e);
		BotaoExcluir.setEnabled(!e);
		BotaoSalvar.setEnabled(e);
		BotaoCancelar.setEnabled(e);
	}
	//metodo de habilitar caixa de texto
	public void habilitarTexto(boolean e) {
		TextoNome.setEnabled(e);
		TextoTelefone.setEnabled(e);
	}
	//metodo para limpar as caixas de texto
	public void limparTexto() {
		TextoNome.setText("");
		TextoTelefone.setText("");
	
	}
	
	
	
	//rodar a janela
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				
			}
		});
	}
	//construtor
	public FormPadrao() throws PropertyVetoException, ParseException {
		
		
		setFrameIcon(new ImageIcon(FormPadrao.class.getResource("/img/inetcpl.cpl_14_1323-1.png")));
		setIcon(true);
		setFont(new Font("Segoe UI", Font.PLAIN, 12));
		setMaximum(true);
		setBorder(null);
		setBounds(0, 0, 534, 309);
		setResizable(true);
		setTitle("Gerenciador de contatos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
		PainelF.setBackground(SystemColor.activeCaption);
		getContentPane().add(PainelF, BorderLayout.NORTH);
		
		
		//acao dos botoes
		BotaoNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				habilitarBotoes(true);
				habilitarTexto(true);
				limparTexto();
				
			}
		});
		BotaoAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				DefaultTableModel TabelaModelo = (DefaultTableModel) TabelaContatos.getModel();
				if (TabelaContatos.getSelectedRow() != -1) {
					TextoNome.setText(TabelaModelo.getValueAt(TabelaContatos.getSelectedRow(), 0).toString());
					TextoTelefone.setText(TabelaModelo.getValueAt(TabelaContatos.getSelectedRow(), 1).toString());
					TabelaModelo.removeRow(TabelaContatos.getSelectedRow());
				}else {
					JOptionPane.showMessageDialog(null, "Selecione uma linha");
				}
				
				habilitarBotoes(true);
				habilitarTexto(true);
				
			}
		});
		BotaoSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel TabelaModelo = (DefaultTableModel) TabelaContatos.getModel();
				contato.setNome(TextoNome.getText());
				contato.setTelefone(TextoTelefone.getText());
				
				if (contato.nome.equals("") && contato.telefone.equals("(  )      -    ")) {
					JOptionPane.showMessageDialog(null, "Insira pelo menos um dado para prosseguir");
				}else {
					String[] dados = {contato.getNome(),contato.getTelefone()};
					TabelaModelo.addRow(dados);
				}
				
				habilitarBotoes(false);
				habilitarTexto(false);
				limparTexto();
				
			}
		});
		BotaoCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				habilitarBotoes(false);
				habilitarTexto(false);
				
			}
		});
		BotaoFechar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				dispose();//comando para fechar
			}
		});
		BotaoExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (TabelaContatos.getSelectedRow() != -1) {
					DefaultTableModel TabelaModelo = (DefaultTableModel) TabelaContatos.getModel();
					TabelaModelo.removeRow(TabelaContatos.getSelectedRow());
				}else {
					JOptionPane.showMessageDialog(null, "Selecione uma linha");
				}
			}
		});
		
		
		//painel 2
		getContentPane().add(Painel2, BorderLayout.CENTER);
		
		JLabel LabelNome = new JLabel("Nome:");
		LabelNome.setBounds(80, 11, 40, 15);
		
		TextoNome = new JTextField();
		TextoNome.setBounds(162, 8, 209, 20);
		TextoNome.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		TextoNome.setColumns(10);
		
		TextoTelefone = new JFormattedTextField(new MaskFormatter("(##) #####-####"));
		TextoTelefone.setBounds(162, 39, 209, 20);
		TextoTelefone.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		TextoTelefone.setEnabled(false);
		TextoTelefone.setColumns(10);
		Painel2.setLayout(null);
		Painel2.add(LabelNome);
		Painel2.add(TextoNome);
		Painel2.add(TextoTelefone);
		PainelInterno.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		PainelInterno.setBackground(new Color(255, 255, 255));
		PainelInterno.setBounds(10, 70, 514, 168);
		Painel2.add(PainelInterno);
		PainelInterno.setLayout(null);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		scrollPane.setBounds(0, 0, 514, 168);
		
		PainelInterno.add(scrollPane);
		TabelaContatos.setShowGrid(false);
		TabelaContatos.setBorder(null);
		scrollPane.setViewportView(TabelaContatos);
		
		TabelaContatos.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Nome", "Telefone"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		
		JLabel LabelTelefone = new JLabel("Telefone:");
		LabelTelefone.setBounds(80, 42, 56, 15);
		Painel2.add(LabelTelefone);
		
		
		habilitarTexto(false);
		
		BotaoSalvar.setEnabled(false);
		BotaoCancelar.setEnabled(false);
		PainelF.setLayout(new MigLayout("", "[57px][65px][63px][63px][75px][65px]", "[23px]"));
		PainelF.add(BotaoNovo, "cell 0 0,alignx left,aligny top");
		PainelF.add(BotaoAlterar, "cell 1 0,alignx left,aligny top");
		PainelF.add(BotaoExcluir, "cell 2 0,alignx left,aligny top");
		PainelF.add(BotaoSalvar, "cell 3 0,alignx left,aligny top");
		PainelF.add(BotaoCancelar, "cell 4 0,alignx left,aligny top");
		PainelF.add(BotaoFechar, "cell 5 0,alignx left,aligny top");
		
	}
}
