package CompulsoryOptionalBonus.Model;

/**
 * The Director class represents the prototype of a director
 */
public class Director {
    private int id;
    private String name;

    public Director(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
