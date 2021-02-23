package pokergame;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ThreeCardHand
    extends Hand
    implements Comparable
{
    private ThreeCardHandType handType;

    public ThreeCardHand(final String playerId, final List<Card> cards)
        throws IllegalArgumentException
    {
        if (playerId == null || playerId.isEmpty())
        {
            throw new IllegalArgumentException("A player must have an identifier");
        }
        if (cards == null || cards.size() != 3)
        {
            throw new IllegalArgumentException("A playing hand must contain 3 cards, dah!");
        }

        setPlayerId(playerId);
        setCards(cards);
        this.handType = ascertainHandType();
    }

    public ThreeCardHand(final String playerId, Card... cards)
    {
        this(playerId, Arrays.asList(cards));
    }

    public Card getHighCard()
        throws IllegalArgumentException
    {
        switch (handType) {
        case MIXED_BAG:
        case STRAIGHT:
        case FLUSH:
        case STRAIGHT_FLUSH:
            return getCards().stream().max(Comparator.comparing(Card::getFaceValue)).get();
        case ONE_PAIR:
            return getMatchingCards(2).get(0);
        case THREE_OF_A_KIND:
            return getMatchingCards(3).get(0);
        }
        throw new IllegalArgumentException("Unexpected ThreeCardHandType object encountered");
    }

    @Override
    public int compareTo(Object anotherHand)
    {
        if (anotherHand instanceof ThreeCardHand)
        {
            int result = handType.compareTo(((ThreeCardHand) anotherHand).handType);
            if (result == 0)
            {
                return this.getHighCard().getFaceValue().compareTo(((ThreeCardHand) anotherHand).getHighCard().getFaceValue());
            }
            return result;
        }
        throw new IllegalArgumentException("You are playing with a mixed deck of cards");
    }

    protected ThreeCardHandType ascertainHandType()
    {
        if (isStraightFlush()) return ThreeCardHandType.STRAIGHT_FLUSH;
        if (isFlush()) return ThreeCardHandType.FLUSH;
        if (isStraight()) return ThreeCardHandType.STRAIGHT;
        if (isThreeOfAKind()) return ThreeCardHandType.THREE_OF_A_KIND;
        if (isPair()) return ThreeCardHandType.ONE_PAIR;
        return  ThreeCardHandType.MIXED_BAG;
    }
}
