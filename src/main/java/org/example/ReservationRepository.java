package org.example;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.PersistenceException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
@Transactional
public class ReservationRepository {

@PersistenceContext
private EntityManager em;


    public List<CoworkingSpace>getAvailableSpaces(){
        try{
            return em.createQuery("SELECT s FROM CoworkingSpace s", CoworkingSpace.class)
                    .getResultList();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return List.of();
        }
    }



    public boolean insertReservation(Reservation reservation){
        try{
            reservation.getSpace().setIsAvailable(false);
            em.merge(reservation.getSpace());
            em.persist(reservation);
            return true;
        } catch (PersistenceException e) {
            System.out.println("Error: "+ e.getMessage());
            return false;
        }
    }



    public List<Reservation> getMyBooking(int bookingID){
        try{
            return em.createQuery("SELECT r FROM Reservation r WHERE r.bookingID = :id", Reservation.class)
                    .setParameter("id", bookingID)
                    .getResultList();
        } catch (PersistenceException e) {
            System.out.println("Error: " + e.getMessage());
            return List.of();
        }
    }



    public boolean deleteBooking(int bookingID){
        try{
            Reservation reservation = em.find(Reservation.class,bookingID);
            reservation.getSpace().setIsAvailable(true);
            em.merge(reservation.getSpace());
            em.remove(reservation);
            return true;
        }catch (PersistenceException e){
            System.out.println("Error: " + e.getMessage());
            return false;
        }
    }
}

