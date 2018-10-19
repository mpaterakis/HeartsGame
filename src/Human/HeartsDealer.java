package Human;

import HeartsGame.Card;
import HeartsGame.Deck;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Emmanouil Paterakis
 */
public class HeartsDealer extends Human implements CardsDealer {

    // Constructors
    public HeartsDealer(String firstName, String lastName, String description, int age) {
        super(firstName, lastName, description, age);
        deck = new Deck();
    }

    public HeartsDealer() {
        deck = new Deck();
    }

    // Overriden classes
    @Override
    public void showDeck() {
        for (int i = 0; i < deck.getCards().size(); i++) {
            deckPanel.add(deck.getCards().get(i));
        }
        deckPanel.revalidate();
        infoArea.setText("-Dealer-\n\nShowing deck.");
    }

    @Override
    public Card dealRandomCard() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void dealToPlayers(HeartsPlayer player1, HeartsPlayer player2) {
        deckPanel.removeAll();
        deckPanel.revalidate();
    }

    @Override
    public void decideWinner(HeartsPlayer player1, HeartsPlayer player2) {
    }

    @Override
    public void introduceSelf() {
        String message = "-Dealer-\n\nHello gents. I'm " + firstName + " " + lastName
                + " and I am " + age + " years old.\n" + description;
        infoArea.setText(message);
    }

    // Getters and setters
    public Deck getDeck() {
        return deck;
    }

    public void setDeck(Deck deck) {
        this.deck = deck;
    }

    public JPanel getDeckPanel() {
        return deckPanel;
    }

    public void setDeckPanel(JPanel deckPanel) {
        this.deckPanel = deckPanel;
    }

    // Fields
    private Deck deck;
    private JPanel deckPanel;
}
