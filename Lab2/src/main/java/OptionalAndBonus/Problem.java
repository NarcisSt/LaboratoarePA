package OptionalAndBonus;

import java.util.Arrays;
import java.util.Random;

/**
 * In the class Problem i implemented the methods of giving the input in two ways:
 *  I. Manually creating the objects of type Source and Destination and putting the input manually, in the readData method.
 *  II. Generating large random instances.
 */

public class Problem {
    public Source[] sources;
    public Destination[] destinations;

    public int supply[];
    public int demand[];
    public int cost[][];

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

    /**
     * Setter for sources, which using the override equals method from Object class, throws an exception if a source is added more than once.
     *
     * @param sources the array of sources
     * @throws Exception if a source is added more than once
     */
    public void setSources(Source[] sources) throws Exception {
        for (int i = 0; i < sources.length; i++) {
            for (int j = 0; j < sources.length; j++) {
                if (i != j) {
                    if (sources[i].equals(sources[j])) {
                        throw new Exception("You cannot insert a source twice");
                    }
                }
            }
        }
        this.sources = sources;
    }

    /**
     * Setter for destinations, which using the override equals method from Object class, throws an exception if a destinations is added more than once.
     *
     * @param destinations the array of destinations
     * @throws Exception if a destination is added more than once
     */
    public void setDestinations(Destination[] destinations) throws Exception {
        for (int i = 0; i < destinations.length; i++) {
            for (int j = 0; j < destinations.length; j++) {
                if (i != j) {
                    if (destinations[i].equals(destinations[j])) {
                        throw new Exception("You cannot insert a destination twice");
                    }
                }
            }
        }
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

    /**
     * Method that is used for the manual initialization of the sources, destinations and the cost matrix
     *
     * @throws Exception is a source or a destination is added more than once.
     */
    public void readData() throws Exception {
        Source s1 = new Factory("S1");
        Source s2 = new Warehouse("S2");
        Source s3 = new Warehouse("S3");

        Destination d1 = new Destination("D1");
        Destination d2 = new Destination("D2");
        Destination d3 = new Destination("D3");
        Destination d4 = new Destination("D4");

        setSources(new Source[]{s1, s2, s3});
        setDestinations(new Destination[]{d1, d2, d3, d4});
        setSupply(new int[]{300, 400, 500});
        setDemand(new int[]{250, 350, 400, 200});
        setCost(new int[][]{
                {3, 1, 7, 4},
                {2, 6, 5, 9},
                {8, 3, 3, 2}
        });
    }

    /**
     * Method that generates large random instances
     *
     * @param nrOfSources the maximum number of sources
     * @param nrOfDestinations the maximum number of destinations
     * @param maximumStock the maximum sum of elements from destinations array and sources array
     * @param maximumCost the maximum cost that can be found in the cost matrix
     * @throws Exception is a source or a destination is added more than once.
     */
    public void generateRandomData(int nrOfSources, int nrOfDestinations, int maximumStock, int maximumCost) throws Exception {
        setSources(generateRandomSources(nrOfSources));
        setDestinations(generateRandomDestinations(nrOfDestinations));
        setSupply(generateRandomArray(nrOfSources, maximumStock));
        setDemand(generateRandomArray(nrOfDestinations, maximumStock));
        setCost(generateRandomCost(nrOfSources, nrOfDestinations, maximumCost));

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

    /**
     * Boolean method that verifies if the supply, demand, and the cost matrix are not null.
     *
     * @return true if the supply, demand, and the cost matrix have elements, otherwise, false
     */
    public boolean canBeSolved() {
        return this.supply != null && this.demand != null && this.cost != null;
    }

    /**
     * Method that generate nrOfSources sources, and choose random if the source is a Factory or a Warehouse.
     *
     * @param nrOfSources total number of sources
     * @return the sources array
     */
    private Source[] generateRandomSources(int nrOfSources) {

        Source[] sources = new Source[nrOfSources];

        for (int i = 0; i < sources.length; i++) {
            if (getRandomNumber(0, 1) == 1) {
                sources[i] = new Factory("S" + (i + 1));
            } else {
                sources[i] = new Warehouse("S" + (i + 1));
            }
        }
        return sources;
    }

    /**
     * Method that generate nrOfDestinations destinations
     *
     * @param nrOfDestinations total number of destinations
     * @return the destinations array
     */
    private Destination[] generateRandomDestinations(int nrOfDestinations) {
        Destination[] destinations = new Destination[nrOfDestinations];

        for (int i = 0; i < destinations.length; i++)
            destinations[i] = new Destination("D" + (i + 1));

        return destinations;
    }

    /**
     * Method that generates(one at the time) random the supply and demand arrays, with a maximum sum of maximumSum
     *
     * @param nrOfElements number of elements for the supply array and the demand array (not necessary that these two to be equal)
     * @param maximumSum maximum sum of elements
     * @return the supply array, and the demand array (separate!)
     * I basically used this method for both of the arrays.!!
     */
    private int[] generateRandomArray(int nrOfElements, int maximumSum){
        int[] array = new int[nrOfElements];

        for(int i = 0; i < nrOfElements; i++){
            array[i] = getRandomNumber(0, maximumSum);
            maximumSum -= array[i];
        }

        if(maximumSum != 0)
            array[nrOfElements - 1] += maximumSum;

        return  array;
    }

    /**
     * Method that generate random the cost matrix.
     *
     * @param nrOfSources number of sources
     * @param nrOfDestinations number of destinations
     * @param maximumCost maximum cost of a road between a source and a destination
     * @return the cost matrix
     */
    private int[][] generateRandomCost(int nrOfSources, int nrOfDestinations, int maximumCost){
        int[][] cost = new int[nrOfSources][nrOfDestinations];

        for(int i = 0; i < nrOfSources; i++){
            for(int j = 0; j < nrOfDestinations; j++){
                cost[i][j] = getRandomNumber(1, 10);
            }
        }
        return cost;
    }

    /**
     * Method that generates a random number between min and max
     *
     * @param min lower bound
     * @param max upper bound
     * @return the number
     */
    private int getRandomNumber(int min, int max) {
        Random rand = new Random();
        return rand.nextInt(max - min + 1) + min;
    }
}
