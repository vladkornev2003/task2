import game_card.Card;
import game_card.NOMINAL;
import show.Show;

import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        GameData data = Fill.getData();
        Game.play(data, data.getPlayers().get(0));

    }
}
