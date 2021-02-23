package pokergame;

public class Card
    implements Comparable<Card>
{
    private String twoCharStr;
    private FaceValue faceValue;
    private Suit suit;

    public Card(final String twoCharStr)
        throws IllegalArgumentException
    {
        this.twoCharStr = twoCharStr;

        // Make sure we get 2 characters to represent a card
        if (twoCharStr == null || twoCharStr.length() != 2)
        {
            throw new IllegalArgumentException("Unexpected type of card found");
        }

        this.faceValue = FaceValue.fromOneCharKey(twoCharStr.charAt(0)).orElseThrow(() -> new IllegalArgumentException("Unexpected face value (" + twoCharStr.charAt(0)  + ") found on card"));
        this.suit = Suit.fromOneCharKey(twoCharStr.charAt(1)).orElseThrow(() -> new IllegalArgumentException("Unexpected suit (" + twoCharStr.charAt(1) + ") found on card"));
    }

    public FaceValue getFaceValue()
    {
        return faceValue;
    }

    public Suit getSuit()
    {
        return suit;
    }

    public boolean isPair(final Card anotherCard)
    {
        return this.faceValue == anotherCard.faceValue;
    }

    public boolean isHigher(final Card anotherCard)
    {
        return compareTo(anotherCard) > 0;
    }

    @Override
    public int compareTo(final Card anotherCard)
    {
        return this.faceValue.compareTo(anotherCard.faceValue);
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
            && this.faceValue == ((Card) anotherObj).faceValue;
    }
}
