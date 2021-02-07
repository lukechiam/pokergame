package pokergame;

public class Card
    implements Comparable<Card>
{
    private final String VALID_NUMBERS = "23456789TJQKA";
    private final String VALID_SUITS = "DCHS";
    private String twoCharStr;
    private int value;
    private String suit;

    public Card(final String twoCharStr)
        throws IllegalArgumentException
    {
        this.twoCharStr = twoCharStr;

        // Make sure we get 2 characters to represent a card
        if (twoCharStr == null || twoCharStr.length() != 2)
        {
            throw new IllegalArgumentException("Unexpected type of card found");
        }

        // Make sure the card's number is in the declared VALID_NUMBERS constant
        this.value = VALID_NUMBERS.indexOf(twoCharStr.charAt(0));
        if (this.value == -1)
        {
            throw new IllegalArgumentException("Unexpected number found on card");
        }

        // Make sure the card's suit is in the declared VALID_SUITS constant
        try
        {
            this.suit = VALID_SUITS.charAt(VALID_SUITS.indexOf(Character.toUpperCase(twoCharStr.charAt(1)))) + "";
        }
        catch (StringIndexOutOfBoundsException e)
        {
            throw new IllegalArgumentException("Unexpected suit found on card");
        }
    }

    public int getValue()
    {
        return value;
    }

    public String getSuit()
    {
        return suit;
    }

    public boolean isPair(final Card anotherCard)
    {
        return this.value == anotherCard.value;
    }

    public boolean isHigher(final Card anotherCard)
    {
        return compareTo(anotherCard) > 0;
    }

    @Override
    public int compareTo(final Card anotherCard)
    {
        return this.value - anotherCard.value;
    }

    @Override
    public String toString()
    {
        return twoCharStr;
    }

    @Override
    public int hashCode()
    {
        return super.hashCode();
    }

    @Override
    public boolean equals(final Object anotherObj)
    {
        return anotherObj instanceof Card
            && this.getValue() == ((Card) anotherObj).getValue();
    }
}
