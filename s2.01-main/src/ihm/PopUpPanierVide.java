package ihm;

import utils.Utils;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class PopUpPanierVide extends JDialog {

    public PopUpPanierVide(Window parent) {
        super(parent);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(parent.getX() + 150, parent.getY() + 200, 350, 100);
        JPanel contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(0, 0));

        JPanel panel = new JPanel();
        contentPane.add(panel);
        panel.setLayout(new BorderLayout(0, 0));

        JLabel lblMessage = new JLabel("Le panier est vide");
        lblMessage.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(lblMessage);

        JLabel lblInformation = new JLabel("");
        lblInformation.setIcon(new ImageIcon("images/Info48.png"));
        panel.add(lblInformation, BorderLayout.WEST);

        JPanel panel_1 = new JPanel();
        contentPane.add(panel_1, BorderLayout.SOUTH);

        JButton btnNewButton = new JButton("OK");
        btnNewButton.addActionListener(e -> Utils.closeWindow(this));
        panel_1.add(btnNewButton);
    }

}