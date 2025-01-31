import java.awt.EventQueue;
import java.text.DecimalFormat;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FenetreControle extends JFrame {

    private JPanel contentPane;

    private String[][] etudiants;
    private String[][] controles;

    private JTextField txtType;
    private JTextField txtLibelle;
    private JTextField txtCoeff;
    private JTextField txtMoyenne;

    private JComboBox comboBoxGroupe;
    private JComboBox comboBoxControle;

    private String groupeCourant;
    private int rangControleCourant;

    private DefaultTableModel modeleTable;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    final String[][] etudiants = {
                            { "Valentine", "Alexandre", "A", "00.00", "05.00",
                                    "00.00" },
                            { "Virginie", "Allain", "F", "15.24", "18.06",
                                    "15.62" },
                            { "Helene", "Aubry", "D", "04.62", "13.07",
                                    "03.78" },
                            { "Celina", "Auger", "D", "10.31", "13.15",
                                    "06.95" },
                            { "Arnaude", "Barbier", "D", "09.07", "15.92",
                                    "04.42" },
                            { "Jerome", "Baron", "E", "08.48", "14.14",
                                    "06.97" },
                            { "Maurice", "Becker", "C", "02.93", "17.65",
                                    "04.19" },
                            { "Yves", "Begue", "E", "05.87", "15.62", "07.36" },
                            { "Arnaude", "Benoit", "C", "06.41", "10.96",
                                    "06.30" },
                            { "Sylvie", "Blin", "C", "14.97", "19.11",
                                    "11.65" },
                            { "Agathe", "Blot", "F", "11.93", "16.98",
                                    "12.69" },
                            { "Victoire", "Bodin", "A", "15.81", "18.41",
                                    "09.33" },
                            { "Olivier", "Boulay-Roy", "A", "09.70", "14.53",
                                    "07.24" },
                            { "Margaud", "Bousquet", "D", "15.19", "14.53",
                                    "11.80" },
                            { "Thibaut-Xavier", "Boutin", "A", "15.36", "14.94",
                                    "13.01" },
                            { "Agathe", "Briand-Thibault", "C", "07.61",
                                    "14.02", "10.31" },
                            { "Lucy", "Brun", "C", "07.75", "13.77", "06.29" },
                            { "Arnaude", "Chauvet", "F", "06.45", "12.29",
                                    "07.00" },
                            { "Lucie Colin", "Colin", "D", "09.52", "12.34",
                                    "08.85" },
                            { "Gabrielle Collet", "Collet", "B", "05.84",
                                    "12.58", "08.44" },
                            { "Margot", "Coulon", "A", "15.69", "16.69",
                                    "11.72" },
                            { "Daisy", "Courtois", "C", "16.50", "19.56",
                                    "12.45" },
                            { "Jacqueline", "Da Silva", "C", "09.11", "06.75",
                                    "07.12" },
                            { "Jean", "David", "A", "13.22", "17.84", "11.26" },
                            { "Anais", "Delmas", "B", "05.52", "17.97",
                                    "07.88" },
                            { "Clemence", "De Sousa-Labbe", "F", "16.33",
                                    "15.81", "14.36" },
                            { "Augustin", "Dumont", "C", "05.17", "15.15",
                                    "08.09" },
                            { "Alphonse-Lucas", "Ferreira", "A", "08.80",
                                    "16.91", "03.83" },
                            { "Thibault", "Guyon", "E", "05.44", "10.01",
                                    "08.17" },
                            { "Marcel", "Imbert-Bodin", "E", "16.00", "18.22",
                                    "10.41" },
                            { "Celine", "Jacob", "B", "14.54", "12.23",
                                    "00.00" },
                            { "Auguste", "Jacques", "B", "13.58", "15.75",
                                    "08.36" },
                            { "Denis", "Labbe", "A", "13.83", "13.77",
                                    "09.65" },
                            { "Benjamin", "Launay", "F", "13.60", "16.14",
                                    "13.73" },
                            { "Denis", "Lebon", "D", "07.34", "15.59",
                                    "04.54" },
                            { "Emile", "Legros", "F", "12.42", "16.26",
                                    "14.30" },
                            { "Jacqueline", "Le Hamon", "B", "06.46", "09.27",
                                    "10.53" },
                            { "Hortense", "Lejeune", "B", "00.47", "10.80",
                                    "02.49" },
                            { "Madeleine", "Lemoine", "B", "10.98", "14.24",
                                    "05.83" },
                            { "Michelle-Maggie", "Lenoir", "F", "10.23",
                                    "18.12", "13.45" },
                            { "Frederique", "Leroux", "C", "09.90", "17.55",
                                    "09.08" },
                            { "Isaac", "Le Roux", "C", "06.06", "18.43",
                                    "09.53" },
                            { "Xavier", "Letellier de la Girard", "D", "10.56",
                                    "14.61", "03.47" },
                            { "Bernadette", "Martins", "B", "09.12", "15.43",
                                    "11.09" },
                            { "Luce", "Martins", "D", "15.91", "14.43",
                                    "10.71" },
                            { "Theodore", "Marty", "A", "12.41", "16.91",
                                    "08.52" },
                            { "Camille", "Masson", "B", "06.98", "16.16",
                                    "06.42" },
                            { "Alice", "Menard du Mendes", "F", "08.98",
                                    "12.91", "09.23" },
                            { "Claudine", "Meunier", "A", "16.30", "17.42",
                                    "00.00" },
                            { "Bertrand-Marcel", "Meyer", "E", "02.59", "13.93",
                                    "02.83" },
                            { "Diane", "Millet", "A", "16.03", "19.00",
                                    "09.42" },
                            { "Edouard", "Moulin", "D", "00.00", "02.00",
                                    "00.00" },
                            { "Roland", "Pages-Baron", "C", "08.99", "11.60",
                                    "04.39" },
                            { "Margaret", "Perez", "F", "09.12", "15.50",
                                    "10.10" },
                            { "Richard", "Pottier du Bonnet", "F", "16.03",
                                    "20.00", "14.13" },
                            { "Elodie", "Renaud de la Ferreira", "E", "12.99",
                                    "16.22", "11.25" },
                            { "Franck", "Rocher", "C", "11.97", "18.97",
                                    "11.69" },
                            { "Emmanuel", "Sauvage", "A", "18.29", "19.37",
                                    "15.67" },
                            { "Noemie", "Tanguy", "B", "13.32", "17.41",
                                    "12.13" },
                            { "Michel-Richard", "Techer", "E", "11.03", "13.83",
                                    "10.07" },
                            { "Daniel-Richard", "Texier", "B", "11.78", "16.97",
                                    "10.94" },
                            { "Jerome", "Vincent", "E", "07.66", "15.62",
                                    "06.32" }

                    };

                    final String[][] controles = {
                            { "R2.01-1", "Traduction TAD en Java", "ECRIT",
                                    "0.2" },
                            { "R2.01-2", "Programmation objets en Java",
                                    "ECRIT", "0.4" },
                            { "R2.01-3", "Conception UML", "ECRIT", "0.4" } };

                    FenetreControle frame = new FenetreControle(etudiants,
                            controles);
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
    public FenetreControle(String[][] etudiants, String[][] controles) {
        // renseigner les données métier à manipuler
        this.controles = controles;
        this.etudiants = etudiants;

        // initialiser le rang du contrôle qui sera affiché à l'ouverture
        // de la fenêtre et le groupe courant (tous les groupes)
        rangControleCourant = 0;
        groupeCourant = "tous";

        // initialiser le panneau de la fenêtre
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 480, 344);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        // créer les étiquettes
        JLabel lbl1 = new JLabel("type : ");
        lbl1.setBounds(10, 10, 48, 13);
        contentPane.add(lbl1);

        JLabel lbl2 = new JLabel("libellé : ");
        lbl2.setBounds(106, 10, 48, 13);
        contentPane.add(lbl2);

        JLabel lbl3 = new JLabel("coeff : ");
        lbl3.setBounds(387, 10, 48, 13);
        contentPane.add(lbl3);

        JLabel lbl4 = new JLabel("Moyenne : ");
        lbl4.setBounds(283, 241, 76, 13);
        contentPane.add(lbl4);

        JLabel lbl5 = new JLabel("Groupe : ");
        lbl5.setBounds(52, 273, 58, 13);
        contentPane.add(lbl5);

        JLabel lbl6 = new JLabel("Contrôle : ");
        lbl6.setBounds(230, 273, 70, 13);
        contentPane.add(lbl6);

        // créer les champs textuels
        txtType = new JTextField();
        txtType.setEditable(false);
        txtType.setBounds(52, 7, 48, 19);
        contentPane.add(txtType);
        txtType.setColumns(10);

        txtLibelle = new JTextField();
        txtLibelle.setEditable(false);
        txtLibelle.setColumns(10);
        txtLibelle.setBounds(147, 7, 230, 19);
        contentPane.add(txtLibelle);

        txtCoeff = new JTextField();
        txtCoeff.setEditable(false);
        txtCoeff.setColumns(10);
        txtCoeff.setBounds(421, 7, 32, 19);
        contentPane.add(txtCoeff);

        txtMoyenne = new JTextField();
        txtMoyenne.setEditable(false);
        txtMoyenne.setColumns(10);
        txtMoyenne.setBounds(353, 236, 48, 19);
        contentPane.add(txtMoyenne);

        // créer la table avec son trieur de colonne dans un panneau déroulant
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(48, 50, 370, 176);
        contentPane.add(scrollPane);

        modeleTable = new DefaultTableModel(
                new Object[] { "Nom", "Prenom", "Note" }, 0);
        JTable table = new JTable(modeleTable);
        table.setModel(modeleTable);
        table.setEnabled(false);

        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(
                modeleTable);
        sorter.setComparator(0, String.CASE_INSENSITIVE_ORDER);
        table.setRowSorter(sorter);

        scrollPane.setViewportView(table);

        // créer les comboBox
        comboBoxGroupe = new JComboBox();
        comboBoxGroupe.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				triGroupe();
				
			}
        
        });
      
        comboBoxGroupe.setModel(new DefaultComboBoxModel(
                new String[] { "tous", "A", "B", "C", "D", "E", "F" }));
        comboBoxGroupe.setBounds(128, 269, 62, 21);
        contentPane.add(comboBoxGroupe);

        comboBoxControle = new JComboBox();
        comboBoxControle.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				triGroupe();
				
			}
        
        });
      
        for (int i = 0; i < 3; i++) {
            comboBoxControle.addItem(controles[i][0]);
        }
        comboBoxControle.setBounds(300, 269, 118, 21);
        contentPane.add(comboBoxControle);

        // afficher le type, le libellé et le coefficient du contrôle
        txtType.setText(this.controles[rangControleCourant][2]);
        txtLibelle.setText(this.controles[rangControleCourant][1]);
        txtCoeff.setText(this.controles[rangControleCourant][3]);
        
        triGroupe();
        
    }
    
    public void triGroupe() {
    	modeleTable.setRowCount(0);
        // afficher noms, prénoms, et notes des étudiants dans la table
        for (int i = 0; i < this.etudiants.length; i++) {
        	if (this.etudiants[i][2].equals(comboBoxGroupe.getSelectedItem()) || comboBoxGroupe.getSelectedItem().toString().equals("tous") ){
        		modeleTable.addRow(
                    new Object[] { this.etudiants[i][1], this.etudiants[i][0],
                            this.etudiants[i][rangControleCourant + 3] });
        	}
        }

        // calculer et afficher la moyenne
        float somme = 0.0F;
        for (int i = 0; i < modeleTable.getRowCount(); i++) {
            somme += Float.parseFloat((String) modeleTable.getValueAt(i, 2));
        }
        float moyenne = somme / modeleTable.getRowCount();
        DecimalFormat df = new DecimalFormat("#0.##");
        txtMoyenne.setText(df.format(moyenne));
    	
    }

}
