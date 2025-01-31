import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JToggleButton;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;

public class Fenetre extends JFrame {

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
		setBounds(100, 100, 455, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel("12345678.99");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setForeground(new Color(0, 0, 255));
		contentPane.add(lblNewLabel, BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(4, 3, 0, 0));
		
		JButton btnNewButton_14 = new JButton("7");
		btnNewButton_14.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel.add(btnNewButton_14);
		
		JButton btnNewButton_1 = new JButton("8");
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("9");
		panel.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("4");
		panel.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("5");
		panel.add(btnNewButton_4);
		
		JButton btnNewButton_12 = new JButton("6");
		panel.add(btnNewButton_12);
		
		JButton btnNewButton_5 = new JButton("1");
		panel.add(btnNewButton_5);
		
		JButton btnNewButton_15 = new JButton("2");
		panel.add(btnNewButton_15);
		
		JButton btnNewButton = new JButton("3");
		panel.add(btnNewButton);
		
		JButton btnNewButton_13 = new JButton("0");
		panel.add(btnNewButton_13);
		
		JButton btnNewButton_16 = new JButton("1");
		panel.add(btnNewButton_16);
		
		JButton btnNewButton_17 = new JButton("=");
		panel.add(btnNewButton_17);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.EAST);
		panel_1.setLayout(new GridLayout(6, 1, 0, 0));
		
		JButton btnNewButton_7 = new JButton("C");
		btnNewButton_7.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_7.setForeground(new Color(255, 0, 0));
		panel_1.add(btnNewButton_7);
		
		JButton btnNewButton_8 = new JButton("+");
		btnNewButton_8.setForeground(new Color(255, 0, 0));
		btnNewButton_8.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_1.add(btnNewButton_8);
		
		JButton btnNewButton_9 = new JButton("-");
		btnNewButton_9.setForeground(new Color(255, 0, 0));
		btnNewButton_9.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_1.add(btnNewButton_9);
		
		JButton btnNewButton_10 = new JButton("*");
		btnNewButton_10.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_10.setForeground(new Color(255, 0, 0));
		panel_1.add(btnNewButton_10);
		
		JButton btnNewButton_11 = new JButton("/");
		btnNewButton_11.setForeground(new Color(255, 0, 0));
		btnNewButton_11.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_1.add(btnNewButton_11);
		
		JButton btnNewButton_6 = new JButton("+/-");
		btnNewButton_6.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_6.setForeground(new Color(255, 0, 0));
		panel_1.add(btnNewButton_6);
	}

}
