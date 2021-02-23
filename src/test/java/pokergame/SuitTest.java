package pokergame;

import org.junit.Assert;
import org.junit.Test;

import java.util.stream.Stream;

public class SuitTest
{
    @Test
    public void giveUpperCaseStringRepresentationExpectSuit()
    {
        Assert.assertTrue(Suit.DIAMOND == Suit.fromOneCharKey('D').get());
        Assert.assertTrue(Suit.CLUB == Suit.fromOneCharKey('C').get());
        Assert.assertTrue(Suit.HEART == Suit.fromOneCharKey('H').get());
        Assert.assertTrue(Suit.SPADE == Suit.fromOneCharKey('S').get());
    }

    @Test
    public void giveLowerCaseStringRepresentationExpectSuit()
    {
        Assert.assertTrue(Suit.DIAMOND == Suit.fromOneCharKey('d').get());
        Assert.assertTrue(Suit.CLUB == Suit.fromOneCharKey('c').get());
        Assert.assertTrue(Suit.HEART == Suit.fromOneCharKey('h').get());
        Assert.assertTrue(Suit.SPADE == Suit.fromOneCharKey('s').get());

    }
}
