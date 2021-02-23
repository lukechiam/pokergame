package pokergame;

import junit.framework.Assert;
import org.junit.Test;

public class ThreeCardHandTest
{
    // test constructor

    @Test(expected = IllegalArgumentException.class)
    public void givenOneCardExpectException()
    {
        final Hand pokerHand = new ThreeCardHand("ANY", new Card("5s"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void givenTwoCardsExpectException()
    {
        final Hand pokerHand = new ThreeCardHand("ANY", new Card("5s"), new Card("Ah"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void givenFourCardsExpectException()
    {
        final Hand pokerHand = new ThreeCardHand("ANY", new Card("5s"), new Card("Ah"), new Card("3d"), new Card("Jh"));
    }

    @Test
    public void givenThreeCardExpectToBeOk()
    {
        new ThreeCardHand("ANY", new Card("5s"), new Card("5d"), new Card("Tc"));
    }

    // Test getMatchingCards()

    @Test
    public void givenMatchThresholdOf2ExpectResultCountToMatch()
    {
        final Hand pokerHand = new ThreeCardHand("ANY", new Card("9s"), new Card("9s"), new Card("Ks"));
        Assert.assertEquals(2, pokerHand.getMatchingCards(2).size());
    }

    // Test isStraightFlush()

    @Test
    public void givenNonConsecutiveCardsWithSameSuitExpectNoStraightFlushes()
    {
        final Hand pokerHand = new ThreeCardHand("ANY", new Card("9s"), new Card("Ts"), new Card("Ks"));
        Assert.assertFalse(pokerHand.isStraightFlush());
    }

    @Test
    public void given3ConsecutiveCardsWithVariousSuitsExpectNoStraightFlushes()
    {
        final Hand pokerHand = new ThreeCardHand("ANY", new Card("Js"), new Card("Qh"), new Card("Kh"));
        Assert.assertFalse(pokerHand.isStraightFlush());
    }

    @Test
    public void given3ConsecutiveCardsWithSameSuitExpectStraightFlush()
    {
        final Hand pokerHand = new ThreeCardHand("ANY", new Card("Js"), new Card("Qs"), new Card("Ks"));
        Assert.assertTrue(pokerHand.isStraightFlush());
    }

    // Test isFlush()

    @Test
    public void givenCardsWithVariousSuitsExpectNoFlushs()
    {
        final Hand pokerHand = new ThreeCardHand("ANY", new Card("Js"), new Card("Ad"), new Card("4d"));
        Assert.assertFalse(pokerHand.isFlush());

    }

    @Test
    public void given3CardsWithSameSuitExpectFlush()
    {
        final Hand pokerHand = new ThreeCardHand("ANY", new Card("2c"), new Card("4c"), new Card("5c"));
        Assert.assertTrue(pokerHand.isFlush());

    }

    // Test isStraight()

    @Test
    public void given3NonConsecutiveCardsExpectNoStraights()
    {
        final Hand pokerHand = new ThreeCardHand("ANY", new Card("2c"), new Card("4h"), new Card("5c"));
        Assert.assertFalse(pokerHand.isStraight());
    }

    @Test
    public void given3ConsecutiveCardsExpectStraight()
    {
        final Hand pokerHand = new ThreeCardHand("ANY", new Card("Qd"), new Card("Kh"), new Card("Ac"));
        Assert.assertTrue(pokerHand.isStraight());
    }

    @Test
    public void givenUnoredered3ConsecutiveCardsExpectStraight()
    {
        final Hand pokerHand = new ThreeCardHand("ANY", new Card("Jd"), new Card("9s"), new Card("Tc"));
        Assert.assertTrue(pokerHand.isStraight());
    }

    // Test hasMatchingCard() which also test isPair(), isThreeOfAKind() and isFourOfAKind()

    @Test
    public void givenNoEqualValueCardsExpectNotPair()
    {
        final Hand pokerHand = new ThreeCardHand("ANY", new Card("4s"), new Card("9h"), new Card("8c"));
        Assert.assertFalse(pokerHand.hasMatchingCard(2));
    }

    @Test
    public void given3EqualValueCardsExpectNotPair()
    {
        final Hand pokerHand = new ThreeCardHand("ANY", new Card("4s"), new Card("4h"), new Card("4c"));
        Assert.assertFalse(pokerHand.hasMatchingCard(2));
    }

    @Test
    public void given2EqualValueCardsExpectPair()
    {
        final Hand pokerHand = new ThreeCardHand("ANY", new Card("4s"), new Card("9h"), new Card("4d"));
        Assert.assertTrue(pokerHand.hasMatchingCard(2));
    }

    // Test getHighCard()

    @Test
    public void givenMixedBagOfCardsExpectToFindHighestCard()
    {
        final Card HIGHEST_CARD = new Card("Kc");
        final Hand aPokerHand = new ThreeCardHand("ANY", new Card("5s"), new Card("Kc"), new Card("Td"));
        Assert.assertEquals(HIGHEST_CARD, aPokerHand.getHighCard());
    }

    @Test
    public void givenSameValueCardsExpectToFindFirstCard()
    {
        final Card FIRST_CARD = new Card("5s");
        final Hand aPokerHand = new ThreeCardHand("ANY", new Card("5s"), new Card("5c"), new Card("5c"));
        Assert.assertEquals(FIRST_CARD, aPokerHand.getHighCard());
    }

}
