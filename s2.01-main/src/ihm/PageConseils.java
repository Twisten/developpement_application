package ihm;

import modele.Tomates;
import utils.Utils;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class PageConseils extends JDialog {
    private final JPanel contentPane;

    public PageConseils(Window parent) {
        super(parent);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(parent.getX() + 100, parent.getY() - 50, 450, 600);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(4, 4));

        JPanel panel = new JPanel();
        contentPane.add(panel, BorderLayout.NORTH);
        panel.setLayout(new BorderLayout(4, 4));

        JLabel labelTitre = new JLabel("CONSEILS");
        labelTitre.setFont(new Font("Dialog", Font.BOLD, 16));
        labelTitre.setIcon(new ImageIcon("images/Conseils48.png"));
        panel.add(labelTitre, BorderLayout.NORTH);

        JTextPane textPaneConseilsTitre = new JTextPane();
        textPaneConseilsTitre.setEditable(false);
        textPaneConseilsTitre.setText(Tomates.CONSEILS_DE_CULTURE_TITRE);
        panel.add(textPaneConseilsTitre, BorderLayout.CENTER);

        JScrollPane scrollPane = new JScrollPane();
        contentPane.add(scrollPane, BorderLayout.CENTER);

        JTextPane textPaneConseils = new JTextPane();
        textPaneConseils.setEditable(false);
        textPaneConseils.setText(Tomates.CONSEILS_DE_CULTURE);
        scrollPane.setViewportView(textPaneConseils);

        JPanel panelButton = new JPanel();
        contentPane.add(panelButton, BorderLayout.SOUTH);
        panelButton.setLayout(new BorderLayout(4, 4));

        JButton buttonOk = new JButton("OK");
        buttonOk.addActionListener(e -> Utils.closeWindow(this));
        panelButton.add(buttonOk, BorderLayout.EAST);
    }

}
