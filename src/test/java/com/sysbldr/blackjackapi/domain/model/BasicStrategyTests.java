package com.sysbldr.blackjackapi.domain.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BasicStrategyTests {
    @Test
    public void loadBasicStrategyTest() {
        BasicStrategy basicStrategy = new BasicStrategy();

        Hand hand = new Hand();
        hand.addCard(new Card(Card.Suit.DIAMOND, Card.Rank.THREE));
        hand.addCard(new Card(Card.Suit.SPADE, Card.Rank.FIVE));

        Card dealerUpCard = new Card(Card.Suit.CLUB, Card.Rank.TWO);
        assertEquals(Action.HIT, basicStrategy.getAction(hand, dealerUpCard));
    }
}
