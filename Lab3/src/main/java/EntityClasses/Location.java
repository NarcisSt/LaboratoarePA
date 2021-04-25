package EntityClasses;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * The abstract class Location which is extended by Church, Hotel, Museum and Restaurant classes.
 */
public abstract class Location {

    public String name;
    public Map<Location, Integer> cost = new HashMap<>();

    public Location() {
    }

    public Location(String name, Map<Location, Integer> cost) {
        this.name = name;
        this.cost = cost;
    }

    public Map<Location, Integer> getCost() {
        return cost;
    }

    public void setCost(Location node, int value) {
        cost.put(node, value);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * Method that displays the list of costs between locations.
     */
    public void displayCosts(){
        for (Map.Entry<Location, Integer> entry : cost.entrySet()) {
            System.out.println(name + "->" + entry.getKey().name + ":" + entry.getValue());
        }
    }

    @Override
    public String toString() {
        return "Location{" +
                "name='" + name + '\'' +
                ", cost=" + cost +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Location location = (Location) o;
        return Objects.equals(name, location.name) && Objects.equals(cost, location.cost);
    }

    public int compareTo(Location other) {
            return this.name.compareTo(other.name);
    }


    @Override
    public int hashCode() {
        return Objects.hash(name, cost);
    }
}
