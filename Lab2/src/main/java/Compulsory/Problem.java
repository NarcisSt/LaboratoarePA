package Compulsory;

import java.util.Arrays;

public class Problem {

    private Source[] sources;
    private Destination[] destinations;

    private int supply[];
    private int demand[];
    private int cost[][];


    public Source[] getSources() {
        return sources;
    }

    public Destination[] getDestinations() {
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

    @Override
    public String toString() {
        return "Problem{" + System.lineSeparator() +
                "sources=" + Arrays.toString(sources) + System.lineSeparator() +
                "destinations=" + Arrays.toString(destinations) + System.lineSeparator() +
                "supply=" + Arrays.toString(supply) + System.lineSeparator() +
                "demand=" + Arrays.toString(demand) + System.lineSeparator() +
                "cost=" + Arrays.toString(cost) +
                '}';
    }
}
