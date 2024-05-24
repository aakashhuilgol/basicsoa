from flask import Flask, jsonify
from kafka import KafkaConsumer
import threading
import json

app = Flask(__name__)

messages = []


def start_kafka_consumer():
    consumer = KafkaConsumer(
        'notificationTopic',
        bootstrap_servers=['localhost:9092'],
        auto_offset_reset='earliest',
        enable_auto_commit=True,
        group_id='my-group',
        value_deserializer=lambda x: json.loads(x.decode('utf-8')))

    for message in consumer:
        print(f"Received message: {message.value}")
        messages.append(message.value)


@app.route('/messages', methods=['GET'])
def get_messages():
    return jsonify(messages)


if __name__ == '__main__':
    threading.Thread(target=start_kafka_consumer, daemon=True).start()
    app.run(debug=True, port=5000)
