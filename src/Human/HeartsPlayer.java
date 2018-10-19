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
    @Override
    public void showHand() {
    }

    @Override
    public void introduceSelf() {
        String message = "-Player " + playerNumber + "-\n\nHi! I'm " + firstName
                + " " + lastName + " and I am " + age + " years old.\n" + description;
        infoArea.setText(message);
    }

    private void initHand() {
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

    // Fields
    private ArrayList<Card> cardsInHand;
    private int playerNumber;

}
