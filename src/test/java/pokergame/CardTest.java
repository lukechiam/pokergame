package pokergame;

import org.junit.Assert;
import org.junit.Test;

public class CardTest
{
    @Test
    public void givenSameValueRegardlessOfSuitExpectToBeEqual()
    {
        Assert.assertEquals(new Card("Tc"), new Card("Ts"));
    }

    @Test
    public void givenSameValueAndSuitExpectToBeEqual()
    {
        Assert.assertEquals(new Card("5s"), new Card("5s"));
    }

    @Test
    public void givenSameNumberRegardlessOfSuitExpectToBePair()
    {
        final Card[][] cards = new Card[][] {
            { new Card("As"), new Card("Ad") },
            { new Card("Kd"), new Card("Kc") },
            { new Card("Qc"), new Card("Qh") },
            { new Card("Jh"), new Card("Jc") },
            { new Card("Tc"), new Card("Ts") },
            { new Card("9s"), new Card("9s") },
            { new Card("8s"), new Card("8c") },
            { new Card("7c"), new Card("7d") },
            { new Card("6d"), new Card("6s") },
            { new Card("5s"), new Card("5d") },
            { new Card("4d"), new Card("4h") },
            { new Card("3h"), new Card("3c") },
            { new Card("2c"), new Card("2c") }
        };
        for (Card[] card : cards)
        {
            Assert.assertTrue(card[0] + " and " + card[1] + " should be a pair", card[0].isPair(card[1]));
        }
    }

    @Test
    public void givenHigherNumberRegardlessOfSuitExpectToBeHigher()
    {
        final Card[][] cards = new Card[][] {
            { new Card("As"), new Card("Kd") },
            { new Card("Kd"), new Card("Qc") },
            { new Card("Qc"), new Card("Jh") },
            { new Card("Jh"), new Card("Tc") },
            { new Card("Tc"), new Card("9s") },
            { new Card("9s"), new Card("8s") },
            { new Card("8s"), new Card("7c") },
            { new Card("7c"), new Card("6d") },
            { new Card("6d"), new Card("5s") },
            { new Card("5s"), new Card("4d") },
            { new Card("4d"), new Card("3h") },
            { new Card("3h"), new Card("2c") }
        };
        for (Card[] card : cards)
        {
            Assert.assertTrue(card[0] + " should be higher then " + card[1], card[0].isHigher(card[1]));
        }
    }

    @Test
    public void givenSameNumberRegardlessOfSuitExpectToNotBeHigher()
    {
        final Card[][] cards = new Card[][] {
            { new Card("As"), new Card("Ad") },
            { new Card("Kd"), new Card("Kc") },
            { new Card("Qc"), new Card("Qh") },
            { new Card("Jh"), new Card("Jc") },
            { new Card("Tc"), new Card("Ts") },
            { new Card("9s"), new Card("9s") },
            { new Card("8s"), new Card("8c") },
            { new Card("7c"), new Card("7d") },
            { new Card("6d"), new Card("6s") },
            { new Card("5s"), new Card("5d") },
            { new Card("4d"), new Card("4h") },
            { new Card("3h"), new Card("3c") },
            { new Card("2c"), new Card("2c") }
        };
        for (Card[] card : cards)
        {
            Assert.assertFalse(card[0] + " should not be higher then " + card[1], card[0].isHigher(card[1]));
        }
    }

    @Test
    public void givenLowerNumberRegardlessOfSuitExpectToNotBeHigher()
    {
        final Card[][] cards = new Card[][] {
            { new Card("Ks"), new Card("Ad") },
            { new Card("Qd"), new Card("Kc") },
            { new Card("Jc"), new Card("Qh") },
            { new Card("Th"), new Card("Jc") },
            { new Card("9c"), new Card("Ts") },
            { new Card("8s"), new Card("9s") },
            { new Card("7s"), new Card("8c") },
            { new Card("6c"), new Card("7d") },
            { new Card("5d"), new Card("6s") },
            { new Card("4s"), new Card("5d") },
            { new Card("3d"), new Card("4h") },
            { new Card("2h"), new Card("3c") }
        };
        for (Card[] card : cards)
        {
            Assert.assertFalse(card[0] + " should not be higher then " + card[1], card[0].isHigher(card[1]));
        }
    }
}
