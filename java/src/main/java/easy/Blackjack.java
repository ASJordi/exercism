package easy;

import java.util.LinkedHashMap;
import java.util.Map;

public class Blackjack {

    public int parseCard(String card) {

        Map<String, Integer> cardsMap = new LinkedHashMap<>() {{
            put("ace", 11);
            put("two", 2);
            put("three", 3);
            put("four", 4);
            put("five", 5);
            put("six", 6);
            put("seven", 7);
            put("eight", 8);
            put("nine", 9);
            put("ten", 10);
            put("jack", 10);
            put("queen", 10);
            put("king", 10);
            put("other", 0);
        }};

        return cardsMap.get(card);
    }

    public boolean isBlackjack(String card1, String card2) {
        return parseCard(card1) + parseCard(card2) == 21;
    }

    public String largeHand(boolean isBlackjack, int dealerScore) {
        return isBlackjack ? (dealerScore < 10 ? "W" : "S") : "P";
    }

    public String smallHand(int handScore, int dealerScore) {
        return handScore >= 17 ? "S" :
                handScore <= 11 ? "H" :
                        (handScore >= 12 && handScore <= 16 && dealerScore >= 7) ? "H" : "S";
    }

    // FirstTurn returns the semi-optimal decision for the first turn, given the cards of the player and the dealer.
    // This function is already implemented and does not need to be edited. It pulls the other functions together in a
    // complete decision tree for the first turn.
    public String firstTurn(String card1, String card2, String dealerCard) {
        int handScore = parseCard(card1) + parseCard(card2);
        int dealerScore = parseCard(dealerCard);

        if (20 < handScore) {
            return largeHand(isBlackjack(card1, card2), dealerScore);
        } else {
            return smallHand(handScore, dealerScore);
        }
    }
}
