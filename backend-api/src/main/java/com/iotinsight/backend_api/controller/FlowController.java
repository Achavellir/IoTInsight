package com.iotinsight.backend_api.controller;

import com.iotinsight.backend_api.model.Alert;
import com.iotinsight.backend_api.model.FlowRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/flows")
public class FlowController {

    private final SimpMessagingTemplate messagingtemplate;
    static final List<Alert> alerts = new ArrayList<>();

    public FlowController(SimpMessagingTemplate messagingtemplate) {
        this.messagingtemplate = messagingtemplate;
    }

    @PostMapping
    public ResponseEntity<Void> ingestFlows(@RequestBody FlowRequest req) {
        req.getFlows().forEach(f -> {
            if (f.getBytes() > 1_000_000) {
                Alert newAlert = new Alert(UUID.randomUUID().toString(),
                        req.getAgentId(),
                        "High bytes: " + f.getBytes(),
                        f.getTimestamp());
                alerts.add(newAlert);
                messagingtemplate.convertAndSend("/topic/alerts", newAlert);
            }
        });
        return ResponseEntity.ok().build();
    }
}
