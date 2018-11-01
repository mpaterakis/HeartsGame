package UI;

import Human.HeartsDealer;
import Human.HeartsPlayer;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Dialog for inserting the players' and dealer's info
 *
 * @author Emmanouil Paterakis
 */
public class InfoInputDialog extends JDialog {

    public InfoInputDialog() {

        // JLabels
        p1FnameLabel = new JLabel(" First Name: ");
        p1LnameLabel = new JLabel(" Last Name: ");
        p1AgeLabel = new JLabel(" Age: ");
        p1DescLabel = new JLabel(" Description: ");
        p2FnameLabel = new JLabel(" First Name: ");
        p2LnameLabel = new JLabel(" Last Name: ");
        p2AgeLabel = new JLabel(" Age: ");
        p2DescLabel = new JLabel(" Description: ");
        p3FnameLabel = new JLabel(" First Name: ");
        p3LnameLabel = new JLabel(" Last Name: ");
        p3AgeLabel = new JLabel(" Age: ");
        p3DescLabel = new JLabel(" Description: ");
        p4FnameLabel = new JLabel(" First Name: ");
        p4LnameLabel = new JLabel(" Last Name: ");
        p4AgeLabel = new JLabel(" Age: ");
        p4DescLabel = new JLabel(" Description: ");
        dealerFnameLabel = new JLabel(" First Name: ");
        dealerLnameLabel = new JLabel(" Last Name: ");
        dealerAgeLabel = new JLabel(" Age: ");
        dealerDescLabel = new JLabel(" Description: ");

        // JTextFields
        p1FnameField = new JTextField(20);
        p1LnameField = new JTextField(20);
        p1AgeField = new JTextField(20);
        p1DescField = new JTextField(20);
        p2FnameField = new JTextField(20);
        p2LnameField = new JTextField(20);
        p2AgeField = new JTextField(20);
        p2DescField = new JTextField(20);
        p3FnameField = new JTextField(20);
        p3LnameField = new JTextField(20);
        p3AgeField = new JTextField(20);
        p3DescField = new JTextField(20);
        p4FnameField = new JTextField(20);
        p4LnameField = new JTextField(20);
        p4AgeField = new JTextField(20);
        p4DescField = new JTextField(20);
        dealerFnameField = new JTextField(20);
        dealerLnameField = new JTextField(20);
        dealerAgeField = new JTextField(20);
        dealerDescField = new JTextField(20);

        // JButtons
        okButton = new JButton("OK");
        okButton.addActionListener(e -> doOk());
        exitButton = new JButton("Exit");
        exitButton.addActionListener(e -> doExit());

        // JPanels
        bottomPanel = new JPanel(new BorderLayout());
        mainPanel = new JPanel(new GridLayout(3,1));
        dealerPanel = new JPanel(new GridLayout(4, 2));
        p1Panel = new JPanel(new GridLayout(4, 2));
        p2Panel = new JPanel(new GridLayout(4, 2));
        p3Panel = new JPanel(new GridLayout(4, 2));
        p4Panel = new JPanel(new GridLayout(4, 2));
        buttonsPanel = new JPanel(new FlowLayout());

        p1Panel.add(p1FnameLabel);
        p1Panel.add(p1FnameField);
        p1Panel.add(p1LnameLabel);
        p1Panel.add(p1LnameField);
        p1Panel.add(p1AgeLabel);
        p1Panel.add(p1AgeField);
        p1Panel.add(p1DescLabel);
        p1Panel.add(p1DescField);
        p1Panel.setBorder(BorderFactory.createTitledBorder("Player 1"));

        p2Panel.add(p2FnameLabel);
        p2Panel.add(p2FnameField);
        p2Panel.add(p2LnameLabel);
        p2Panel.add(p2LnameField);
        p2Panel.add(p2AgeLabel);
        p2Panel.add(p2AgeField);
        p2Panel.add(p2DescLabel);
        p2Panel.add(p2DescField);
        p2Panel.setBorder(BorderFactory.createTitledBorder("Player 2"));

        p3Panel.add(p3FnameLabel);
        p3Panel.add(p3FnameField);
        p3Panel.add(p3LnameLabel);
        p3Panel.add(p3LnameField);
        p3Panel.add(p3AgeLabel);
        p3Panel.add(p3AgeField);
        p3Panel.add(p3DescLabel);
        p3Panel.add(p3DescField);
        p3Panel.setBorder(BorderFactory.createTitledBorder("Player 3"));
        
        p4Panel.add(p4FnameLabel);
        p4Panel.add(p4FnameField);
        p4Panel.add(p4LnameLabel);
        p4Panel.add(p4LnameField);
        p4Panel.add(p4AgeLabel);
        p4Panel.add(p4AgeField);
        p4Panel.add(p4DescLabel);
        p4Panel.add(p4DescField);
        p4Panel.setBorder(BorderFactory.createTitledBorder("Player 4"));

        dealerPanel.add(dealerFnameLabel);
        dealerPanel.add(dealerFnameField);
        dealerPanel.add(dealerLnameLabel);
        dealerPanel.add(dealerLnameField);
        dealerPanel.add(dealerAgeLabel);
        dealerPanel.add(dealerAgeField);
        dealerPanel.add(dealerDescLabel);
        dealerPanel.add(dealerDescField);
        dealerPanel.setBorder(BorderFactory.createTitledBorder("Dealer"));

        buttonsPanel.add(okButton);
        buttonsPanel.add(exitButton);

        mainPanel.add(dealerPanel);
        mainPanel.add(p1Panel);
        mainPanel.add(p2Panel);

        bottomPanel.add(mainPanel, BorderLayout.CENTER);
        bottomPanel.add(buttonsPanel, BorderLayout.SOUTH);

        add(bottomPanel);

        // JComboBox
        combobox = new JComboBox();
        combobox.addItem(2);
        combobox.addItem(3);
        combobox.addItem(4);
        combobox.addActionListener(e -> {
            if ("2".equals(combobox.getSelectedItem().toString())) {
                mainPanel.remove(p3Panel);
                mainPanel.remove(p4Panel);
                mainPanel.revalidate();
                players = 2;
            }
            if ("3".equals(combobox.getSelectedItem().toString())) {
                mainPanel.remove(p4Panel);
                mainPanel.add(p3Panel);
                mainPanel.revalidate();
                mainPanel.repaint();
                players = 3;
            }
            if ("4".equals(combobox.getSelectedItem().toString())) {
                mainPanel.add(p3Panel);
                mainPanel.add(p4Panel);
                mainPanel.revalidate();
                mainPanel.repaint();
                players = 4;
            }
        });

        // JToolBar
        toolbar = new JMenuBar();
        toolbar.add(new JLabel(" Number of Players: "));
        toolbar.add(combobox);
        setJMenuBar(toolbar);

        // JDialog config
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
    }

    // Custom methods
    // Ok button action
    private void doOk() {
        // If ages' textFields are left empty, set according age to 0
        int p1Age = 0, p2Age = 0, p3Age = 0, p4Age = 0, dealerAge = 0;

        if (!p1AgeField.getText().isEmpty()) {
            try {
                p1Age = Integer.valueOf(p1AgeField.getText());
            } catch (NumberFormatException ex) {
                // If the AgeField has an incompatible value, its age remains zero                
            }
        }

        if (!p2AgeField.getText().isEmpty()) {
            try {
                p2Age = Integer.valueOf(p2AgeField.getText());
            } catch (NumberFormatException ex) {
                // If the AgeField has an incompatible value, its age remains zero        
            }
        }

        if (!p3AgeField.getText().isEmpty()) {
            try {
                p3Age = Integer.valueOf(p3AgeField.getText());
            } catch (NumberFormatException ex) {
                // If the AgeField has an incompatible value, its age remains zero        
            }
        }

        if (!p4AgeField.getText().isEmpty()) {
            try {
                p4Age = Integer.valueOf(p4AgeField.getText());
            } catch (NumberFormatException ex) {
                // If the AgeField has an incompatible value, its age remains zero        
            }
        }

        if (!dealerAgeField.getText().isEmpty()) {
            try {
                dealerAge = Integer.valueOf(dealerAgeField.getText());
            } catch (NumberFormatException ex) {
                // If the AgeField has an incompatible value, its age remains zero        
            }
        }

        HeartsDealer dealer = new HeartsDealer(dealerFnameField.getText(), dealerLnameField.getText(), dealerDescField.getText(), dealerAge);
        HeartsPlayer player1 = new HeartsPlayer(p1FnameField.getText(), p1LnameField.getText(), p1DescField.getText(), p1Age, 1);
        HeartsPlayer player2 = new HeartsPlayer(p2FnameField.getText(), p2LnameField.getText(), p2DescField.getText(), p2Age, 2);
        if (players > 2) {
            HeartsPlayer player3 = new HeartsPlayer(p3FnameField.getText(), p3LnameField.getText(), p3DescField.getText(), p3Age, 3);
            if (players > 3) {
                HeartsPlayer player4 = new HeartsPlayer(p4FnameField.getText(), p4LnameField.getText(), p4DescField.getText(), p4Age, 4);
                new MainFrame(player1, player2, player3, player4, dealer);
            } else {
                new MainFrame(player1, player2, player3, dealer);
            }
        } else {
            new MainFrame(player1, player2, dealer);
        }

        // Close this dialog
        dispose();
    }

    // Exit the program
    private void doExit() {
        this.dispose();
    }

    // Fields
    private final JLabel p1FnameLabel, p1LnameLabel, p1AgeLabel, p1DescLabel,
            p2FnameLabel, p2LnameLabel, p2AgeLabel, p2DescLabel,
            p3FnameLabel, p3LnameLabel, p3AgeLabel, p3DescLabel,
            p4FnameLabel, p4LnameLabel, p4AgeLabel, p4DescLabel,
            dealerFnameLabel, dealerLnameLabel, dealerAgeLabel, dealerDescLabel;
    private final JTextField p1FnameField, p1LnameField, p1AgeField, p1DescField,
            p2FnameField, p2LnameField, p2AgeField, p2DescField,
            p3FnameField, p3LnameField, p3AgeField, p3DescField,
            p4FnameField, p4LnameField, p4AgeField, p4DescField,
            dealerFnameField, dealerLnameField, dealerAgeField, dealerDescField;
    private final JPanel p1Panel, p2Panel, p3Panel, p4Panel, dealerPanel,
            mainPanel, buttonsPanel, bottomPanel;
    private final JButton okButton, exitButton;
    private final JMenuBar toolbar;
    private final JComboBox combobox;
    private int players = 2;
}
