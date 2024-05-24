package soa.homeease.bookingservice.service;

import soa.homeease.bookingservice.booking.Booking;
import soa.homeease.bookingservice.booking.ProfessionalDetails;
import soa.homeease.bookingservice.dto.BookingRequest;
import soa.homeease.bookingservice.dto.InventoryResponse;
import soa.homeease.bookingservice.dto.ProfessionalDetailsDto;
import soa.homeease.bookingservice.repository.BookingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional
public class BookingService {

    private final BookingRepository bookingRepository;
    private final WebClient webClient;

    public void placeBooking(BookingRequest bookingRequest){
        Booking booking = new Booking();
        booking.setBookingNumber(UUID.randomUUID().toString());

        List<ProfessionalDetails> professionalDetailsList =
                bookingRequest.getProfessionalDetailsDto()
                .stream().map(this::mapToDto)
                .toList();

        booking.setProfessionalDetailsList(professionalDetailsList);

        List<String> names = booking.getProfessionalDetailsList().stream().map(ProfessionalDetails::getName)
                .toList();

        // CALL INVENTORY SERVICE
        InventoryResponse[] inventoryResponseArray = webClient.get()
                .uri("http://localhost:8082/api/inventory",
                        uriBuilder -> uriBuilder.queryParam("name",names).build())
                        .retrieve()
                                .bodyToMono(InventoryResponse[].class)
                                    .block();

        assert inventoryResponseArray != null;
        boolean availability = Arrays.stream(inventoryResponseArray)
                .allMatch(InventoryResponse::isAvailable);

        if(Boolean.TRUE.equals(availability)){
            bookingRepository.save(booking);
        } else{
            throw new IllegalArgumentException("Professional is not Available. Please change professional");
        }

    }

    private ProfessionalDetails mapToDto(ProfessionalDetailsDto professionalDetailsDto){
        ProfessionalDetails professionalDetails = new ProfessionalDetails();
        professionalDetails.setName(professionalDetailsDto.getName());
        professionalDetails.setPayment(professionalDetailsDto.getPayment());
        professionalDetails.setStatus(professionalDetailsDto.getStatus());
        professionalDetails.setPrice(professionalDetailsDto.getPrice());
        return professionalDetails;
    }
}
