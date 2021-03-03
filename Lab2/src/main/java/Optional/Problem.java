package Optional;

import Optional.Destination;
import Optional.Source;

import java.util.Arrays;

public class Problem {

    public Optional.Source[] sources;
    public Optional.Destination[] destinations;

    public int supply[];
    public int demand[];
    public int cost[][];


    public Optional.Source[] getSources() {
        return sources;
    }

    public Optional.Destination[] getDestinations() {
        return destinations;
    }

    public int[] getSupply() {
        return supply;
    }

    public int[] getDemand() {
        return demand;
    }

    public int[][] getCost() {
        return cost;
    }

    public void setSources(Source[] sources) {
        this.sources = sources;
    }

    public void setDestinations(Destination[] destinations) {
        this.destinations = destinations;
    }

    public void setSupply(int[] supply) {
        this.supply = supply;
    }

    public void setDemand(int[] demand) {
        this.demand = demand;
    }

    public void setCost(int[][] cost) {
        this.cost = cost;
    }


    public void readData() {

        Source[] sources = new Source[3];

        sources[0] = new Factory("S1");
        sources[1] = new Warehouse("S2");
        sources[2] = new Warehouse("S3");

        Destination d1 = new Destination("D1");
        Destination d2 = new Destination("D2");
        Destination d3 = new Destination("D3");
        Destination d4 = new Destination("D4");

        setSources(sources);
        setDestinations(new Destination[]{d1, d2, d3, d4});
        setSupply(new int[]{300, 400, 500});
        setDemand(new int[]{250, 350, 400, 200});
        setCost(new int[][]{
                {3, 1, 7, 4},
                {2, 6, 5, 9},
                {8, 3, 3, 2}
        });


    }


    @Override
    public String toString() {

        return "Problem{" + System.lineSeparator() +
                "sources=" + Arrays.toString(sources) + System.lineSeparator() +
                "destinations=" + Arrays.toString(destinations) + System.lineSeparator() +
                "supply=" + Arrays.toString(supply) + System.lineSeparator() +
                "demand=" + Arrays.toString(demand) + System.lineSeparator() +
                "cost=" + Arrays.deepToString(cost) +
                '}';
    }
}
