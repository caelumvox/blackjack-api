package com.sysbldr.blackjackapi.domain.model;

import com.sysbldr.blackjackapi.domain.exception.ShuffleException;
import javafx.util.Pair;

import java.util.LinkedList;
import java.util.List;

public class Dealer {
    private final Shoe shoe;
    private final DiscardPile discardPile;
    private final int maxRounds;
    private int roundsPlayed;
    private List<Player> players = new LinkedList<>();
    private List<Pair<Player, Hand>> playerHandPairs = new LinkedList<>();
    private Hand dealerHand;

    public Dealer(Shoe shoe, DiscardPile discardPile, int maxRounds) {
        this.shoe = shoe;
        this.discardPile = discardPile;
        this.maxRounds = maxRounds;
    }

    public void addPlayer(Player player) {
        players.add(player);
    }

    private void dealHands() {
        // Initialize a hand for each player
        for (Player player: players) {
            playerHandPairs.add(new Pair<>(player, new Hand(player.deductWager())));
        }
        // hand for the dealer.
        dealerHand = new Hand();

        // Deal to each player and dealer
        int cardCount = 0;
        while (cardCount < 2) {
            for (Pair<Player, Hand> playerHandPair: playerHandPairs) {
                playerHandPair.getValue().addCard(shoe.dealCard());
            }
            dealerHand.addCard(shoe.dealCard());
            cardCount += 1;
        }
    }

    public void runRound() throws ShuffleException {
        if (shoe.isLowOnHands()) {
            shoe.shuffle();
        }

        dealHands();

        // TODO: Check insurance

        // Check for dealer blackjack.
        if (dealerHand.isBlackjack()) {
            // Round is over. Check for blackjack pushes (which credit players), otherwise do nothing.

            for (Pair<Player, Hand> playerHandPair: playerHandPairs) {
                if (playerHandPair.getValue().isBlackjack()) {
                    playerHandPair.getKey().credit(playerHandPair.getValue().getWager());
                }
            }
        } else {
            // No dealer blackjack.  Run through player hand pairs, noting that splits could change this number in
            // the round.
            int currentPlayerHandPairIndex = 0;
            while (currentPlayerHandPairIndex < playerHandPairs.size()) {
                Pair<Player, Hand> playerHandPair = playerHandPairs.get(currentPlayerHandPairIndex);

                Action action = playerHandPair.getKey().play(playerHandPair.getValue(), dealerHand.getFirstCard());
            }
        }

        // Clean up round.
        for (Pair<Player, Hand> playerHandPair: playerHandPairs) {
            discardPile.dumpHand(playerHandPair.getValue());
        }
        discardPile.dumpHand(dealerHand);
        playerHandPairs.clear();
        roundsPlayed += 1;
    }

    public boolean hasRounds() {
        return roundsPlayed <= maxRounds;
    }
}
