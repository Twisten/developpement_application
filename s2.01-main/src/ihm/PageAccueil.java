package ihm;

import modele.*;
import utils.Utils;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class PageAccueil extends JFrame implements Panier.PanierListener {
    private final Window window = this;
    private final Tomates tomates = GenerationArticles.générationDeBaseDesTomates();
    private final Panier panier;

    private final JPanel contentPane;
    private final JPanel panelNorth;
    private final JLabel labelTomates;
    private final JButton buttonPanier;
    private final JPanel panelSouth;
    private final JButton btnConseils;
    private final JPanel panelCenter;
    private final JLabel labelType;
    private final JComboBox<TypeTomate> comboBoxType;
    private final JLabel labelCouleurs;
    private final JComboBox<Couleur> comboBoxCouleur;
    private final JScrollPane scrollPane;
    private final JList<Tomate> list;
    private final DefaultListModel<Tomate> listModel;
    private final JPanel panelType;
    private final JPanel panelCouleur;

    /**
     * Create the frame.
     */
    public PageAccueil() {
        super("Tomates");
        panier = new Panier();
        panier.addPanierListener(this);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 650, 500);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(4, 4));

        panelNorth = new JPanel();
        contentPane.add(panelNorth, BorderLayout.NORTH);
        panelNorth.setLayout(new BorderLayout(0, 0));

        labelTomates = new JLabel("TOMATES");
        labelTomates.setFont(new Font("Dialog", Font.BOLD, 16));
        labelTomates.setIcon(new ImageIcon("images/Logo48.png"));
        panelNorth.add(labelTomates, BorderLayout.WEST);

        buttonPanier = new JButton();
        buttonPanier.setBackground(new Color(46, 194, 126));
        buttonPanier.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        buttonPanier.setIcon(new ImageIcon("images/Panier48.png"));
        buttonPanier.addActionListener(e -> {
            if (panier.getArticles().size() > 0) {
                new PagePanier(this, panier).setVisible(true);
            } else {
                new PopUpPanierVide(this).setVisible(true);
            }
        });
        panelNorth.add(buttonPanier, BorderLayout.EAST);

        panelSouth = new JPanel();
        contentPane.add(panelSouth, BorderLayout.SOUTH);
        panelSouth.setLayout(new BorderLayout(0, 0));

        btnConseils = new JButton();
        btnConseils.setBackground(new Color(46, 194, 126));
        btnConseils.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        btnConseils.setIcon(new ImageIcon("images/Conseils48.png"));
        btnConseils.addActionListener(e -> {
            new PageConseils(this).setVisible(true);
        });
        panelSouth.add(btnConseils, BorderLayout.EAST);

        panelCenter = new JPanel();
        panelSouth.add(panelCenter, BorderLayout.WEST);
        panelCenter.setLayout(new GridLayout(2, 2, 0, 0));

        panelType = new JPanel();
        panelCenter.add(panelType);

        labelType = new JLabel("Type :");
        panelType.add(labelType);

        comboBoxType = new JComboBox<>();
        panelType.add(comboBoxType);
        comboBoxType.setModel(new DefaultComboBoxModel<>(TypeTomate.values()));
        comboBoxType.addItemListener(e -> reloadData());

        panelCouleur = new JPanel();
        panelCenter.add(panelCouleur);

        labelCouleurs = new JLabel("Couleur :");
        panelCouleur.add(labelCouleurs);

        comboBoxCouleur = new JComboBox<>();
        panelCouleur.add(comboBoxCouleur);
        comboBoxCouleur.setModel(new DefaultComboBoxModel<>(Couleur.values()));
        comboBoxCouleur.addItemListener(e -> reloadData());

        scrollPane = new JScrollPane();
        contentPane.add(scrollPane, BorderLayout.CENTER);

        list = new JList<>();
        listModel = new DefaultListModel<>();
        list.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                JList<Tomate> list = (JList<Tomate>) evt.getSource();
                if (evt.getClickCount() == 2) {
                    new PageDetailsTomate(window, panier, list.getSelectedValue()).setVisible(true);
                }
            }
        });
        list.setModel(listModel);
        scrollPane.setViewportView(list);

        reloadData();
    }

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                PageAccueil frame = new PageAccueil();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    private void reloadData() {
        List<Tomate> tomatesFiltrées = tomates.getLesTomates();
        TypeTomate selectedType = (TypeTomate) comboBoxType.getSelectedItem();
        Couleur selectedCouleur = (Couleur) comboBoxCouleur.getSelectedItem();
        if (!selectedType.equals(TypeTomate.TOUTES)) {
            tomatesFiltrées = Utils.filter(tomatesFiltrées, tomate -> tomate.getTypeGraine().equals(selectedType));
        }
        if (!selectedCouleur.equals(Couleur.TOUTES)) {
            tomatesFiltrées = Utils.filter(tomatesFiltrées, tomate -> tomate.getCouleur().equals(selectedCouleur));
        }
        listModel.clear();
        for (Tomate tomate : tomatesFiltrées) {
            listModel.addElement(tomate);
        }
        buttonPanier.setText(panier.sousTotal() + "€");
    }

    @Override
    public void onPanierChanged() {
        reloadData();
    }
}
