package Human;

import HeartsGame.Card;
import javax.swing.JTextField;

/**
 *
 * @author Emmanouil Paterakis
 */
public class HeartsDealer extends Human implements CardsDealer {

    // Constructors
    public HeartsDealer(Card[] deck, String firstName, String lastName, String description, int age, JTextField infoTf) {
        super(firstName, lastName, description, age, infoTf);
    }

    // Overriden classes
    @Override
    public void showDeck() {
    }

    @Override
    public Card dealRandomCard() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void dealToPlayers(HeartsPlayer player1, HeartsPlayer player2) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void decideWinner(HeartsPlayer player1, HeartsPlayer player2) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
