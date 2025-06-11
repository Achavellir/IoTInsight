# edge-agent/capture.py

from scapy.all import sniff, IP, TCP, UDP
import json, requests
from datetime import datetime

BACKEND_URL = "http://localhost:8080/flows"

def packet_to_flow(pkt):
    if IP in pkt:
        ip = pkt[IP]
        return {
            "srcIp": ip.src,
            "dstIp": ip.dst,
            "bytes": len(pkt),
            "timestamp": datetime.utcnow().isoformat() + "Z"
        }
    return None

def send_flows(agent_id, flows):
    payload = {
        "agentId": agent_id,
        "flows": flows
    }
    resp = requests.post(BACKEND_URL, json=payload)
    resp.raise_for_status()
    print(f"Sent {len(flows)} flows, status {resp.status_code}")

def capture_and_send(agent_id="agent-1", count=10, iface=None):
    packets = sniff(count=count, iface=iface, timeout=5)
    flows = [packet_to_flow(p) for p in packets]
    flows = [f for f in flows if f]
    if flows:
        send_flows(agent_id, flows)
    else:
        print("No IP packets captured.")

if __name__ == "__main__":
    capture_and_send()
