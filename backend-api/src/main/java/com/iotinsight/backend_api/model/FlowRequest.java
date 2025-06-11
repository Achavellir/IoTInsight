package com.iotinsight.backend_api.model;

import java.util.List;

public class FlowRequest {
    private String agentId;
    private List<Flow> flows;

    public FlowRequest() {}

    public FlowRequest(String agentId, List<Flow> flows) {
        this.agentId = agentId;
        this.flows = flows;
    }

    public String getAgentId() {
        return agentId;
    }
    public void setAgentId(String agentId) {
        this.agentId = agentId;
    }

    public List<Flow> getFlows() {
        return flows;
    }
    public void setFlows(List<Flow> flows) {
        this.flows = flows;
    }
}

