package EntityClasses;

/**
 * @author Barat Narcis Stefan
 * In this class i am defying the Destinations, with the appropiate setters, getters and constructors.
 */

public class Destination {

    private String name;

    public Destination(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Destination{" +
                "name='" + name + '\'' +
                '}';
    }
}
