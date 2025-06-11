package com.iotinsight.backend_api.controller;

import com.iotinsight.backend_api.model.Alert;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/alerts")
public class AlertController {

    @GetMapping
    public List<Alert> getAlerts(@RequestParam(required = false) Instant since) {
        return (since  == null) ?
                FlowController.alerts : FlowController.alerts.stream()
                .filter(a -> a.getTimestamp().isAfter(since))
                .collect(Collectors.toList());
    }
}
