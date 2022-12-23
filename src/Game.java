import game_card.Card;
import game_card.NOMINAL;
import show.Show;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Game {

    public static void play(GameData data, Player first){
        System.out.println("Козырь: "+Show.bySuit(new Card(NOMINAL.ACE, data.getTrump())));
        Player tmp = first;
        int count = 100;

        while (count != 0){
            System.out.println("___________________________________________");
            System.out.println("Размер колоды: "+data.getDeck().size());
            boolean checker = true;
            List<Card> table = new ArrayList<>();
            List<Card> striker = data.getHand().get(tmp);

            if(striker.isEmpty()||striker.size() == 1){
                System.out.println(tmp.getNickname()+" победил");
                return;
            }
            Player enemy = getEnemy(tmp, data);
            List<Card> beating = data.getHand().get(getEnemy(tmp, data));
            if(beating.isEmpty()){
                System.out.println(enemy.getNickname()+" победил");
                return;
            }
            while (table.size() <= 10) {
                System.out.println();
                System.out.println("Нападающий: "+ tmp.getNickname());
                Show.showHand(striker);
                System.out.println("Отбивающийся: "+enemy.getNickname());
                Show.showHand(beating);
                System.out.println();

                List<Card> optStriker = GameService.getOptionsThrow(striker, table);

                if(optStriker.isEmpty()) {
                    System.out.println("подкинуть нечего");
                    break;
                }
                Card card = optStriker.get(new Random().nextInt(optStriker.size()));
                System.out.println("Нужно отбить: "+Show.getCard(card));
                table.add(card);
                striker.remove(card);
                List<Card> optBeating = GameService.getOptionsFight(data, beating, card);
                if(optBeating.size() == 0){
                    System.out.println("Биться нечем, беру карты");
                    beating.addAll(table);
                    checker = false;
                    break;
                }else {
                    Card c = optBeating.get(new Random().nextInt(optBeating.size()));
                    System.out.println("Отбиваюсь: " + Show.getCard(c));
                    table.add(c);
                    striker.remove(c);
                }

            }
            Fill.addCards(data, striker);
            data.getHand().replace(tmp, striker);
            Fill.addCards(data, beating);
            data.getHand().replace(enemy, beating);
            if (checker)
                tmp = enemy;
            System.out.println();
            count--;
        }
    }

    private static Player getEnemy(Player p, GameData d){
        for (Player e:d.getPlayers()) {
            if(!e.equals(p))
                return e;
        }
        return null;
    }

}
