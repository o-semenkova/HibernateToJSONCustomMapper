import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by Admin on 4/6/2017.
 */
public class HotelTest {
    public static void main(String []args){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hotelPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Hotel hotel = new Hotel();
        hotel.setName("Oksana");
        Location location = new Location();
        location.setCity("Dnepr");
        location.setCountry("Ukraine");
        hotel.setLocation(location);

        System.out.println("COMIITING");

        em.persist(hotel);
        em.getTransaction().commit();

        Query query = em.createQuery("from Hotel where id = :id ");
        query.setParameter("id", "1");
        List list = query.getResultList();
        list.toString();
    }
}
