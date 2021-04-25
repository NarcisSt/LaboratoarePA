package EntityClasses;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Class City describes the city with all the locations.
 */

public class City {

    public List<Location> nodes = new ArrayList<>();

    public City(List<Location> nodes) {
        this.nodes = nodes;
    }

    public City() {

    }

    public List<Location> getNodes() {
        return nodes;
    }

    public void setNodes(List<Location> nodes) {
        this.nodes = nodes;
    }

    /**
     * Method that add the locations into the city.
     *
     * @param node a location
     */
    public void addLocation (Location node){
        nodes.add(node);
    }

    @Override
    public String toString() {
        return "City{" +
                "nodes=\n" + nodes +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        City city = (City) o;
        return nodes.equals(city.nodes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nodes);
    }
}
