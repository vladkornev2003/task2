package game_card;

import java.util.Arrays;

public enum NOMINAL {
    SIX(6),
    SEVEN(7),
    EIGHT(8),
    NINE(9),
    TEN(10),
    JACK(11),
    QUEEN(12),
    KING(13),
    ACE(14);

    NOMINAL(int val) {
        this.val = val;
    }

    public int val;

    public static NOMINAL value(int val) {
        return Arrays.stream(values())
                .filter(it -> it.val == val)
                .findFirst()
                .orElseThrow();
    }

}
