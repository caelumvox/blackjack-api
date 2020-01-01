package com.sysbldr.blackjackapi.domain.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class BasicStrategy implements Strategy {
    private static final Logger LOGGER = LoggerFactory.getLogger(BasicStrategy.class);
    private static final String BASIC_STRATEGY_MATRIX_FILENAME = "/BasicStrategyMatrix.txt";
    private Map<String, Map<String, Action>> actionMap = new HashMap<>();
    private static final List<String> dealerUpHandValues = new LinkedList<>();

    static {
        for (Integer i = 2; i <= 10; i++) {
            dealerUpHandValues.add(i.toString());
        }
        dealerUpHandValues.add("A");
    }

    private void loadRow(String cardValue, Iterator<String> fieldListIterator) {
        Map<String, Action> playerHandActionMap = new HashMap<>();
        Iterator<String> dealerUpHandIterator = dealerUpHandValues.iterator();
        while (dealerUpHandIterator.hasNext() && fieldListIterator.hasNext()) {
            playerHandActionMap.put(dealerUpHandIterator.next(), Action.valueOfNotation(fieldListIterator.next().charAt(0)));
        }
        actionMap.put(cardValue, playerHandActionMap);
    }

    private void loadBasicStrategyFile() {
        InputStream inputStream = BasicStrategy.class.getResourceAsStream(BASIC_STRATEGY_MATRIX_FILENAME);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String line;
        try {
            while ((line = bufferedReader.readLine()) != null) {
                List<String> fieldList = Arrays.asList(line.split("\\|")).stream().map(
                        s -> s.trim()).collect(Collectors.toList());
                Iterator<String> fieldListIterator = fieldList.iterator();
                String rowHeader = fieldListIterator.next();

                if (rowHeader.length() <= 3) {
                    loadRow(rowHeader, fieldListIterator);
                }
            }
        } catch (IOException e) {
            LOGGER.warn("Error attempting to process Basic Strategy File.", e);
        }
    }

    public BasicStrategy() {
        loadBasicStrategyFile();
    }

    @Override
    public Action getAction(Hand playerHand, Card dealerUpCard) {
        List<Card> playerCards = playerHand.getCards();
        Action action = null;

        // If there are no aces and this 17 or greater, must return with stand.
        if ((playerHand.getHardScore() == playerHand.getSoftScore()) && playerHand.getHardScore() >= 17) {
            action = Action.STAND;
        } else {
            if (playerCards.size() == 2) {
                Card playerCard1 = playerCards.get(0);
                Card playerCard2 = playerCards.get(1);

                // If this is a 20, immediately return with a stand.
                if (playerHand.getHardScore() == 20) {
                    action = Action.STAND;
                } else {

                    // Default the hand identifier used to access the strategy map with the hard score.
                    String handIdentifier = String.valueOf(playerCard1.getRank().getHardValue() + playerCard2.getRank().getHardValue());
                    if (playerCard1.getRank() == playerCard2.getRank()) {
                        // this is a pair.
                        handIdentifier = playerCard1.getRank().getAbbreviation() + "-" + playerCard2.getRank().getAbbreviation();
                    } else if (playerCard1.getRank() == Card.Rank.ACE || playerCard2.getRank() == Card.Rank.ACE) {
                        // one or the other is an Ace but not both
                        handIdentifier = (playerCard1.getRank() == Card.Rank.ACE) ?
                                (playerCard1.getRank().getAbbreviation() + "-" + playerCard2.getRank().getAbbreviation()) :
                                (playerCard2.getRank().getAbbreviation() + "-" + playerCard1.getRank().getAbbreviation());
                    }
                    action = actionMap.get(handIdentifier).get(dealerUpCard.getRank().getAbbreviation());
                }
            }
        }
        return action;
    }
}
