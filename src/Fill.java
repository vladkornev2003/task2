import game_card.Card;
import game_card.NOMINAL;
import game_card.SUIT;

import java.util.*;

public class Fill {

    public static LinkedList<Card> createDeck(){
        LinkedList<Card> deck = new LinkedList<>();
        for (SUIT s :SUIT.values()) {
            for (NOMINAL n: NOMINAL.values()) {
                deck.add(new Card(n,s));
            }
        }
        return deck;
    }
    public static void mixDeck(LinkedList<Card> deck){
        for (int i = 0; i < 100; i++) {
            deck.addFirst(deck.remove(new Random().nextInt(deck.size())));
            deck.addLast(deck.remove(new Random().nextInt(deck.size())));
        }

    }

    public static void addCards(GameData data, List<Card> cards){

        while (!data.getDeck().isEmpty()&&cards.size() < 6){
            cards.add(data.getDeck().pollFirst());
        }
    }

    public static GameData getData(){
        GameData data = new GameData();

        Player p1 = new Player("player1");
        Player p2 = new Player("player2");

        LinkedList<Card> deck =createDeck();
        mixDeck(deck);
        data.setDeck(deck);
        List<Card> l1 = new ArrayList<>();
        addCards(data, l1);
        List<Card> l2 = new ArrayList<>();
        addCards(data, l2);

        Map<Player, List<Card>> pc = new HashMap<>();

        pc.put(p1, l1);
        pc.put(p2, l2);

        LinkedList<Player> players = new LinkedList<>();
        players.add(p1);
        players.add(p2);
        data.setPlayers(players);
        data.setHand(pc);
        data.setTrump(deck.peekLast().getSuit());
        return data;
    }
}
