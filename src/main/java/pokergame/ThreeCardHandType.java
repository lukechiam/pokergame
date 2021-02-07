package pokergame;

public enum ThreeCardHandType
{
    MIXED_BAG(1),
    ONE_PAIR(2),
    STRAIGHT(3),
    FLUSH(4),
    THREE_OF_A_KIND(5),
    STRAIGHT_FLUSH(6);

    int rankValue;

    ThreeCardHandType(int rankValue) {
        this.rankValue = rankValue;
    }

    public int getRankValue()
    {
        return rankValue;
    }
}
