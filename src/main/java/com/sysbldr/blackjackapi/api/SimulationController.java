package com.sysbldr.blackjackapi.api;

import com.sysbldr.blackjackapi.service.SessionReport;
import com.sysbldr.blackjackapi.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/simulation")
public class SimulationController {
    @Autowired
    private SessionService sessionService;

    @PostMapping(value = "/session", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public SessionReport postSession(@RequestBody SessionConfiguration sessionConfiguration) {
        return sessionService.runSession(sessionConfiguration);
    }
}
