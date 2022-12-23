package game_card;

public class Card {
    private NOMINAL nominal;
    private SUIT suit;

    public Card(NOMINAL nominal, SUIT suit) {
        this.nominal = nominal;
        this.suit = suit;
    }

    public NOMINAL getNominal() {
        return nominal;
    }

    public SUIT getSuit() {
        return suit;
    }
}
