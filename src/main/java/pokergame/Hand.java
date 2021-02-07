package pokergame;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public abstract class Hand
{
    private String playerId;
    private List<Card> cards;

    public String getPlayerId()
    {
        return playerId;
    }

    public void setPlayerId(String playerId)
    {
        this.playerId = playerId;
    }

    public List<Card> getCards()
    {
        return cards;
    }

    public void setCards(List<Card> cards)
    {
        this.cards = cards;
    }

    public int getCardCount()
    {
        return cards.size();
    }

    public abstract Card getHighCard();

    protected boolean isPair()
    {
        return hasMatchingCard(2);
    }

    protected boolean isThreeOfAKind()
    {
        return hasMatchingCard(3);
    }

    protected boolean isFourOfAKind()
    {
        throw new UnsupportedOperationException("Coming soon when 5 card poker game is trendy again!");
    }

    protected boolean isStraight()
    {
        double lowCard = Collections.min(cards).getValue();
        double hightCard = Collections.max(cards).getValue();
        double expectedSumIfConsecutive = cards.size() * (lowCard / 2 + hightCard / 2);
        return cards.stream().mapToInt(Card::getValue).distinct().sum() == expectedSumIfConsecutive;
    }

    protected boolean isFlush()
    {
        return cards.stream()
            .collect(Collectors.groupingBy(Card::getSuit)).size() == 1;
    }

    protected boolean isStraightFlush()
    {
        return isStraight() && isFlush();
    }

    protected boolean isRoyalFlush()
    {
        throw new UnsupportedOperationException("Coming soon when 5 card poker game is trendy again!");
    }

    protected boolean isFullHouse()
    {
        throw new UnsupportedOperationException("Coming soon when 5 card poker game is trendy again!");
    }

    protected boolean hasMatchingCard(final int matchThreshold)
    {
        return getMatchingCards(matchThreshold).size() > 0;
    }

    protected List<Card> getMatchingCards(final int matchThreshold)
        throws IllegalArgumentException
    {
        if(matchThreshold > 1) {
            return cards.stream()
                .filter(x -> Collections.frequency(cards, x) == matchThreshold)
                .collect(Collectors.toList());
        }
        throw new IllegalArgumentException("Match threshold of 1 or lower not supported");
    }
}
