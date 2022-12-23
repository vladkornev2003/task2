package show;

import game_card.Card;
import game_card.SUIT;

import java.util.List;

public class Show {
    public static String getCard(Card c){

        return byNominal(c)+bySuit(c);
    }

    public static String byNominal(Card c){
        String s = "";
        if(c.getNominal().val <= 10)
            s+=c.getNominal().val;
        else {
            if(c.getNominal().val == 11){
                s+="В";
            }else if(c.getNominal().val == 12){
                s+="Д";
            }
            else if(c.getNominal().val == 13){
                s+="К";
            }else if(c.getNominal().val == 14){
                s+="Т";
            }
        }
        return s;
    }

    public static String bySuit(Card c){
        String s = "";
        if (c.getSuit() == SUIT.PEAKS){
            s+=" пики";
        }else if(c.getSuit() == SUIT.DIAMONDS) {
            s+= " бубны";
        } else if (c.getSuit() == SUIT.CLUBS) {
            s+=" треф";
        } else if (c.getSuit() == SUIT.HEARTS) {
            s+= " черви";
        }
        return s;
    }

    public static void showHand(List<Card> hand){
        for (Card c:hand) {
            System.out.print(getCard(c)+", ");
        }
        System.out.println();
    }
}
