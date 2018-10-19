package Human;

import HeartsGame.Card;
import HeartsGame.Deck;
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
    public void dealToPlayers(HeartsPlayer player1, HeartsPlayer player2) {
        // Clean deckPanel
        deckPanel.removeAll();
        deckPanel.revalidate();

        // Update message
        infoArea.setText("-Dealer-\n\nDealing cards...");

        // Get random card and make sure it's not in the players' hand
        for (int i = 0; i < 5; i++) {
            // Player 1 gets one card
            Card dealtCard = dealRandomCard();
            player1.getCardsInHand().remove(0);
            player1.getCardsInHand().add(dealtCard);

            // Player 2 gets another card
            dealtCard = dealRandomCard();
            player2.getCardsInHand().remove(0);
            player2.getCardsInHand().add(dealtCard);
        }
    }

    // Decide and announce the winner
    @Override
    public void decideWinner(HeartsPlayer player1, HeartsPlayer player2) {
        // Hearts counter for each player
        int p1Hearts = 0, p2Hearts = 0;

        // Add the players' cards back to the dealer's deck
        for (int i = 0; i < 5; i++) {
            deck.getCards().add(player1.getCardsInHand().get(i));
            deck.getCards().add(player2.getCardsInHand().get(i));

            if (player1.getCardsInHand().get(i).getSymbol() == '#') {
                p1Hearts++;
            }
            if (player2.getCardsInHand().get(i).getSymbol() == '#') {
                p2Hearts++;
            }
        }

        // Decide the winner, update the message and add points
        if (p1Hearts == p2Hearts) {
            infoArea.setText("-Dealer-\n\nDraw!");
        } else if (p1Hearts < p2Hearts) {
            // Calculate points for the winner
            int points = (p2Hearts - p1Hearts) * 10;
            infoArea.setText("-Dealer-\n\nPlayer 2 wins! They get " + points + " points!");
            player2.setPoints(points + player2.getPoints());
        } else {
            int points = (p1Hearts - p2Hearts) * 10 + player1.getPoints();
            infoArea.setText("-Dealer-\n\nPlayer 1 wins! They get " + points + " points!");
            player1.setPoints(points + player1.getPoints());
        }

        // Reset player's hands
        player1.initHand();
        player2.initHand();
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
