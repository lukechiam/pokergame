package pokergame;

import junit.framework.Assert;
import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;

public class ThreeCardPokerTest
{
    @Test
    public void givenMultipleWinnersExpectMultiplePlayerIdsDelimitedByWhiteSpace()
    {
        ThreeCardPoker game = new ThreeCardPoker();
        game.addPlayer("0", new Card("Ah"), new Card("2c"), new Card("Js"));
        game.addPlayer("1", new Card("3h"), new Card("9h"), new Card("Th"));
        game.addPlayer("2", new Card("Tc"), new Card("9c"), new Card("3c"));
        List<Hand> winningHands = game.getWinningHands();
        Assert.assertEquals("1 2",
            winningHands.stream()
                .map(entry -> entry.getPlayerId())
                .collect(Collectors.joining(" ")));
    }

    @Test
    public void given4PlayersExpectGamePlay()
    {
        ThreeCardPoker game = new ThreeCardPoker();
        game.addPlayer("0", new Card("2h"), new Card("2d"), new Card("3c"));
        game.addPlayer("1", new Card("Jd"), new Card("Js"), new Card("Ad"));
        game.addPlayer("2", new Card("Qs"), new Card("Qh"), new Card("4d"));
        game.addPlayer("3", new Card("6s"), new Card("7h"), new Card("9d"));
        List<Hand> winningHands = game.getWinningHands();
        Assert.assertEquals("2", winningHands.get(0).getPlayerId());
    }

}

