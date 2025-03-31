package org.example;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.PersistenceException;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
@Transactional
public class SpaceRepository {

    @PersistenceContext
    private EntityManager em;


    public boolean insertSpace(CoworkingSpace space) {
        try {
            em.persist(space);
            return true;
        } catch (PersistenceException e) {
            System.out.println("Error: " + e.getMessage());
            return false;
        }
    }


    public boolean deleteSpace(int spaceID){
        try{
            CoworkingSpace space = em.find(CoworkingSpace.class, spaceID);
            em.remove(space);
            return true;
        } catch (PersistenceException e) {
            System.out.println("Error: " + e.getMessage());
            return false;
        }
    }


    public List<Reservation> getAllBookings(){
        try{
            TypedQuery<Reservation> query = em.createQuery("SELECT r FROM Reservation r", Reservation.class);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Error: " + e.getMessage());
            return List.of();
        }
    }


    public CoworkingSpace findSpaceID(int spaceID){
            return em.find(CoworkingSpace.class, spaceID);
    }
}

