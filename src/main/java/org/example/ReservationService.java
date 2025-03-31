package org.example;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;
    @Autowired
    private SpaceRepository spaceRepository;

    public void viewSpaces() {
        List<CoworkingSpace> spaceList = reservationRepository.getAvailableSpaces();
        if (spaceList.isEmpty()) {
            System.out.println("No coworking spaces are available.");
        } else {
            System.out.println("-------------List of Coworking Spaces----------");
            spaceList.stream()
                    .filter(CoworkingSpace::getIsAvailable)
                    .forEach(System.out::println);
        }
    }



    public boolean bookSpace(Reservation reservation) {
        if(reservation.getSpace() == null || !reservation.getSpace().getIsAvailable()){
            System.out.println("Space is either invalid or already booked! ");
            return false;
        }
        return reservationRepository.insertReservation(reservation);
    }



    public CoworkingSpace findSpaceID(int spaceID){
        return spaceRepository.findSpaceID(spaceID);
    }


    public void myBookings(int bookingID) {
        List<Reservation> bookingList = reservationRepository.getMyBooking(bookingID);
        if (bookingList.isEmpty()) {
            System.out.println("You don't have a booking. ");
        } else {
            bookingList.forEach(System.out::println);
        }
    }



    public boolean cancelBooking(int canID) {
        return reservationRepository.deleteBooking(canID);
    }
}



