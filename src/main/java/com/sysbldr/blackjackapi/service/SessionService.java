package com.sysbldr.blackjackapi.service;

import com.sysbldr.blackjackapi.api.SessionConfiguration;
import com.sysbldr.blackjackapi.domain.model.Simulator;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class SessionService {
    public SessionReport runSession(SessionConfiguration sessionConfiguration) {
        SessionReport sessionReport = new SessionReport();
        sessionReport.setUuid(UUID.randomUUID());

        Simulator simulator = new Simulator(sessionConfiguration);
        simulator.runSession();

        return sessionReport;
    }
}
