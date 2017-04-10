import java.util.List;
import java.util.Objects;

/**
 * Created by osem on 10/04/2017.
 */
public class Menu {

    private String name;
    private List<Dish> dishes;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Dish> getDishes() {
        return dishes;
    }

    public void setDishes(List<Dish> dishes) {
        this.dishes = dishes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Menu)) return false;
        Menu menu = (Menu) o;
        return Objects.equals(name, menu.name) &&
                Objects.equals(dishes, menu.dishes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, dishes);
    }

    @Override
    public String toString() {
        return "Menu{" +
                "name='" + name + '\'' +
                ", dishes=" + dishes +
                '}';
    }
}
