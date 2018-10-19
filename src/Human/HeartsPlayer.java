package Human;

import HeartsGame.Card;
import java.util.ArrayList;

/**
 *
 * @author Emmanouil Paterakis
 */
public class HeartsPlayer extends Human implements CardsPlayer {

    // Constructors
    public HeartsPlayer(String firstName, String lastName, String description, int age, int playerNumber) {
        super(firstName, lastName, description, age);
        this.playerNumber = playerNumber;
        initHand();
    }

    public HeartsPlayer() {
        super();
        initHand();
    }

    // Custom methods
    // Shows the cards that the player has on their hand    
    @Override
    public void showHand() {
        // Flip cards
        int heartsNum = 0;
        for (int i = 0; i < cardsInHand.size(); i++) {
            cardsInHand.get(i).flipCard();
            if (cardsInHand.get(i).getSymbol() == '#'){
                heartsNum++;
            }
        }
        
        // Update message
        infoArea.setText("-Player " + playerNumber + "-\n\nShowing hand...\n\n"
                + "Player " + playerNumber + " has " + heartsNum + " Hearts.");
    }

    // Show introductory message with player's info
    @Override
    public void introduceSelf() {
        String message = "-Player " + playerNumber + "-\n\nHi! I'm " + firstName
                + " " + lastName + " and I am " + age + " years old.\n" + description;
        infoArea.setText(message);
    }

    // Initialize hand (player's deck) at the start of each game
    public void initHand() {
        cardsInHand = new ArrayList<Card>();
        for (int i = 0; i < 5; i++) {
            cardsInHand.add(new Card());
        }
    }

    // Getters and setters
    public ArrayList<Card> getCardsInHand() {
        return cardsInHand;
    }

    public void setCardsInHand(ArrayList<Card> cardsInHand) {
        this.cardsInHand = cardsInHand;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    // Fields
    private ArrayList<Card> cardsInHand;
    private int playerNumber, points = 0;

}
