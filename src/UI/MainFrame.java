package UI;

import Human.HeartsDealer;
import Human.HeartsPlayer;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

/**
 * Main frame for the game, where all the visible game objects are located
 *
 * @author Emmanouil Paterakis
 */
public class MainFrame extends JFrame {

    // Constructors
    public MainFrame(HeartsPlayer player1, HeartsPlayer player2, HeartsPlayer player3, HeartsDealer dealer) {
        this(player1, player2, dealer);
        playerNum = 3;
        this.player3 = player3;
        setupP3P4Components();
        player3.setInfoArea(infoArea);
    }

    public MainFrame(HeartsPlayer player1, HeartsPlayer player2, HeartsPlayer player3, HeartsPlayer player4, HeartsDealer dealer) {
        this(player1, player2, player3, dealer);
        playerNum = 4;
        this.player4 = player4;
        setupP3P4Components();
        player4.setInfoArea(infoArea);
    }

    public MainFrame(HeartsPlayer player1, HeartsPlayer player2, HeartsDealer dealer) {
        this.player1 = player1;
        this.player2 = player2;
        this.dealer = dealer;

        initComponents();

        dealer.setDeckPanel(deckPanel);
        dealer.setInfoArea(infoArea);
        player1.setInfoArea(infoArea);
        player2.setInfoArea(infoArea);
    }

    // Custom methods
    private void initComponents() {

        // JScrollPane
        deckScrollPane = new JScrollPane();

        // JTextArea
        infoArea = new JTextArea("Welcome to my game!");
        infoArea.setEditable(false);

        // JButtons
        p1IntroduceBtn = new JButton("Introduce");
        p2IntroduceBtn = new JButton("Introduce");
        p3IntroduceBtn = new JButton("Introduce");
        p4IntroduceBtn = new JButton("Introduce");
        dealerIntroduceBtn = new JButton("Introduce");
        p1ShowHandBtn = new JButton("Show hand");
        p2ShowHandBtn = new JButton("Show hand");
        p3ShowHandBtn = new JButton("Show hand");
        p4ShowHandBtn = new JButton("Show hand");
        dealBtn = new JButton("Deal");
        showDeckBtn = new JButton("Show Deck");
        decideWinnerBtn = new JButton("Decide Winner");

        p1ShowHandBtn.setEnabled(false);
        p2ShowHandBtn.setEnabled(false);
        p3ShowHandBtn.setEnabled(false);
        p4ShowHandBtn.setEnabled(false);
        dealBtn.setEnabled(false);
        decideWinnerBtn.setEnabled(false);

        // Add ActionListeners
        showDeckBtn.addActionListener(e -> doShowDeck());
        p1IntroduceBtn.addActionListener(e -> doIntroducePlayer(1));
        p2IntroduceBtn.addActionListener(e -> doIntroducePlayer(2));
        p3IntroduceBtn.addActionListener(e -> doIntroducePlayer(3));
        p4IntroduceBtn.addActionListener(e -> doIntroducePlayer(4));
        dealerIntroduceBtn.addActionListener(e -> doIntroduceDealer());
        dealBtn.addActionListener(e -> doDeal());
        p1ShowHandBtn.addActionListener(e -> doShowHand(1));
        p2ShowHandBtn.addActionListener(e -> doShowHand(2));
        p3ShowHandBtn.addActionListener(e -> doShowHand(3));
        p4ShowHandBtn.addActionListener(e -> doShowHand(4));
        decideWinnerBtn.addActionListener(e -> doDecideWinner());

        // JLabels
        p1Label = new JLabel("Player 1   |   Points: 0", SwingConstants.CENTER);
        p2Label = new JLabel("Player 2   |   Points: 0", SwingConstants.CENTER);
        p3Label = new JLabel("Player 3   |   Points: 0", SwingConstants.CENTER);
        p4Label = new JLabel("Player 4   |   Points: 0", SwingConstants.CENTER);
        dealerLabel = new JLabel("Dealer", SwingConstants.CENTER);

        // JPanels
        bottomPanel = new JPanel(new BorderLayout());
        gamePanel = new JPanel(new GridLayout(4, 1));
        actionsPanel = new JPanel(new GridLayout(4, 1));
        p1Panel = new JPanel(new GridLayout(2, 1));
        p2Panel = new JPanel(new GridLayout(2, 1));
        p3Panel = new JPanel(new GridLayout(2, 1));
        p4Panel = new JPanel(new GridLayout(2, 1));
        dealerPanel = new JPanel(new GridLayout(2, 1));
        deckPanel = new JPanel(new GridLayout(11, 5));
        p1DeckPanel = new JPanel(new FlowLayout());
        p2DeckPanel = new JPanel(new FlowLayout());
        p3DeckPanel = new JPanel(new FlowLayout());
        p4DeckPanel = new JPanel(new FlowLayout());
        topPlayersPanel = new JPanel(new FlowLayout());
        bottomPlayersPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));

        // Set up JPanels
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

        p3Panel.add(p3Label);
        JPanel p3ButtonsPanel = new JPanel(new FlowLayout());
        p3ButtonsPanel.add(p3IntroduceBtn);
        p3ButtonsPanel.add(p3ShowHandBtn);
        p3Panel.add(p3ButtonsPanel);

        p4Panel.add(p4Label);
        JPanel p4ButtonsPanel = new JPanel(new FlowLayout());
        p4ButtonsPanel.add(p4IntroduceBtn);
        p4ButtonsPanel.add(p4ShowHandBtn);
        p4Panel.add(p4ButtonsPanel);

        dealerPanel.add(dealerLabel);
        JPanel dealerButtonsPanel = new JPanel(new GridLayout(2, 2));
        dealerButtonsPanel.add(dealerIntroduceBtn);
        dealerButtonsPanel.add(showDeckBtn);
        dealerButtonsPanel.add(dealBtn);
        dealerButtonsPanel.add(decideWinnerBtn);
        dealerPanel.add(dealerButtonsPanel);

        // Add players' cards (which are empty at this moment) to their decks
        refreshPlayerDeckPanels();

        // Set deckPanel as the View for scrollPane
        deckScrollPane.setViewportView(deckPanel);

        // Add all the JPanels together
        actionsPanel.add(p1Panel);
        actionsPanel.add(dealerPanel);
        actionsPanel.add(p2Panel);
        topPlayersPanel.add(p1DeckPanel);
        bottomPlayersPanel.add(p2DeckPanel);
        gamePanel.add(topPlayersPanel);
        gamePanel.add(deckScrollPane);
        gamePanel.add(infoArea);
        gamePanel.add(bottomPlayersPanel);
        bottomPanel.add(gamePanel, BorderLayout.CENTER);
        bottomPanel.add(actionsPanel, BorderLayout.WEST);

        add(bottomPanel);

        // JFrame config
        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Hearts Game");
        setVisible(true);
    }

    // Custom methods
    // Introduce dealer action
    private void doIntroduceDealer() {
        dealer.introduceSelf();
        tryEnablingShowDeckButton();
    }

    // Introduce player action
    private void doIntroducePlayer(int playerNumber) {
        if (playerNumber == 1) {
            player1.introduceSelf();
        } else if (playerNumber == 2) {
            player2.introduceSelf();
        } else if (playerNumber == 3) {
            player3.introduceSelf();
        } else if (playerNumber == 4) {
            player4.introduceSelf();
        }
        tryEnablingShowDeckButton();
    }

    // Show deck action
    private void doShowDeck() {
        dealer.showDeck();
        showDeckBtn.setEnabled(false);
        dealBtn.setEnabled(true);
    }

    // Deal action
    private void doDeal() {
        dealer.dealToPlayers(getPlayersArray());
        dealBtn.setEnabled(false);

        p1ShowHandBtn.setEnabled(true);
        p2ShowHandBtn.setEnabled(true);
        if (playerNum >= 3) {
        }
        p3ShowHandBtn.setEnabled(true);
        if (playerNum == 4) {
            p4ShowHandBtn.setEnabled(true);
        }

        refreshPlayerDeckPanels();
    }

    // Show hand action
    private void doShowHand(int playerNumber) {
        if (playerNumber == 1) {
            player1.showHand();
            p1ShowHandBtn.setEnabled(false);
        } else if (playerNumber == 2) {
            player2.showHand();
            p2ShowHandBtn.setEnabled(false);
        } else if (playerNumber == 3) {
            player3.showHand();
            p3ShowHandBtn.setEnabled(false);
        } else if (playerNumber == 4) {
            player4.showHand();
            p4ShowHandBtn.setEnabled(false);
        }
        tryEnablingDecideWinnerButton();
    }

    // Decide winner action
    private void doDecideWinner() {
        dealer.decideWinner(getPlayersArray());

        decideWinnerBtn.setEnabled(false);
        showDeckBtn.setEnabled(true);

        refreshPlayerDeckPanels();

        p1Label.setText("Player 1   |   Points: " + player1.getPoints());
        p2Label.setText("Player 2   |   Points: " + player2.getPoints());
        if (playerNum >= 3) {
            p3Label.setText("Player 3   |   Points: " + player3.getPoints());
        }
        if (playerNum == 4) {
            p4Label.setText("Player 4   |   Points: " + player4.getPoints());
        }
    }

    // Try to enable the "Show Deck" button. All "Introduce" buttons must be pressed.
    private void tryEnablingShowDeckButton() {
        if (!p1IntroduceBtn.isEnabled() && !p2IntroduceBtn.isEnabled() && !dealerIntroduceBtn.isEnabled()) {
            showDeckBtn.setEnabled(true);
        }
    }

    // Try to enable the "Decide Winner" button. All "Show Hand" buttons must be pressed.
    private void tryEnablingDecideWinnerButton() {
        if (!p1ShowHandBtn.isEnabled() && !p2ShowHandBtn.isEnabled()) {
            if (playerNum >= 3) {
                if (!p3ShowHandBtn.isEnabled()) {
                    if (playerNum == 4) {
                        if (!p4ShowHandBtn.isEnabled()) {
                            decideWinnerBtn.setEnabled(true);
                        }
                    } else {
                        decideWinnerBtn.setEnabled(true);
                    }
                }
            } else {
                decideWinnerBtn.setEnabled(true);
            }
        }
    }

    // Refresh the players' deck panels
    private void refreshPlayerDeckPanels() {
        p1DeckPanel.removeAll();
        for (int i = 0; i < player1.getCardsInHand().size(); i++) {
            p1DeckPanel.add(player1.getCardsInHand().get(i));
        }
        p1DeckPanel.revalidate();

        p2DeckPanel.removeAll();
        for (int i = 0; i < player2.getCardsInHand().size(); i++) {
            p2DeckPanel.add(player2.getCardsInHand().get(i));
        }
        p2DeckPanel.revalidate();

        if (playerNum >= 3) {
            p3DeckPanel.removeAll();
            for (int i = 0; i < player3.getCardsInHand().size(); i++) {
                p3DeckPanel.add(player3.getCardsInHand().get(i));
            }
            p3DeckPanel.revalidate();
        }

        if (playerNum == 4) {
            p4DeckPanel.removeAll();
            for (int i = 0; i < player4.getCardsInHand().size(); i++) {
                p4DeckPanel.add(player4.getCardsInHand().get(i));
            }
            p4DeckPanel.revalidate();
        }
    }

    // Add player 2 and 3's components
    private void setupP3P4Components() {
        if (playerNum == 3) {
            deckPanel.setLayout(new GridLayout(5, 11));
            topPlayersPanel.add(new JLabel("<html>|<br/>|<br/></html>"));
            topPlayersPanel.add(p3DeckPanel);
            topPlayersPanel.add(p3Panel);
        }
        if (playerNum == 4) {
            bottomPlayersPanel.add(new JLabel("<html>|<br/>|<br/></html>"));
            bottomPlayersPanel.add(p4DeckPanel);
            bottomPlayersPanel.add(p4Panel);
        }
        refreshPlayerDeckPanels();
        pack();
        setLocationRelativeTo(null);
    }

    // Returns an arraylist of the players
    private ArrayList<HeartsPlayer> getPlayersArray() {
        ArrayList players = new ArrayList<HeartsPlayer>();
        players.add(player1);
        players.add(player2);
        if (playerNum >= 3) {
            players.add(player3);
        }
        if (playerNum == 4) {
            players.add(player4);
        }

        return players;
    }

    // Fields
    private JPanel bottomPanel, actionsPanel, p1Panel, p2Panel, p3Panel, p4Panel, dealerPanel,
            p1DeckPanel, p2DeckPanel, p3DeckPanel, p4DeckPanel, deckPanel, gamePanel,
            bottomPlayersPanel, topPlayersPanel;
    private JButton p1IntroduceBtn, p2IntroduceBtn, p3IntroduceBtn, p4IntroduceBtn,
            p1ShowHandBtn, p2ShowHandBtn, p3ShowHandBtn, p4ShowHandBtn, dealerIntroduceBtn,
            showDeckBtn, decideWinnerBtn, dealBtn;
    private JTextArea infoArea;
    private JScrollPane deckScrollPane;
    private JLabel p1Label, p2Label, p3Label, p4Label, dealerLabel;
    private HeartsDealer dealer;
    private HeartsPlayer player1, player2, player3 = null, player4 = null;
    private int playerNum = 2;
}
