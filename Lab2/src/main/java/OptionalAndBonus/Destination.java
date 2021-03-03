package OptionalAndBonus;

/**
 * The Destination class describe the destinations, which have a name.
 */

public class Destination {
    private String name;

    /**
     * Constructor to give a name to a destination.
     *
     * @param name String : name of the destination
     */
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

    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Destination)) {
            return false;
        }
        Destination other = (Destination) obj;
        return name.equals(other.name);
    }

}
