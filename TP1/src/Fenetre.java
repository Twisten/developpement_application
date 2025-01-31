import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class Fenetre extends JFrame {
	private JLabel monEtiquette;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Fenetre frame = new Fenetre();
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
	public Fenetre() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Coucou");
		construireControleurBouton(btnNewButton);
		btnNewButton.setToolTipText("coucou");
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		btnNewButton.setForeground(Color.BLUE);
		btnNewButton.setBounds(29, 56, 85, 21);
		contentPane.add(btnNewButton);
		
		monEtiquette = new JLabel("Coucou");
		monEtiquette.setHorizontalAlignment(SwingConstants.CENTER);
		monEtiquette.setOpaque(true);
		monEtiquette.setFont(new Font("Tahoma", Font.PLAIN, 14));
		monEtiquette.setBackground(Color.PINK);
		monEtiquette.setBounds(111, 143, 189, 32);
		contentPane.add(monEtiquette);
	}

	private void construireControleurBouton(JButton btnNewButton) {
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				monEtiquette.setText("Hello World");
			}
		});
	}
}
