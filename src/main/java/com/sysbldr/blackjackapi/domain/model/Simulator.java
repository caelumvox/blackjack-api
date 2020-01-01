package com.sysbldr.blackjackapi.domain.model;

import com.sysbldr.blackjackapi.api.SessionConfiguration;
import com.sysbldr.blackjackapi.domain.data.SessionStatistics;
import com.sysbldr.blackjackapi.domain.exception.ShuffleException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashSet;
import java.util.Set;

public class Simulator {
    private static final Logger LOGGER = LoggerFactory.getLogger(Simulator.class);
    private SessionConfiguration sessionConfiguration;
    public Simulator(SessionConfiguration sessionConfiguration) {
        this.sessionConfiguration = sessionConfiguration;
    }

    public SessionStatistics runSession() {
        SessionStatistics sessionStatistics = new SessionStatistics();
        sessionStatistics.setBank(sessionConfiguration.getBank());


        try {
            Set<Card> cardPile = new HashSet<>();
            for (int i = 0; i < sessionConfiguration.getDeckCount(); i++) {
                cardPile.addAll(DeckFactory.createDeck());
            }
            Shoe shoe = new Shoe(cardPile);
            DiscardPile discardPile = new DiscardPile();

            Dealer dealer = new Dealer(shoe, discardPile, sessionConfiguration.getMaxRounds());
            Player player = new Player(new BasicStrategy(), sessionConfiguration.getBank(), sessionConfiguration.getWager());
            dealer.addPlayer(player);

            while (player.hasBank() && dealer.hasRounds()) {
                dealer.runRound();
            }
        } catch (ShuffleException e) {
            LOGGER.warn("Invalid deck shuffle. Cards must be missing.");
        }
        return sessionStatistics;
    }
}
