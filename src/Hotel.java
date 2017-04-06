import org.hibernate.annotations.Type;

import javax.persistence.*;

/**
 * Created by Admin on 4/6/2017.
 */

@Entity
public class Hotel extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Type(type = "jsonb")
    @Column(name = "location",columnDefinition = "json")
    private Location location;

    @Column(name = "name")
    private String name;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "id=" + id +
                ", location=" + location +
                ", name='" + name + '\'' +
                '}';
    }
}
