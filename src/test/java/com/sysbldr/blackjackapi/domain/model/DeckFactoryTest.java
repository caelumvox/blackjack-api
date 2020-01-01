package com.sysbldr.blackjackapi.domain.model;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DeckFactoryTest {
    @Test
    public void createDeckTest() {
        Set<Card> cards = DeckFactory.createDeck();
        assertEquals(52, cards.size());

        LinkedList<Card> orderedCards = new LinkedList<>(cards);
        Collections.sort(orderedCards);

        Card card = orderedCards.removeFirst();
        assertEquals(Card.Suit.CLUB, card.getSuit());
        assertEquals(Card.Rank.ACE, card.getRank());

        card = orderedCards.removeFirst();
        assertEquals(Card.Suit.CLUB, card.getSuit());
        assertEquals(Card.Rank.TWO, card.getRank());

        card = orderedCards.removeFirst();
        assertEquals(Card.Suit.CLUB, card.getSuit());
        assertEquals(Card.Rank.THREE, card.getRank());

        card = orderedCards.removeFirst();
        assertEquals(Card.Suit.CLUB, card.getSuit());
        assertEquals(Card.Rank.FOUR, card.getRank());

        card = orderedCards.removeFirst();
        assertEquals(Card.Suit.CLUB, card.getSuit());
        assertEquals(Card.Rank.FIVE, card.getRank());

        card = orderedCards.removeFirst();
        assertEquals(Card.Suit.CLUB, card.getSuit());
        assertEquals(Card.Rank.SIX, card.getRank());

        card = orderedCards.removeFirst();
        assertEquals(Card.Suit.CLUB, card.getSuit());
        assertEquals(Card.Rank.SEVEN, card.getRank());

        card = orderedCards.removeFirst();
        assertEquals(Card.Suit.CLUB, card.getSuit());
        assertEquals(Card.Rank.EIGHT, card.getRank());

        card = orderedCards.removeFirst();
        assertEquals(Card.Suit.CLUB, card.getSuit());
        assertEquals(Card.Rank.NINE, card.getRank());

        card = orderedCards.removeFirst();
        assertEquals(Card.Suit.CLUB, card.getSuit());
        assertEquals(Card.Rank.TEN, card.getRank());

        card = orderedCards.removeFirst();
        assertEquals(Card.Suit.CLUB, card.getSuit());
        assertEquals(Card.Rank.JACK, card.getRank());

        card = orderedCards.removeFirst();
        assertEquals(Card.Suit.CLUB, card.getSuit());
        assertEquals(Card.Rank.QUEEN, card.getRank());

        card = orderedCards.removeFirst();
        assertEquals(Card.Suit.CLUB, card.getSuit());
        assertEquals(Card.Rank.KING, card.getRank());

        card = orderedCards.removeFirst();
        assertEquals(Card.Suit.DIAMOND, card.getSuit());
        assertEquals(Card.Rank.ACE, card.getRank());

        card = orderedCards.removeFirst();
        assertEquals(Card.Suit.DIAMOND, card.getSuit());
        assertEquals(Card.Rank.TWO, card.getRank());

        card = orderedCards.removeFirst();
        assertEquals(Card.Suit.DIAMOND, card.getSuit());
        assertEquals(Card.Rank.THREE, card.getRank());

        card = orderedCards.removeFirst();
        assertEquals(Card.Suit.DIAMOND, card.getSuit());
        assertEquals(Card.Rank.FOUR, card.getRank());

        card = orderedCards.removeFirst();
        assertEquals(Card.Suit.DIAMOND, card.getSuit());
        assertEquals(Card.Rank.FIVE, card.getRank());

        card = orderedCards.removeFirst();
        assertEquals(Card.Suit.DIAMOND, card.getSuit());
        assertEquals(Card.Rank.SIX, card.getRank());

        card = orderedCards.removeFirst();
        assertEquals(Card.Suit.DIAMOND, card.getSuit());
        assertEquals(Card.Rank.SEVEN, card.getRank());

        card = orderedCards.removeFirst();
        assertEquals(Card.Suit.DIAMOND, card.getSuit());
        assertEquals(Card.Rank.EIGHT, card.getRank());

        card = orderedCards.removeFirst();
        assertEquals(Card.Suit.DIAMOND, card.getSuit());
        assertEquals(Card.Rank.NINE, card.getRank());

        card = orderedCards.removeFirst();
        assertEquals(Card.Suit.DIAMOND, card.getSuit());
        assertEquals(Card.Rank.TEN, card.getRank());

        card = orderedCards.removeFirst();
        assertEquals(Card.Suit.DIAMOND, card.getSuit());
        assertEquals(Card.Rank.JACK, card.getRank());

        card = orderedCards.removeFirst();
        assertEquals(Card.Suit.DIAMOND, card.getSuit());
        assertEquals(Card.Rank.QUEEN, card.getRank());

        card = orderedCards.removeFirst();
        assertEquals(Card.Suit.DIAMOND, card.getSuit());
        assertEquals(Card.Rank.KING, card.getRank());

        card = orderedCards.removeFirst();
        assertEquals(Card.Suit.SPADE, card.getSuit());
        assertEquals(Card.Rank.ACE, card.getRank());

        card = orderedCards.removeFirst();
        assertEquals(Card.Suit.SPADE, card.getSuit());
        assertEquals(Card.Rank.TWO, card.getRank());

        card = orderedCards.removeFirst();
        assertEquals(Card.Suit.SPADE, card.getSuit());
        assertEquals(Card.Rank.THREE, card.getRank());

        card = orderedCards.removeFirst();
        assertEquals(Card.Suit.SPADE, card.getSuit());
        assertEquals(Card.Rank.FOUR, card.getRank());

        card = orderedCards.removeFirst();
        assertEquals(Card.Suit.SPADE, card.getSuit());
        assertEquals(Card.Rank.FIVE, card.getRank());

        card = orderedCards.removeFirst();
        assertEquals(Card.Suit.SPADE, card.getSuit());
        assertEquals(Card.Rank.SIX, card.getRank());

        card = orderedCards.removeFirst();
        assertEquals(Card.Suit.SPADE, card.getSuit());
        assertEquals(Card.Rank.SEVEN, card.getRank());

        card = orderedCards.removeFirst();
        assertEquals(Card.Suit.SPADE, card.getSuit());
        assertEquals(Card.Rank.EIGHT, card.getRank());

        card = orderedCards.removeFirst();
        assertEquals(Card.Suit.SPADE, card.getSuit());
        assertEquals(Card.Rank.NINE, card.getRank());

        card = orderedCards.removeFirst();
        assertEquals(Card.Suit.SPADE, card.getSuit());
        assertEquals(Card.Rank.TEN, card.getRank());

        card = orderedCards.removeFirst();
        assertEquals(Card.Suit.SPADE, card.getSuit());
        assertEquals(Card.Rank.JACK, card.getRank());

        card = orderedCards.removeFirst();
        assertEquals(Card.Suit.SPADE, card.getSuit());
        assertEquals(Card.Rank.QUEEN, card.getRank());

        card = orderedCards.removeFirst();
        assertEquals(Card.Suit.SPADE, card.getSuit());
        assertEquals(Card.Rank.KING, card.getRank());

        card = orderedCards.removeFirst();
        assertEquals(Card.Suit.HEART, card.getSuit());
        assertEquals(Card.Rank.ACE, card.getRank());

        card = orderedCards.removeFirst();
        assertEquals(Card.Suit.HEART, card.getSuit());
        assertEquals(Card.Rank.TWO, card.getRank());

        card = orderedCards.removeFirst();
        assertEquals(Card.Suit.HEART, card.getSuit());
        assertEquals(Card.Rank.THREE, card.getRank());

        card = orderedCards.removeFirst();
        assertEquals(Card.Suit.HEART, card.getSuit());
        assertEquals(Card.Rank.FOUR, card.getRank());

        card = orderedCards.removeFirst();
        assertEquals(Card.Suit.HEART, card.getSuit());
        assertEquals(Card.Rank.FIVE, card.getRank());

        card = orderedCards.removeFirst();
        assertEquals(Card.Suit.HEART, card.getSuit());
        assertEquals(Card.Rank.SIX, card.getRank());

        card = orderedCards.removeFirst();
        assertEquals(Card.Suit.HEART, card.getSuit());
        assertEquals(Card.Rank.SEVEN, card.getRank());

        card = orderedCards.removeFirst();
        assertEquals(Card.Suit.HEART, card.getSuit());
        assertEquals(Card.Rank.EIGHT, card.getRank());

        card = orderedCards.removeFirst();
        assertEquals(Card.Suit.HEART, card.getSuit());
        assertEquals(Card.Rank.NINE, card.getRank());

        card = orderedCards.removeFirst();
        assertEquals(Card.Suit.HEART, card.getSuit());
        assertEquals(Card.Rank.TEN, card.getRank());

        card = orderedCards.removeFirst();
        assertEquals(Card.Suit.HEART, card.getSuit());
        assertEquals(Card.Rank.JACK, card.getRank());

        card = orderedCards.removeFirst();
        assertEquals(Card.Suit.HEART, card.getSuit());
        assertEquals(Card.Rank.QUEEN, card.getRank());

        card = orderedCards.removeFirst();
        assertEquals(Card.Suit.HEART, card.getSuit());
        assertEquals(Card.Rank.KING, card.getRank());

        assertEquals(0, orderedCards.size());
    }
}
