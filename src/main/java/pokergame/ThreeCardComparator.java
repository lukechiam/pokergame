package pokergame;

import java.util.Comparator;

public class ThreeCardComparator
    implements Comparator<ThreeCardHand>
{

    @Override
    public int compare(ThreeCardHand o1, ThreeCardHand o2)
    {
        int result = o1.getRankValue() - o2.getRankValue();
        if (result == 0)
        {
            return o1.getHighCard().getValue() - o2.getHighCard().getValue();
        }
        return result;
    }
}
