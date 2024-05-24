package soa.homeease.bookingservice.repository;

import soa.homeease.bookingservice.booking.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Long> {

}
