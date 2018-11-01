package Human;

import HeartsGame.Card;
import HeartsGame.Deck;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.JPanel;

/**
 * This class represents the Dealer for the Hearts game
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
    // Show all cards from the deck
    @Override
    public void showDeck() {
        for (int i = 0; i < deck.getCards().size(); i++) {
            deckPanel.add(deck.getCards().get(i));
        }
        deckPanel.revalidate();
        infoArea.setText("-Dealer-\n\nShowing deck.");
    }

    // Deal (return) a random card
    @Override
    public Card dealRandomCard() {
        // Get random card
        int x = (int) (Math.random() * deck.getCards().size());
        Card dealtCard = deck.getCards().get(x);
        dealtCard.flipCard();

        // Remove card from deck
        deck.getCards().remove(x);

        return dealtCard;
    }

    // Deal cards to players
    @Override
    public void dealToPlayers(ArrayList<HeartsPlayer> players) {
        // Clean deckPanel
        deckPanel.removeAll();
        deckPanel.revalidate();

        // Update message
        infoArea.setText("-Dealer-\n\nDealing cards...");

        // Get random card and make sure it's not in the players' hand
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < players.size(); j++) {
                // Player gets one card
                Card dealtCard = dealRandomCard();
                players.get(j).getCardsInHand().remove(0);
                players.get(j).getCardsInHand().add(dealtCard);
            }

        }
    }

    // Decide and announce the winner
    @Override
    public void decideWinner(ArrayList<HeartsPlayer> players) {
        // Hearts counter for each player
        ArrayList hearts = new ArrayList<>();

        // Add the players' cards back to the dealer's deck and counting hearts for each
        for (int i = 0; i < players.size(); i++) {
            hearts.add(0);
            for (int j = 0; j < 5; j++) {
                deck.getCards().add(players.get(i).getCardsInHand().get(j));
                if (players.get(i).getCardsInHand().get(j).getSymbol() == '#') {
                    hearts.set(i, Integer.valueOf(hearts.get(i).toString()) + 1);
                }
            }
        }

        // Decide the winner, update the message and add points
        infoArea.setText("-Dealer-\n\nCounting Points:");

        int maxHearts = Integer.valueOf(Collections.max(hearts).toString());
        int pointsWon = maxHearts * 10;

        for (int i = 0; i < players.size(); i++) {
            if (hearts.get(i).equals(maxHearts)) {
                infoArea.setText(infoArea.getText() + "\n\nPlayer " + (i + 1) + " got " + pointsWon + " points!");
                players.get(i).setPoints(players.get(i).getPoints() + pointsWon);
            }
            players.get(i).initHand();
        }
    }

    // Show introductory message with dealer's info
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
