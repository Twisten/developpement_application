import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class TP2 extends JFrame {
	private JPanel contentPane;
	private JTable table;
/**
* Launch the application.
*/
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
		@Override
		public void run() {
			try {
				TP2 frame = new TP2();
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
	public TP2() {
		setBounds(100, 100, 450, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		JSlider slider = new JSlider();
		slider.setPaintTicks(true);
		slider.setPaintLabels(true);
		slider.setOrientation(SwingConstants.VERTICAL);
		contentPane.add(slider, BorderLayout.WEST);
		JLabel lblNewLabel = new JLabel("TITRE 1");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel, BorderLayout.NORTH);
		JPanel p2 = new JPanel();
		contentPane.add(p2, BorderLayout.SOUTH);
		JButton btnNewButton = new JButton("Bouton 1");

		p2.add(btnNewButton);
		JButton btnNewButton_1 = new JButton("Bouton 2");
		p2.add(btnNewButton_1);
		JButton btnNewButton_2 = new JButton("Bouton 3");
		p2.add(btnNewButton_2);
		JPanel p1 = new JPanel();
		getContentPane().add(p1);
		p1.setLayout(new BorderLayout(0, 0));
		JLabel lblNewLabel_1 = new JLabel("Titre 2");
		lblNewLabel_1.setHorizontalTextPosition(SwingConstants.RIGHT);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		p1.add(lblNewLabel_1, BorderLayout.NORTH);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
				new Object[][] { { "Nom", "Pr\u00E9nom", "Age" },
					{ null, null, null }, { null, null, null },
					{ null, null, null }, { null, null, null },
					{ null, null, null }, { null, null, null },
					{ null, null, null }, { null, null, null },
					{ null, null, null }, },
				new String[] { "Colonne 1", "Colonne 2", "Colonne 3" }));
		p1.add(table, BorderLayout.CENTER);
		
		JPanel p3 = new JPanel();
		p1.add(p3, BorderLayout.EAST);
		p3.setLayout(new GridLayout(4, 1, 0, 0));

		JCheckBox chckbxNewCheckBox = new JCheckBox("B1");
		p3.add(chckbxNewCheckBox);

		JCheckBox chckbxNewCheckBox_1 = new JCheckBox("B2");
		p3.add(chckbxNewCheckBox_1);

		JCheckBox chckbxNewCheckBox_3 = new JCheckBox("B3");
		p3.add(chckbxNewCheckBox_3);

		JCheckBox chckbxNewCheckBox_2 = new JCheckBox("B4");
		p3.add(chckbxNewCheckBox_2);

		JPanel p4 = new JPanel();
		p1.add(p4, BorderLayout.SOUTH);
		
		JButton btnNewButton_3 = new JButton("");
		btnNewButton_3.setIcon(new ImageIcon(
				"C:\\Users\\Maxime\\Desktop\\Cours IUT\\S2\\SAE\\2.01\\TP2\\src\\icons\\3936853_setting_creanimasi_scurity_gear.png"));
		p4.add(btnNewButton_3);
		JButton btnNewButton_4 = new JButton("");
		btnNewButton_4.setIcon(new ImageIcon(
"C:\\Users\\Maxime\\Desktop\\Cours IUT\\S2\\SAE\\2.01\\TP2\\src\\icons\\3936851_menu_home_house_creanimasi.png"));
		p4.add(btnNewButton_4);
}
}