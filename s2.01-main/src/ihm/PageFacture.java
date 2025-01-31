package ihm;

import modele.Panier;
import utils.Utils;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.print.PrinterException;

public class PageFacture extends JDialog {

    public PageFacture(Window parent, Panier panier) {
        super(parent);
        panier.addPanierListener(() -> {
            if (panier.getArticles().size() < 1) {
                Utils.closeWindow(this);
            }
        });

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(parent.getX() + 100, parent.getY() - 150, 400, 700);
        JPanel contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(0, 0));


        JPanel panelTitre = new JPanel();
        contentPane.add(panelTitre, BorderLayout.NORTH);
        JTextPane textPane = new JTextPane();

        JLabel labelVotreFacture = new JLabel("Votre Facture");
        labelVotreFacture.setFont(new Font("Dialog", Font.PLAIN, 25));
        panelTitre.add(labelVotreFacture);

        JLabel labelLogo = new JLabel("");
        labelLogo.setIcon(new ImageIcon("images/Logo96.png"));
        panelTitre.add(labelLogo);

        JPanel panelButtons = new JPanel();
        contentPane.add(panelButtons, BorderLayout.SOUTH);

        JButton buttonAnnuler = new JButton("Annuler");
        buttonAnnuler.setHorizontalTextPosition(SwingConstants.RIGHT);
        buttonAnnuler.addActionListener(e -> {
            Utils.closeWindow(this);
        });

        JButton buttonImprimer = new JButton("Imprimer");
        buttonImprimer.addActionListener(e -> {
            try {
                textPane.print();
                panier.vider();
            } catch (PrinterException ex) {
                ex.printStackTrace();
            }
        });
        buttonImprimer.setHorizontalAlignment(SwingConstants.RIGHT);
        panelButtons.add(buttonImprimer);
        panelButtons.add(buttonAnnuler);

        JPanel panelFactureTexte = new JPanel();
        contentPane.add(panelFactureTexte, BorderLayout.CENTER);
        panelFactureTexte.setLayout(new BorderLayout(0, 0));

        JTextPane textPaneVisite = new JTextPane();
        textPaneVisite.setEditable(false);
        textPaneVisite.setForeground(new Color(0, 128, 128));
        textPaneVisite.setText("Merci de votre visite !");
        panelFactureTexte.add(textPaneVisite, BorderLayout.NORTH);

        JScrollPane scrollPane = new JScrollPane();
        panelFactureTexte.add(scrollPane, BorderLayout.CENTER);

        JTextPane textPaneFacture = new JTextPane();
        textPaneFacture.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 12));
        textPaneFacture.setText(panier.toString());
        textPaneFacture.setEditable(false);
        scrollPane.setViewportView(textPaneFacture);
    }
}