import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.ArrayList;
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
        hotel.setName("Spring");
        Location location = new Location();
        location.setCity("Toronto");
        location.setCountry("Kanada");
        hotel.setLocation(location);
        Dish dish1 = new Dish();
        dish1.setName("a");
        dish1.setTaste("b");
        Dish dish2 = new Dish();
        dish2.setName("c");
        dish2.setTaste("d");
        List<Dish> dishes = new ArrayList<>();
        dishes.add(dish1);
        dishes.add(dish2);
        Menu menu = new Menu();
        menu.setName("My menu");
        menu.setDishes(dishes);
        hotel.setMenu(menu);

        System.out.println("COMIITING");

        em.persist(hotel);
        em.getTransaction().commit();

        Query query = em.createQuery("from Hotel where name = :name ");
        query.setParameter("name", "Spring");
        Hotel hotelFromDB = (Hotel)query.getSingleResult();
        System.out.println("Hotel name is: " + hotelFromDB.getName());
        System.out.println("Hotel city is: " + hotelFromDB.getLocation().getCity());
        System.out.println("Hotel country is: " + hotelFromDB.getLocation().getCountry());
        System.out.println("Hotel menu is: " + hotelFromDB.getMenu().getName());
        System.out.println("Hotel menu dishes are: " + hotelFromDB.getMenu().getDishes());
    }
}
