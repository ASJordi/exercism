package easy;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GottaSnatchEmAll {

    static Set<String> newCollection(List<String> cards) {
        return new HashSet<>(cards);
    }

    static boolean addCard(String card, Set<String> collection) {
        return collection.add(card);
    }

    static boolean canTrade(Set<String> myCollection, Set<String> theirCollection) {
        return !myCollection.containsAll(theirCollection) && !theirCollection.containsAll(myCollection);
    }

    static Set<String> commonCards(List<Set<String>> collections) {
        Set<String> commonCards = new HashSet<>(collections.get(0));

        for (var collection : collections) {
            commonCards.retainAll(collection);
        }

        return commonCards;
    }

    static Set<String> allCards(List<Set<String>> collections) {
        Set<String> allCards = new HashSet<>();

        for (var collection : collections) {
            allCards.addAll(collection);
        }

        return allCards;
    }

}
