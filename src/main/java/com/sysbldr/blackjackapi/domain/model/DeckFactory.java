package com.sysbldr.blackjackapi.domain.model;

import java.util.HashSet;
import java.util.Set;

public class DeckFactory {
    public static Set<Card> createDeck() {
        Set<Card> deck = new HashSet<>();
        for (Card.Rank rank: Card.Rank.values()) {
            for (Card.Suit suit: Card.Suit.values()) {
                deck.add(new Card(suit, rank));
            }
        }
        return deck;
    }
}
