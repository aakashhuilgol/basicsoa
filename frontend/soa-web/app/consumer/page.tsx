"use client";

import { useEffect } from 'react';
import socketService from "@/services/socketService";

const Notifications = () => {
    useEffect(() => {
        // Connect to the Socket.IO server
        socketService.connect();
        socketService.on('newBookingNotification', (message: string) => {
            console.log('New booking:', message);
            alert(`New Booking Notification: ${message}`);
        });

        // Clean up on component unmount
        return () => {
            socketService.disconnect();
        };
    }, []);

    return (
        <div>
            <h1>Notifications</h1>
            <p>Listen for real-time notifications about new bookings.</p>
        </div>
    );
};

export default Notifications;
