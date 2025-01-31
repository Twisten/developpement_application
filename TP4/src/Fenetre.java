import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.ScrollPane;
import javax.swing.JList;
import java.awt.GridLayout;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Fenetre extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	
	public static final Color[] COULEURS= {
			new Color(255,255,255), new Color(204,204,255), new Color(102,102,255),
			new Color(102,0,255), new Color(102,0,204), new Color(255,204,255),
			new Color(255,102,255), new Color(204,0,204), new Color(153,0,153),
			new Color(255,204,204), new Color(255,51,51), new Color(204,0,51),new Color(153,0,0),
			new Color(255,255,204), new Color(255,255,102), new Color(255,255,0),
			new Color(153,153,0), new Color(204,255,204), new Color(51,255,51),
			new Color(0,204,51), new Color(0,102,0), new Color(204,204,204),
			new Color(153,153,153), new Color(102,102,102),new Color(51,51,51),
			new Color(255,204,102), new Color(255,204,102), new Color(255,153,0),
			new Color(153,102,0), new Color(204,255,255),new Color(102,204,255),
			new Color(0,102,255), new Color(0,0,204), new Color(0,0,0),
			new Color(51,255,255), new Color(0,204,204), new Color(0,153,153)
			};

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
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		JList list = new JList(COULEURS);
		textField = new JTextField();
		construireControleurListe(list);
		scrollPane.setViewportView(list);
		
		
		contentPane.add(textField, BorderLayout.SOUTH);
		textField.setColumns(10);
		
		
	}

	private void construireControleurListe(JList list) {
		list.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				textField.setText(list.getSelectedValue().toString());
			}
		});
	}

}
