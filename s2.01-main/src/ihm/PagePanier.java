package ihm;

import modele.Panier;
import modele.Tomate;
import utils.Utils;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;

public class PagePanier extends JDialog implements Panier.PanierListener {
    private final Panier panier;

    private final JTextField textField;
    private final JTextField textField_2;

    /**
     * Create the frame.
     */
    public PagePanier(Window parent, Panier panier) {
        super(parent, "Panier");
        this.panier = panier;
        panier.addPanierListener(this);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(parent.getX() + 50, parent.getY() + 50, 550, 400);
        JPanel contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(4, 4));

        JLabel lblNewLabel = new JLabel("VOTRE PANIER");
        contentPane.add(lblNewLabel, BorderLayout.NORTH);
        lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 16));
        lblNewLabel.setIcon(new ImageIcon("images/Panier48.png"));

        JScrollPane scrollPane = new JScrollPane();
        contentPane.add(scrollPane, BorderLayout.CENTER);

        JTable table = new JTable();
        TomateTableModel tableModel = new TomateTableModel(panier);
        table.setModel(tableModel);
        scrollPane.setViewportView(table);
        table.getColumnModel().getColumn(0).setCellRenderer(new TomateTableImageCellRenderer());
        table.getColumnModel().getColumn(3).setCellEditor(new TomateTableSpinnerCellEditor());

        JPanel panel = new JPanel();
        contentPane.add(panel, BorderLayout.SOUTH);
        panel.setLayout(new BorderLayout(0, 0));

        JPanel panel_1 = new JPanel();
        panel.add(panel_1, BorderLayout.SOUTH);

        JButton btnNewButton = new JButton("Valider le panier");
        btnNewButton.addActionListener(e -> {
            new PageCoordonnées(this, panier).setVisible(true);
        });
        panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        panel_1.add(btnNewButton);

        JButton btnViderLePanier = new JButton("Vider le panier");
        btnViderLePanier.addActionListener(e -> {
            new PopUpSuppressionPanier(this, panier).setVisible(true);
        });
        panel_1.add(btnViderLePanier);

        JButton btnContinuerLesAchats = new JButton("Continuer les achats");
        btnContinuerLesAchats.addActionListener(e -> Utils.closeWindow(this));
        panel_1.add(btnContinuerLesAchats);

        JPanel panel_2 = new JPanel();
        panel.add(panel_2, BorderLayout.CENTER);
        panel_2.setLayout(new GridLayout(3, 2, 0, 0));

        JLabel lblSoustotal = new JLabel("Sous-Total :");
        lblSoustotal.setHorizontalAlignment(SwingConstants.TRAILING);
        panel_2.add(lblSoustotal);

        textField = new JTextField(panier.sousTotal() + " €");
        textField.setEditable(false);
        panel_2.add(textField);
        textField.setColumns(10);

        JLabel lblExpditionforfait = new JLabel("Expédition (forfait) :");
        lblExpditionforfait.setHorizontalAlignment(SwingConstants.TRAILING);
        panel_2.add(lblExpditionforfait);

        JTextField textField_1 = new JTextField(panier.fraisDeLivraison() + " €");
        textField_1.setEditable(false);
        panel_2.add(textField_1);
        textField_1.setColumns(10);

        JLabel lblTotal = new JLabel("TOTAL :");
        lblTotal.setForeground(new Color(46, 194, 126));
        lblTotal.setHorizontalAlignment(SwingConstants.TRAILING);
        panel_2.add(lblTotal);

        textField_2 = new JTextField();
        textField_2.setEditable(false);
        textField_2.setForeground(new Color(46, 194, 126));
        panel_2.add(textField_2);
        textField_2.setColumns(10);

        onPanierChanged();
    }

    @Override
    public void onPanierChanged() {
        if (panier.getArticles().size() < 1) {
            Utils.closeWindow(this);
        } else {
            textField.setText(panier.sousTotal() + " €");
            textField_2.setText(panier.prixTotal() + " €");
        }
    }

    public static class TomateTableSpinnerCellEditor extends DefaultCellEditor {
        JSpinner spinner;
        JSpinner.DefaultEditor defaultEditor;
        JTextField text;

        public TomateTableSpinnerCellEditor() {
            super(new JTextField());
            spinner = new JSpinner(new SpinnerNumberModel(0, 0, null, 1));
            defaultEditor = ((JSpinner.DefaultEditor) spinner.getEditor());
            text = defaultEditor.getTextField();
        }

        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
            spinner.setValue(value);
            return spinner;
        }

        public Object getCellEditorValue() {
            return spinner.getValue();
        }
    }

    public static class TomateTableImageCellRenderer extends DefaultTableCellRenderer {
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            JLabel icon = new JLabel("");
            icon.setIcon(new ImageIcon("images/Tomates40x40/" + value + ".jpg"));
            return icon;
        }
    }

    public static class TomateTableModel extends AbstractTableModel {
        private final Panier panier;

        public TomateTableModel(Panier panier) {
            this.panier = panier;
            panier.addPanierListener(this::fireTableDataChanged);
        }

        @Override
        public int getRowCount() {
            return panier.getArticles().size();
        }

        @Override
        public int getColumnCount() {
            return 5;
        }

        @Override
        public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
            if (columnIndex == 3) {
                Tomate tomate = panier.getArticles().get(rowIndex).getTomate();
                panier.modifierQuantitéArticle(tomate, (Integer) aValue);
            }
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            Tomate tomate = panier.getArticles().get(rowIndex).getTomate();
            switch (columnIndex) {
                case 0:
                    return tomate.getNomImage();
                case 1:
                    return tomate.getDésignation();
                case 2:
                    return tomate.getPrixTTC() + " €";
                case 3:
                    return panier.getQuantité(tomate);
                case 4:
                    return tomate.getPrixTTC() * panier.getQuantité(tomate) + " €";
                default:
                    return null;
            }
        }

        @Override
        public boolean isCellEditable(int rowIndex, int columnIndex) {
            return columnIndex == 3;
        }

        @Override
        public String getColumnName(int column) {
            switch (column) {
                case 0:
                    return "Image";
                case 1:
                    return "Nom";
                case 2:
                    return "Prix";
                case 3:
                    return "Quantité";
                case 4:
                    return "Prix total";
                default:
                    return null;
            }
        }

        @Override
        public Class<?> getColumnClass(int columnIndex) {
            switch (columnIndex) {
                case 0:
                case 2:
                case 1:
                case 4:
                    return String.class;
                case 3:
                    return Integer.class;
                default:
                    return null;
            }
        }
    }
}
