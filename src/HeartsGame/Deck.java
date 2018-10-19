package HeartsGame;

import java.util.ArrayList;

/**
 *
 * @author Emmanouil Paterakis
 */
public class Deck {

    // Constructors
    public Deck(ArrayList<Card> cards) {
        this.cards = cards;
    }

    public Deck() {
        char cardType = ' ';
        String cardNum;
        cards = new ArrayList<Card>();
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 13; j++) {
                switch (i) {
                    case 0:
                        cardType = '$';
                        break;
                    case 1:
                        cardType = '&';
                        break;
                    case 2:
                        cardType = '#';
                        break;
                    case 3:
                        cardType = '%';
                        break;
                    default:
                        break;
                }
                if (j == 0) {
                    cardNum = "A";
                } else if (j > 0 && j < 10) {
                    cardNum = Integer.toString(j+1);
                } else if (j==10) {
                    cardNum = "J";
                } else if (j==11) {
                    cardNum = "Q";
                } else {
                    cardNum = "K";
                }
                cards.add(new Card(cardType,cardNum,false));
            }
        }
    }

    // Getters and setters
    public ArrayList<Card> getCards() {
        return cards;
    }

    public void setCards(ArrayList<Card> cards) {
        this.cards = cards;
    }

    // Fields
    private ArrayList<Card> cards;
}
