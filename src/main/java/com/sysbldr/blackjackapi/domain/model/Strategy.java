package com.sysbldr.blackjackapi.domain.model;

public interface Strategy {
    Action getAction(Hand hand, Card dealerUpCard);
}
