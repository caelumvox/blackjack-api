package com.sysbldr.blackjackapi.domain.model;

public enum Action {
    DOUBLE_DOWN('D'),
    HIT('H'),
    SPLIT('P'),
    STAND('T');

    private char notation;
    Action(char notation) {
        this.notation = notation;
    }

    public static Action valueOfNotation(char notation) {
        for (Action action: Action.values()) {
            if (notation == action.getNotation()) {
                return action;
            }
        }
        return null;
    }

    public char getNotation() {
        return notation;
    }
}
