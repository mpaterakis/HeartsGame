package UI;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

/**
 *
 * @author Emmanouil Paterakis
 */
public class MainFrame extends JFrame {

    // Constructor
    public MainFrame() {
        initComponents();
    }

    // Custom methods
    private void initComponents() {
        
        // JTextArea
        infoArea = new JTextArea("Welcome to my game!");
        
        // JButtons
        p1IntroduceBtn = new JButton("Introduce");
        p1ShowHandBtn = new JButton("Show hand");
        p2IntroduceBtn = new JButton("Introduce");
        p2ShowHandBtn = new JButton("Show hand");
        dealBtn = new JButton("Deal");
        dealerIntroduceBtn = new JButton("Introduce");
        showDeckBtn = new JButton("Show Deck");
        decideWinnerBtn = new JButton("Decide Winner");
        
        // JLabels
        p1Label = new JLabel("Player 1", SwingConstants.CENTER);
        p2Label = new JLabel("Player 2", SwingConstants.CENTER);
        dealerLabel = new JLabel("Dealer", SwingConstants.CENTER);        
        
        // JPanels
        bottomPanel = new JPanel(new BorderLayout());
        gamePanel = new JPanel(new GridLayout(4, 1));
        actionsPanel = new JPanel(new GridLayout(4,1));
        p1Panel = new JPanel(new GridLayout(2,1));
        p2Panel = new JPanel(new GridLayout(2,1));
        dealerPanel = new JPanel(new GridLayout(2,1));
                
        gamePanel.add(infoArea);
        
        p1Panel.add(p1Label);
        JPanel p1ButtonsPanel = new JPanel(new FlowLayout());
        p1ButtonsPanel.add(p1IntroduceBtn);
        p1ButtonsPanel.add(p1ShowHandBtn);
        p1Panel.add(p1ButtonsPanel);
        
        p2Panel.add(p2Label);
        JPanel p2ButtonsPanel = new JPanel(new FlowLayout());
        p2ButtonsPanel.add(p2IntroduceBtn);
        p2ButtonsPanel.add(p2ShowHandBtn);
        p2Panel.add(p2ButtonsPanel);
        
        dealerPanel.add(dealerLabel);
        JPanel dealerButtonsPanel = new JPanel(new GridLayout(2,2));
        dealerButtonsPanel.add(dealerIntroduceBtn);
        dealerButtonsPanel.add(showDeckBtn);
        dealerButtonsPanel.add(dealBtn);
        dealerButtonsPanel.add(decideWinnerBtn);
        dealerPanel.add(dealerButtonsPanel);
        
        actionsPanel.add(p1Panel);
        actionsPanel.add(dealerPanel);
        actionsPanel.add(p2Panel);
        
        bottomPanel.add(gamePanel, BorderLayout.EAST);
        bottomPanel.add(actionsPanel, BorderLayout.WEST);
        
        add(bottomPanel);
        
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Hearts Game");
        setVisible(true);
    }

    // Fields
    private JPanel bottomPanel, actionsPanel, p1Panel, p2Panel, dealerPanel,
            p1DeckPanel, p2DeckPanel, deckPanel, gamePanel;
    private JButton p1IntroduceBtn, p2IntroduceBtn, p1ShowHandBtn, p2ShowHandBtn,
            dealerIntroduceBtn,showDeckBtn, decideWinnerBtn, dealBtn;
    private JTextArea infoArea;
    private JLabel p1Label, p2Label, dealerLabel;
    private ArrayList<JLabel> deck;
}
