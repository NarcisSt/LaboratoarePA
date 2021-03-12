package Optional;

import Optional.Locations.*;

import java.util.*;

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
    public void addLocation(Location node) {
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

    /**
     * Method that display the locations that are visitable and are not payable, sorted by their opening hour.
     */
    public void displayVisitableLocations() {
        Collections.sort(nodes);
        for (Location location : nodes) {
            if(location instanceof Church || location instanceof Restaurant || location instanceof Hotel){
                System.out.println(location.name);
            }
        }
    }
}
