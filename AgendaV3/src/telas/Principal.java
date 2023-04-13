package telas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.AbstractDocument.Content;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.ImageIcon;
import javax.swing.JMenuItem;
import javax.swing.JDesktopPane;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Color;
import java.awt.Desktop;

import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;
import java.text.ParseException;

public class Principal extends JFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
		});
	}
	
	JDesktopPane PainelDesktop = new JDesktopPane();
	
	public Principal() {
		setBackground(new Color(192, 192, 192));
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(Principal.class.getResource("/img/lhmstsc.exe_14_13012-2.png")));
		
		//setExtendedState(JFrame.MAXIMIZED_BOTH);
		
		setResizable(false);
		setTitle("Agenda");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 370);//tamanho da janela
		
		
		
		
		JMenuBar BarraMenu = new JMenuBar();
		BarraMenu.setBackground(SystemColor.menu);
		BarraMenu.setBorderPainted(false);
		setJMenuBar(BarraMenu); //Barra de menus
		
		
		
		
		JMenu MenuArquivo = new JMenu("Arquivo");
		MenuArquivo.setIcon(new ImageIcon(Principal.class.getResource("/img/cmd.exe_14_IDI_APPICON-4.png")));
		BarraMenu.add(MenuArquivo);//menu Arquivo
		

		
		JMenuItem ItemContatos = new JMenuItem("Contatos");
		MenuArquivo.add(ItemContatos);
		//acao do itemContatos
		ItemContatos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				FormPadrao tela;
				
				try {
					
					tela = new FormPadrao();
					PainelDesktop.add(tela);
					tela.setVisible(true);
				} catch (PropertyVetoException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ParseException e1) {
					
					e1.printStackTrace();
				}
				
				
			}
		});
		
		

		ItemContatos.setIcon(new ImageIcon(Principal.class.getResource("/img/inetcpl.cpl_14_1323-1.png")));
		
		


		JMenu MenuSobre = new JMenu("Sobre");
		MenuSobre.setIcon(new ImageIcon(Principal.class.getResource("/img/compstui.dll_14_64049-1.png")));
		BarraMenu.add(MenuSobre);
		
		
		
		
		
		JPanel contentPane = new JPanel();
		
		
		
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		PainelDesktop.setBorder(null);
		PainelDesktop.setBackground(SystemColor.window);
		PainelDesktop.setBounds(0, 0, 534, 309);
		contentPane.add(PainelDesktop);
	}
} 
