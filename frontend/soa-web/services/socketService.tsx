import { io, Socket } from "socket.io-client";

class SocketService {
    private socket: Socket | undefined;

    public connect() {
        this.socket = io('localhost:9093');

        this.socket.on('connect', () => {
            console.log('Connected to Socket.IO server');
        });

        this.socket.on('disconnect', () => {
            console.log('Disconnected from Socket.IO server');
        });

        this.socket.on("connect", () => {
            // @ts-ignore
            const transport = this.socket.io.engine.transport.name; // in most cases, "polling"

            // @ts-ignore
            this.socket.io.engine.on("upgrade", () => {
                // @ts-ignore
                const upgradedTransport = this.socket.io.engine.transport.name; // in most cases, "websocket"
                console.log('u;', upgradedTransport);
            });
            console.log('t;', transport);

        });

        return this.socket;
    }

    public disconnect() {
        if (this.socket) {
            this.socket.disconnect();
        }
    }

    public on(eventName: string, func: (...args: any[]) => void) {
        if (this.socket) {
            this.socket.on(eventName, func);
        }
    }
}

const socketService = new SocketService();
export default socketService;
