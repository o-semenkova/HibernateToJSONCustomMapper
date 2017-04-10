import java.util.Objects;

/**
 * Created by osem on 10/04/2017.
 */
public class Dish {
    private String name;
    private String taste;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTaste() {
        return taste;
    }

    public void setTaste(String taste) {
        this.taste = taste;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Dish)) return false;
        Dish dish = (Dish) o;
        return Objects.equals(name, dish.name) &&
                Objects.equals(taste, dish.taste);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, taste);
    }

    @Override
    public String toString() {
        return "Dish{" +
                "name='" + name + '\'' +
                ", taste='" + taste + '\'' +
                '}';
    }
}
