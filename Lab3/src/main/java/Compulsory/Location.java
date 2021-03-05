package Compulsory;

import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public abstract class Location {

    protected String name;
    protected Map<Location, Integer> cost = new HashMap<>();

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
        if (this.name != null) {
            return this.name.compareTo(other.name);
        }

        new Exception("The name is null");
        return 0;
        //not safe, check if name is null before
    }


    @Override
    public int hashCode() {
        return Objects.hash(name, cost);
    }
}
