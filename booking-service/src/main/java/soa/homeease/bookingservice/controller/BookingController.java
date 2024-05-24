package soa.homeease.bookingservice.controller;

import soa.homeease.bookingservice.dto.BookingRequest;
import soa.homeease.bookingservice.service.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/booking")
@RequiredArgsConstructor
public class BookingController {


    private final BookingService bookingService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String placeBooking(@RequestBody BookingRequest bookingRequest){
        bookingService.placeBooking(bookingRequest);
        return "Booking Successful";
    }
}
