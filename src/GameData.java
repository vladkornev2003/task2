import game_card.Card;
import game_card.SUIT;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class GameData {

    private LinkedList<Card> deck;

    private LinkedList<Player> players;

    private Map<Player, List<Card>> hand;

    private SUIT trump;

    public GameData(LinkedList<Card> deck, LinkedList<Player> players, Map<Player, List<Card>> hand, SUIT trump) {
        this.deck = deck;
        this.players = players;
        this.hand = hand;
        this.trump = trump;
    }

    public GameData() {

    }

    public SUIT getTrump() {
        return trump;
    }

    public void setTrump(SUIT trump) {
        this.trump = trump;
    }

    public LinkedList<Card> getDeck() {
        return deck;
    }

    public void setDeck(LinkedList<Card> deck) {
        this.deck = deck;
    }

    public LinkedList<Player> getPlayers() {
        return players;
    }

    public void setPlayers(LinkedList<Player> players) {
        this.players = players;
    }

    public Map<Player, List<Card>> getHand() {
        return hand;
    }

    public void setHand(Map<Player, List<Card>> hand) {
        this.hand = hand;
    }
}
