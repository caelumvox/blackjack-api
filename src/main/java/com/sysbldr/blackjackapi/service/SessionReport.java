package com.sysbldr.blackjackapi.service;

import com.sysbldr.blackjackapi.domain.data.SessionStatistics;

import java.math.BigDecimal;
import java.util.UUID;

public class SessionReport {
    private UUID uuid;
    private SessionStatistics sessionStatistics;

    public SessionStatistics getSessionStatistics() {
        return sessionStatistics;
    }

    public void setSessionStatistics(SessionStatistics sessionStatistics) {
        this.sessionStatistics = sessionStatistics;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

}
