package com.sysbldr.blackjackapi.domain.model;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;

public class Hand {
    private static int FIRST_CARD_INDEX = 0;
    private BigDecimal wager;
    private List<Card> cards = new LinkedList<>();

    public Hand(BigDecimal wager) {
        this.wager = wager;
    }

    public Hand() {
    }

    public void addCard(Card card) {
        cards.add(card);
    }

    public Card getFirstCard() {
        return cards.get(FIRST_CARD_INDEX);
    }

    public List<Card> getCards() {
        return cards;
    }

    public boolean isBlackjack() {
        if (cards.size() != 2) {
            return false;
        }

        Card first = cards.get(0);
        Card second = cards.get(1);
        if (first.getRank() == Card.Rank.ACE &&
                (second.getRank() == Card.Rank.TEN || second.getRank() == Card.Rank.JACK || second.getRank() == Card.Rank.QUEEN || second.getRank() == Card.Rank.KING)) {
            return true;
        } else if (second.getRank() == Card.Rank.ACE &&
                (first.getRank() == Card.Rank.TEN || first.getRank() == Card.Rank.JACK || first.getRank() == Card.Rank.QUEEN || first.getRank() == Card.Rank.KING)) {
            return true;
        }
        return false;
    }

    public BigDecimal getWager() {
        return wager;
    }

    public int getHardScore() {
        int score = 0;
        for (Card card: cards) {
            score += card.getRank().getHardValue();
        }
        return score;
    }

    public int getSoftScore() {
        int score = 0;
        for (Card card: cards) {
            score += card.getRank().getSoftValue();
        }
        return score;
    }
}
