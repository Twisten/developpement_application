import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class Facture extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Facture frame = new Facture();
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
	public Facture() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		
		JPanel Titre = new JPanel();
		contentPane.add(Titre, BorderLayout.NORTH);
		JTextPane p = new JTextPane();
		
		JLabel VotreFacture = new JLabel("Votre Facture");
		VotreFacture.setFont(new Font("Segoe Print", Font.PLAIN, 25));
		Titre.add(VotreFacture);
		
		JLabel IMG = new JLabel("");
		IMG.setIcon(new ImageIcon("C:\\Users\\Noah\\Downloads\\Logo96.png"));
		Titre.add(IMG);
		
		JPanel Boutons = new JPanel();
		contentPane.add(Boutons, BorderLayout.SOUTH);
		
		JButton Annuler = new JButton("Annuler");
		Annuler.setHorizontalTextPosition(SwingConstants.RIGHT);
		Annuler.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JButton OK = new JButton("Imprimer");
		OK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
		            p.print();
		         } catch (PrinterException ex) {
		            ex.printStackTrace();
		         }
			}
		});
		OK.setHorizontalAlignment(SwingConstants.RIGHT);
		Boutons.add(OK);
		Boutons.add(Annuler);
		
		JPanel FactureTexte = new JPanel();
		contentPane.add(FactureTexte, BorderLayout.CENTER);
		FactureTexte.setLayout(new BorderLayout(0, 0));
		
		JTextPane Visite = new JTextPane();
		Visite.setEditable(false);
		Visite.setForeground(new Color(0, 128, 128));
		Visite.setText("Merci de votre visite !");
		FactureTexte.add(Visite, BorderLayout.NORTH);
		
		JScrollPane scrollPane = new JScrollPane();
		FactureTexte.add(scrollPane, BorderLayout.CENTER);
		
		JTextPane LoremIpsum = new JTextPane();
		LoremIpsum.setText("Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.");
		LoremIpsum.setEditable(false);
		scrollPane.setViewportView(LoremIpsum);
		
		
	}

}
