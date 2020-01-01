package com.sysbldr.blackjackapi.domain.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class ActionTests {
    @Test
    public void actionTests() {
        assertEquals(Action.DOUBLE_DOWN, Action.valueOfNotation('D'));
        assertEquals(Action.HIT, Action.valueOfNotation('H'));
        assertEquals(Action.SPLIT, Action.valueOfNotation('P'));
        assertEquals(Action.STAND, Action.valueOfNotation('T'));
        assertNull(Action.valueOfNotation('E'));
    }
}
