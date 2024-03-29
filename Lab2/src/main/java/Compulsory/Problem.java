package EntityClasses;

import java.util.Arrays;

/**
 * @author Barat Narcis Stefan
 * In this class i am defying the problem data, with the appropiate setters, getters and constructors.
 */

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

//    /**
//     * Method that displays the costs matrix.
//     * @param cost is the matrix of costs
//     * @return a friendly appearance of the matrix
//     */
//
//    public String displayCost(int[][] cost){
//        String output = "";
//
//        for (int i = 0; i < cost.length; i++) {
//
//            for (int j = 0; j < cost.length; j++) {
//                output = output.concat(cost[i][j] + " ");
//            }
//
//            output += System.lineSeparator();
//        }
//
//        return output;
//    }

    @Override
    public String toString() {

        return "Problem{" + System.lineSeparator() +
                "sources=" + Arrays.toString(sources) + System.lineSeparator() +
                "destinations=" + Arrays.toString(destinations) + System.lineSeparator() +
                "supply=" + Arrays.toString(supply) + System.lineSeparator() +
                "demand=" + Arrays.toString(demand) + System.lineSeparator() +
//                "cost=" + System.lineSeparator() + displayCost(cost) +
                "cost=" + Arrays.deepToString(cost) +
                '}';
    }
}
