package ihm;

import modele.Panier;
import modele.Tomate;
import utils.Utils;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.List;

public class PageDetailsTomate extends JDialog {

    public PageDetailsTomate(Window parent, Panier panier, Tomate tomate) {
        super(parent);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(parent.getX() + 75, parent.getY() + 75, 500, 350);
        JPanel contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(0, 0));

        JPanel panel_1 = new JPanel();
        contentPane.add(panel_1, BorderLayout.CENTER);
        panel_1.setLayout(new GridLayout(0, 2, 0, 0));

        JPanel panel_4 = new JPanel();
        panel_1.add(panel_4);
        panel_4.setLayout(new GridLayout(3, 0, 0, 0));

        JLabel lblNomTomate = new JLabel();
        lblNomTomate.setText(tomate.getDésignation());
        lblNomTomate.setHorizontalAlignment(SwingConstants.CENTER);
        lblNomTomate.setForeground(new Color(0, 128, 0));
        lblNomTomate.setFont(new Font("Dialog", Font.BOLD, 16));
        panel_4.add(lblNomTomate);

        JLabel lblPhotoTomate = new JLabel("");
        lblPhotoTomate.setAlignmentX(Component.CENTER_ALIGNMENT);
        lblPhotoTomate.setBounds(new Rectangle(200, 200, 200, 200));
        lblPhotoTomate.setIcon(new ImageIcon("images/Tomates200x200/" + tomate.getNomImage() + ".jpg"));
        lblPhotoTomate.setHorizontalAlignment(SwingConstants.CENTER);
        panel_4.add(lblPhotoTomate);

        JLabel lblEnStock;
        if (tomate.isDisponible()) {
            lblEnStock = new JLabel("En stock");
        } else {
            lblEnStock = new JLabel("Rupture de stock");
        }
        lblEnStock.setBounds(new Rectangle(0, 0, 0, 50));
        lblEnStock.setFont(new Font("Dialog", Font.BOLD, 11));
        lblEnStock.setHorizontalAlignment(SwingConstants.CENTER);
        lblEnStock.setForeground(new Color(0, 128, 0));
        panel_4.add(lblEnStock);

        JPanel panel_5 = new JPanel();
        panel_1.add(panel_5);
        panel_5.setLayout(new BorderLayout(0, 0));

        JPanel panel_6 = new JPanel();
        panel_5.add(panel_6, BorderLayout.CENTER);
        panel_6.setLayout(new BorderLayout(0, 0));

        JTextPane txtDescription = new JTextPane();
        txtDescription.setText(tomate.getDescription());
        txtDescription.setEditable(false);

        panel_6.add(txtDescription);

        JPanel panel_7 = new JPanel();
        FlowLayout flowLayout = (FlowLayout) panel_7.getLayout();
        flowLayout.setAlignment(FlowLayout.LEFT);
        panel_5.add(panel_7, BorderLayout.SOUTH);

        JLabel lblNbGraines = new JLabel("Nombre de graines");
        lblNbGraines.setHorizontalAlignment(SwingConstants.CENTER);
        panel_7.add(lblNbGraines);

        JTextField quantiteGraines = new JTextField();
        quantiteGraines.setHorizontalAlignment(SwingConstants.CENTER);
        quantiteGraines.setText(String.valueOf(tomate.getNombreDeGraines()));
        quantiteGraines.setEditable(false);
        panel_7.add(quantiteGraines);
        quantiteGraines.setColumns(10);

        JPanel panel_2 = new JPanel();
        contentPane.add(panel_2, BorderLayout.SOUTH);
        panel_2.setLayout(new BorderLayout(0, 0));

        JPanel panel = new JPanel();
        panel_2.add(panel, BorderLayout.NORTH);

        JComboBox<Tomate> comboBoxProduitsSimilaires = new JComboBox<>();
        List<Tomate> listeTomatesApparentées = tomate.getTomatesApparentées();
        Tomate[] tableauTomatesApparentées = new Tomate[listeTomatesApparentées.size()];
        listeTomatesApparentées.toArray(tableauTomatesApparentées);

        comboBoxProduitsSimilaires.setModel(new DefaultComboBoxModel<>(tableauTomatesApparentées));
        comboBoxProduitsSimilaires.setSelectedItem(null);
        comboBoxProduitsSimilaires.addItemListener(e -> {
            Object selected = comboBoxProduitsSimilaires.getSelectedItem();
            if (selected != null) {
                new PageDetailsTomate(parent, panier, (Tomate) selected).setVisible(true);
                Utils.closeWindow(this);
            }
        });
        panel.add(comboBoxProduitsSimilaires);

        JLabel lblNewLabel = new JLabel("Prix :");
        panel.add(lblNewLabel);

        JTextField textField_prix = new JTextField();
        textField_prix.setEditable(false);
        textField_prix.setText(String.valueOf(tomate.getPrixTTC()));
        panel.add(textField_prix);
        textField_prix.setColumns(10);

        SpinnerNumberModel spinnerNumberModel = new SpinnerNumberModel(1, 0, tomate.getNombreDeGraines() - panier.getQuantité(tomate), 1);
        JSpinner spinner_quantite = new JSpinner(spinnerNumberModel);
        panel.add(spinner_quantite);

        JPanel panel_3 = new JPanel();
        panel_2.add(panel_3, BorderLayout.SOUTH);

        JButton btnAjouter = new JButton("Ajouter au panier");
        btnAjouter.addActionListener(e -> {
            panier.ajouterArticle(tomate, spinnerNumberModel.getNumber().intValue());
            Utils.closeWindow(this);
        });
        panel_3.add(btnAjouter);

        JButton btnAnnuler = new JButton("Annuler");
        btnAnnuler.addActionListener(e -> {
            Utils.closeWindow(this);
        });
        panel_3.add(btnAnnuler);
    }

}
