package Human;

import HeartsGame.Card;

/**
 *
 * @author Emmanouil Paterakis
 */
public interface CardsDealer {

    // Shows all cards from the deck
    void showDeck();

    // Returns a random card from the deck
    Card dealRandomCard();

    // Deals cards to the players
    void dealToPlayers(HeartsPlayer player1, HeartsPlayer player2);
    
    // Decides game winner
    void decideWinner(HeartsPlayer player1, HeartsPlayer player2);
}