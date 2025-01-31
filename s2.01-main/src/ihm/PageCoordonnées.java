package ihm;

import modele.Panier;
import utils.Utils;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class PageCoordonnées extends JDialog {

    private final JTextField textFieldNom;
    private final JTextField textFieldPrénom;
    private final JTextField textFieldAdresse1;
    private final JTextField textFieldAdresse2;
    private final JTextField textFieldCodePostal;
    private final JTextField textFieldVille;
    private final JTextField textFieldTéléphone;
    private final JTextField textFieldMail;
    private final JRadioButton radioCarteDeCredit;
    private JRadioButton radioPaypal;
    private JRadioButton radioPaiementParCheque;
    private final JRadioButton radioOui;
    private JRadioButton radioNon;

    public PageCoordonnées(Window parent, Panier panier) {
        super(parent);
        panier.addPanierListener(() -> {
            if (panier.getArticles().size() < 1) {
                Utils.closeWindow(this);
            }
        });

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(parent.getX() - 25, parent.getY(), 600, 400);
        JPanel panel = new JPanel();
        panel.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(panel);
        panel.setLayout(new BorderLayout(0, 0));

        JPanel panelTitre = new JPanel();
        panel.add(panelTitre, BorderLayout.NORTH);
        panelTitre.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

        JLabel labelTitre = new JLabel("Vos Coordonnées");
        labelTitre.setFont(new Font("Dialog", Font.BOLD, 26));
        panelTitre.add(labelTitre);

        JLabel labelLogo = new JLabel("");
        labelLogo.setIcon(new ImageIcon("images/Logo96.png"));
        panelTitre.add(labelLogo);

        JPanel panelListe = new JPanel();
        panel.add(panelListe, BorderLayout.CENTER);
        panelListe.setLayout(new GridLayout(0, 2, 0, 0));

        JLabel labelNom = new JLabel("Nom :");
        labelNom.setFont(new Font("Dialog", Font.PLAIN, 15));
        panelListe.add(labelNom);

        textFieldNom = new JTextField();
        textFieldNom.setMinimumSize(new Dimension(10, 19));
        panelListe.add(textFieldNom);
        textFieldNom.setColumns(10);

        JLabel labelPrénom = new JLabel("Prénom :");
        labelPrénom.setFont(new Font("Dialog", Font.PLAIN, 15));
        panelListe.add(labelPrénom);

        textFieldPrénom = new JTextField();
        panelListe.add(textFieldPrénom);
        textFieldPrénom.setColumns(10);

        JLabel labelAdresse = new JLabel("Adresse 1 : ");
        labelAdresse.setFont(new Font("Dialog", Font.PLAIN, 15));
        panelListe.add(labelAdresse);

        textFieldAdresse1 = new JTextField();
        textFieldAdresse1.setFont(new Font("Dialog", Font.PLAIN, 14));
        panelListe.add(textFieldAdresse1);
        textFieldAdresse1.setColumns(10);

        JLabel labelAdresse2 = new JLabel("Adresse 2 : ");
        labelAdresse2.setFont(new Font("Dialog", Font.PLAIN, 15));
        labelAdresse2.setMinimumSize(new Dimension(5, 7));
        panelListe.add(labelAdresse2);

        textFieldAdresse2 = new JTextField();
        textFieldAdresse2.setFont(new Font("Dialog", Font.PLAIN, 10));
        panelListe.add(textFieldAdresse2);
        textFieldAdresse2.setColumns(10);

        JLabel labelCOdePostal = new JLabel("Code Postal :");
        labelCOdePostal.setFont(new Font("Dialog", Font.PLAIN, 15));
        panelListe.add(labelCOdePostal);

        textFieldCodePostal = new JTextField();
        panelListe.add(textFieldCodePostal);
        textFieldCodePostal.setColumns(10);

        JLabel labelVille = new JLabel("Ville :");
        labelVille.setFont(new Font("Dialog", Font.PLAIN, 15));
        panelListe.add(labelVille);

        textFieldVille = new JTextField();
        panelListe.add(textFieldVille);
        textFieldVille.setColumns(10);

        JLabel labelTéléphone = new JLabel("Téléphone :");
        labelTéléphone.setFont(new Font("Dialog", Font.PLAIN, 15));
        panelListe.add(labelTéléphone);

        textFieldTéléphone = new JTextField();
        panelListe.add(textFieldTéléphone);
        textFieldTéléphone.setColumns(10);

        JLabel labelMail = new JLabel("Mail :");
        labelMail.setFont(new Font("Dialog", Font.PLAIN, 15));
        panelListe.add(labelMail);

        textFieldMail = new JTextField();
        panelListe.add(textFieldMail);
        textFieldMail.setColumns(10);

        JPanel panelPaiement = new JPanel();
        panel.add(panelPaiement, BorderLayout.SOUTH);
        panelPaiement.setLayout(new BorderLayout(0, 0));

        JPanel panelTypePaiement = new JPanel();
        panelTypePaiement.setBorder(
                new TitledBorder(null, "Moyen de paiement", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        panelPaiement.add(panelTypePaiement, BorderLayout.NORTH);
        panelTypePaiement.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

        radioCarteDeCredit = new JRadioButton("Carte de crédit");
        radioCarteDeCredit.addActionListener(e -> {
            if (radioCarteDeCredit.isSelected()) {
                radioPaypal.setSelected(false);
                radioPaiementParCheque.setSelected(false);
            }
        });
        radioCarteDeCredit.setSelected(true);

        radioPaypal = new JRadioButton("Paypal");
        radioPaypal.addActionListener(e -> {
            if (radioPaypal.isSelected()) {
                radioCarteDeCredit.setSelected(false);
                radioPaiementParCheque.setSelected(false);
            }
        });

        radioPaiementParCheque = new JRadioButton("Paiement par chèque");
        radioPaiementParCheque.addActionListener(e -> {
            if (radioPaiementParCheque.isSelected()) {
                radioCarteDeCredit.setSelected(false);
                radioPaypal.setSelected(false);
            }
        });

        panelTypePaiement.add(radioCarteDeCredit);
        panelTypePaiement.add(radioPaypal);
        panelTypePaiement.add(radioPaiementParCheque);

        JPanel panelNewsletter = new JPanel();
        panelNewsletter.setForeground(new Color(0, 128, 128));
        panelNewsletter.setBorder(new TitledBorder(null, "Abonnement à notre Newsletter", TitledBorder.LEADING,
                TitledBorder.TOP, null, null));
        panelPaiement.add(panelNewsletter, BorderLayout.CENTER);

        radioOui = new JRadioButton("Oui");
        radioOui.addActionListener(e -> {
            if (radioOui.isSelected()) {
                radioNon.setSelected(false);
            }
        });
        panelNewsletter.add(radioOui);

        radioNon = new JRadioButton("Non");
        radioNon.addActionListener(e -> {
            if (radioNon.isSelected()) {
                radioOui.setSelected(false);
            }
        });
        panelNewsletter.add(radioNon);

        JPanel panelButtons = new JPanel();
        panelButtons.setBounds(new Rectangle(3, 3, 3, 3));
        ((FlowLayout) panelButtons.getLayout()).setAlignment(FlowLayout.RIGHT);
        panelPaiement.add(panelButtons, BorderLayout.SOUTH);

        JButton buttonOk = new JButton("OK");
        buttonOk.addActionListener(e -> {
            panier.setCoordonnées(new Panier.Coordonnées(
                    textFieldNom.getText(),
                    textFieldPrénom.getText(),
                    textFieldAdresse1.getText(),
                    textFieldAdresse2.getText(),
                    textFieldCodePostal.getText(),
                    textFieldVille.getText(),
                    textFieldTéléphone.getText(),
                    textFieldMail.getText()
            ));
            new PageFacture(this, panier).setVisible(true);
        });
        buttonOk.setToolTipText("ok");
        panelButtons.add(buttonOk);

        JButton buttonAnnuler = new JButton("Annuler");
        buttonAnnuler.addActionListener(e -> Utils.closeWindow(this));
        panelButtons.add(buttonAnnuler);
    }
}
