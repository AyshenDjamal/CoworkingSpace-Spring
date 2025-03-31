package org.example;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;



@Service
public class CoworkingSpaceService {

    @Autowired
    private SpaceRepository spaceRepository;

    public boolean addSpace(int id, String spaceType, double price, boolean isAvailable) {
        return spaceRepository.insertSpace(new CoworkingSpace(id, spaceType, price, isAvailable));
    }


    public boolean removeSpace(int id) {
        return spaceRepository.deleteSpace(id);
    }


    public void viewAllBookings() {
        List<Reservation> reservationList = spaceRepository.getAllBookings();
        if (reservationList.isEmpty()) {
            System.out.println("------------------------------");
            System.out.println("No reservations were found.\n");
        } else {
            System.out.println("-------------List Of Reservations-----------");
            reservationList.forEach(System.out::println);
        }
    }

}





