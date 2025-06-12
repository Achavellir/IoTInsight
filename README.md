# IoTInsight

**IoTInsight** is an end-to-end IoT security monitoring platform that:

- **Ingests** packet flows from a lightweight Python edge agent  
- **Flags** anomalies (e.g. unusually large byte counts) in a Spring Boot backend  
- **Exposes** REST endpoints for `/flows` and `/alerts`  
- **Displays** real-time alerts in a React frontend  

---

## 📁 Repository Structure

IoTInsight/
├── backend-api/ Spring Boot backend
├── edge-agent/ Python scapy-based agent
├── frontend/ React alerts UI
├── docs/ OpenAPI spec (api.yaml)
└── README.md


---

## 🔧 Prerequisites

- Java 17+ (JDK 17 recommended)  
- Maven (for backend)  
- Python 3.9+ (for edge-agent)  
- Node.js 18+ & npm (for frontend)  
- `sudo` permissions to capture packets on macOS/Linux

---

## 🚀 Getting Started

### 1. Backend (Spring Boot)
```bash
cd backend-api
mvn clean compile spring-boot:run

🛠 CI/CD

This repo includes a GitHub Actions workflow (.github/workflows/ci.yml) that:

backend-api: mvn clean verify
edge-agent: pytest
frontend: npm ci && npm run build
Every push to main triggers a full build and test of all modules.

📄 License

MIT © Rishi Achavelli
