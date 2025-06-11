package com.iotinsight.backend_api.model;

import java.time.Instant;

public class Flow {
    private String srcIp;
    private String dstIp;
    private int bytes;
    private Instant timestamp;

    public Flow() {}

    public Flow(String srcIp, String dstIp, int bytes, Instant timestamp) {
        this.srcIp = srcIp;
        this.dstIp = dstIp;
        this.bytes = bytes;
        this.timestamp = timestamp;
    }

    public String getSrcIp() { return srcIp; }
    public void setSrcIp(String srcIp) { this.srcIp = srcIp; }

    public String getDstIp() { return dstIp; }
    public void setDstIp(String dstIp) { this.dstIp = dstIp; }

    public int getBytes() { return bytes; }
    public void setBytes(int bytes) { this.bytes = bytes; }

    public Instant getTimestamp() { return timestamp; }
    public void setTimestamp(Instant timestamp) { this.timestamp = timestamp; }
}
