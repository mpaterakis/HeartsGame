package Human;

import HeartsGame.Card;
import java.util.ArrayList;

/**
 * This interface includes the basic Dealer behavior for the Hearts game
 * 
 * @author Emmanouil Paterakis
 */
public interface CardsDealer {

    // Shows all cards from the deck
    void showDeck();

    // Returns a random card from the deck
    Card dealRandomCard();

    // Deals cards to the players
    void dealToPlayers(ArrayList<HeartsPlayer> players);
    
    // Decides game winner
    void decideWinner(ArrayList<HeartsPlayer> players);
}
