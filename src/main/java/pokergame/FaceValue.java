package pokergame;

import java.util.Optional;
import java.util.stream.Stream;

public enum FaceValue
{
    TWO('2'),
    THREE('3'),
    FOUR('4'),
    FIVE('5'),
    SIX('6'),
    SEVEN('7'),
    EIGHT('8'),
    NINE('9'),
    TEN('T'),
    JACK('J'),
    QUEEN('Q'),
    KING('K'),
    ACE('A');

    private Character oneCharKey;
    
    FaceValue(Character oneCharKey)
    {
        this.oneCharKey = oneCharKey;
    }

    public Character getOneCharKey()
    {
        return oneCharKey;
    }
    
    public static Optional<FaceValue> fromOneCharKey(Character oneCharKey)
    {
        return Stream.of(FaceValue.values())
            .filter(entry -> entry.getOneCharKey() == Character.toUpperCase(oneCharKey))
            .findFirst();
    }

}
