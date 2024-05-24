package com.homeease.notificationservice;

import com.corundumstudio.socketio.SocketIOServer;
import io.micrometer.observation.Observation;
import io.micrometer.observation.ObservationRegistry;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;

@SpringBootApplication
@Slf4j
@RequiredArgsConstructor
public class NotificationServiceApplication {

	private final ObservationRegistry observationRegistry;

	private final SocketIOServer socketIOServer;

	public static void main(String[] args) {
		SpringApplication.run(NotificationServiceApplication.class, args);
	}

	@KafkaListener(topics = "notificationTopic")
	public void handleNotification(String bookingPaidEvent) {
		Observation.createNotStarted("on-message", this.observationRegistry).observe(() -> {
			log.info("Got message <{}>", bookingPaidEvent);
			socketIOServer.getBroadcastOperations().sendEvent("newBookingNotification", bookingPaidEvent);
		});
	}
}
