package pokergame;

import java.util.Optional;
import java.util.stream.Stream;

public enum Suit
{
    DIAMOND('D'),
    CLUB('C'),
    HEART('H'),
    SPADE('S');

    private Character oneCharKey;

    Suit(Character oneCharKey)
    {
        this.oneCharKey = oneCharKey;
    }

    public Character getOneCharKey()
    {
        return oneCharKey;
    }

    public static Optional<Suit> fromOneCharKey(Character oneCharKey)
    {
        return Stream.of(Suit.values())
            .filter(entry -> entry.getOneCharKey() == Character.toUpperCase(oneCharKey))
            .findFirst();
    }
}
