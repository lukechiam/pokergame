package pokergame;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ThreeCardPoker
{
    private List<ThreeCardHand> playingHands;

    public ThreeCardPoker(final InputStream in)
        throws IOException
    {
        playingHands = createGame(in);
    }

    protected ThreeCardPoker() {
        playingHands = new ArrayList<>();
    }

    public List<Hand> getWinningHands()
    {
        // Find card value of max hand
        ThreeCardHand oneOfMaxHand = Collections.max(playingHands);
        return playingHands.stream()
            .filter(entry -> entry.getHighCard().getValue() == oneOfMaxHand.getHighCard().getValue())
            .collect(Collectors.toList());
    }

    protected void addPlayer(String playerId, Card... cards)
    {
        playingHands.add(new ThreeCardHand(playerId, cards));
    }

    /**
     * Only create a game with fixed format data supplied in stream.
     * @param in the imput stream to read game data
     * @return a list of poker hands or empty list should the input be dodgy
     */
    protected List<ThreeCardHand> createGame(final InputStream in)
        throws IOException, NumberFormatException
    {
        Map<String, List<Card>> inputData = new HashMap<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(in));

        // Find out number of players then build object to hold player identifier and their cards
        int numOfPlayer = Integer.valueOf(br.readLine());
        for (int i=0; i < numOfPlayer; i++)
        {
            String[] inputLine = br.readLine().split("\\s+");
            if (inputLine.length != 4)
            {
                return new ArrayList<>();
            }

            String playerId = inputLine[0];
            List<Card> cards = Stream.of(Arrays.copyOfRange(inputLine, 1, inputLine.length)).map(Card::new).collect(Collectors.toList());
            inputData.put(playerId, cards);
        }

        return inputData.entrySet().stream()
            .map(entry -> new ThreeCardHand(entry.getKey(), entry.getValue()))
            .collect(Collectors.toList());
    }

    public static void main(final String[] args)
        throws IOException
    {
        ThreeCardPoker game = new ThreeCardPoker(System.in);
        List<Hand> winningHand = game.getWinningHands();
        System.out.println(
            winningHand.stream()
                .map(entry -> entry.getPlayerId())
                .collect(Collectors.joining(" ")));
    }
}
