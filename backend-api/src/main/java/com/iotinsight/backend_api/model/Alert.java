package com.iotinsight.backend_api.model;

import java.time.Instant;

public class Alert {
    private String alertId;
    private String agentId;
    private String description;
    private Instant timestamp;

    public Alert() {}

    public Alert(String alertId, String agentId, String description, Instant timestamp) {
        this.alertId = alertId;
        this.agentId = agentId;
        this.description = description;
        this.timestamp = timestamp;
    }

    public String getAlertId() { return alertId; }
    public void setAlertId(String alertId) { this.alertId = alertId; }

    public String getAgentId() { return agentId; }
    public void setAgentId(String agentId) { this.agentId = agentId; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public Instant getTimestamp() { return timestamp; }
    public void setTimestamp(Instant timestamp) { this.timestamp = timestamp; }
}
