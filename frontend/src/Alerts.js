// src/Alerts.js
import React, { useEffect, useState } from 'react';

export function Alerts() {
    const [alerts, setAlerts] = useState([]);

    useEffect(() => {
        fetch('/alerts')
            .then(res => res.json())
            .then(setAlerts)
            .catch(console.error);
    }, []);

    return (
        <div>
            <h2>IoT Alerts</h2>
            <table>
                <thead>
                <tr>
                    <th>ID</th><th>Agent</th><th>Description</th><th>Time</th>
                </tr>
                </thead>
                <tbody>
                {alerts.map(a => (
                    <tr key={a.alertId}>
                        <td>{a.alertId}</td>
                        <td>{a.agentId}</td>
                        <td>{a.description}</td>
                        <td>{new Date(a.timestamp).toLocaleString()}</td>
                    </tr>
                ))}
                </tbody>
            </table>
        </div>
    );
}
