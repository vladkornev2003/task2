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
                s+="�";
            }else if(c.getNominal().val == 12){
                s+="�";
            }
            else if(c.getNominal().val == 13){
                s+="�";
            }else if(c.getNominal().val == 14){
                s+="�";
            }
        }
        return s;
    }

    public static String bySuit(Card c){
        String s = "";
        if (c.getSuit() == SUIT.PEAKS){
            s+=" ����";
        }else if(c.getSuit() == SUIT.DIAMONDS) {
            s+= " �����";
        } else if (c.getSuit() == SUIT.CLUBS) {
            s+=" ����";
        } else if (c.getSuit() == SUIT.HEARTS) {
            s+= " �����";
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
