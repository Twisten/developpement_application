package ihm;

import modele.Panier;
import utils.Utils;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class PopUpSuppressionPanier extends JDialog {

    public PopUpSuppressionPanier(Window parent, Panier panier) {
        super(parent);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(parent.getX() + 100, parent.getY() + 150, 350, 100);
        JPanel contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(new GridLayout(0, 1, 0, 0));

        JPanel panel = new JPanel();
        contentPane.add(panel);
        panel.setLayout(new BorderLayout(0, 0));

        JLabel lblIcone = new JLabel("");
        lblIcone.setIcon(new ImageIcon("images/Attention48.png"));
        panel.add(lblIcone, BorderLayout.WEST);

        JLabel lblMessage = new JLabel("Voulez-vous vraiment supprimer le panier ?");
        lblMessage.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(lblMessage, BorderLayout.CENTER);

        JPanel panel_1 = new JPanel();
        contentPane.add(panel_1);

        JButton btnOui = new JButton("Oui");
        btnOui.addActionListener(e -> {
            panier.vider();
            Utils.closeWindow(this);
        });
        panel_1.add(btnOui);

        JButton btnNon = new JButton("Non");
        btnNon.addActionListener(e -> Utils.closeWindow(this));
        panel_1.add(btnNon);
    }

}