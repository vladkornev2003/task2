import game_card.Card;
import game_card.SUIT;

import java.util.ArrayList;
import java.util.List;

public class GameService {

    public static List<Card> getOptionsFight(GameData data, List<Card> hand, Card card){

        SUIT trump = data.getTrump();
        List<Card> opt = new ArrayList<>();

        for (Card c:hand) {
            if(c.getSuit() == card.getSuit() && c.getNominal().val > card.getNominal().val){
                opt.add(c);
                continue;
            }
            if(card.getSuit() != trump && card.getSuit() == trump){
                opt.add(c);
            }
        }

        return opt;
    }

    public static List<Card> getOptionsThrow(List<Card> hand, List<Card> table){

        if(table.isEmpty())
            return hand;

        List<Card> opt = new ArrayList<>();
        for (Card c:hand) {
            for (Card o:opt) {
                if(c.getNominal() == o.getNominal()) {
                    opt.add(c);
                    continue;
                }
            }
        }
        return opt;
    }
}
