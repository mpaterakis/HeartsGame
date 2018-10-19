package HeartsGame;

import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author Emmanouil Paterakis
 */
public class Card extends JLabel {

    // Constructors
    public Card(char symbol, String number, boolean cardHidden) {
        try {
            this.symbol = symbol;
            this.number = number;
            this.cardHidden = cardHidden;
            
            // Set card icon
            InputStream stream;
            if (cardHidden) {
                stream = getClass().getResourceAsStream("/Icons/backview.png");
            } else {
                stream = getClass().getResourceAsStream("/Icons/"
                        + symbol + number + ".png");
            }
            cardIcon = new ImageIcon(ImageIO.read(stream));
            setIcon(new ImageIcon(cardIcon.getImage()));
        } catch (IOException ex) {
            Logger.getLogger(Card.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Card() {
        try {
            number = " ";
            symbol = ' ';
            InputStream stream = getClass().getResourceAsStream("/Icons/empty.png");
            cardIcon = new ImageIcon(ImageIO.read(stream));
            setIcon(new ImageIcon(cardIcon.getImage()));
        } catch (IOException ex) {
            Logger.getLogger(Card.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    // Custom method
    public void flipCard() {
        try {
            cardHidden = !cardHidden;
            
            // Set card icon
            InputStream stream;
            if (cardHidden) {
                stream = getClass().getResourceAsStream("/Icons/backview.png");
            } else {
                stream = getClass().getResourceAsStream("/Icons/"
                        + symbol + number + ".png");
            }
            cardIcon = new ImageIcon(ImageIO.read(stream));
            setIcon(new ImageIcon(cardIcon.getImage()));
            
        } catch (IOException ex) {
            Logger.getLogger(Card.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Getter
    public char getSymbol() {
        return symbol;
    }

    // Fields
    private ImageIcon cardIcon;
    private String number;
    private char symbol;
    private boolean cardHidden;
}
