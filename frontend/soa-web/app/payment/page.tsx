"use client";

import { useState } from 'react';

export default function Payment() {
    const [response, setResponse] = useState('');

    const handlePayment = async () => {
        try {
            const body = { bookingId: "1", paidStatus: true };
            const response = await fetch('http://localhost:8181/api/payment', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify(body)
            });

            const data = await response.json();
            setResponse(`Payment successful: ID ${data.id}, Booking ID ${data.bookingId}, Paid Status ${data.paidStatus}`);
        } catch (error) {
            setResponse('Payment failed: ' + error);
        }
    };

    return (
        <div>
            <button
                onClick={handlePayment}
                style={{ backgroundColor: 'blue', color: 'white', padding: '10px 20px', border: 'none', borderRadius: '5px', cursor: 'pointer' }}>
                Make Payment
            </button>
            <div>{response}</div>
        </div>
    );
}
