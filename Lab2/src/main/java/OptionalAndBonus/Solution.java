package OptionalAndBonus;

/**
 * Class that computes the data and give the result of the problem.
 */

public class Solution {

    public Problem problem;

    public Solution(Problem problem) {
        this.problem = problem;
    }

    /**
     * This method returns the the index of the column of the min element from the line given as a parameter.
     *
     * @param cost the cost matrix
     * @param line the line we are looking at
     * @param demand the demand array
     * @return the index of the column of the min element from the line given as a parameter
     */
    public int lineOfMinElement(int[][] cost, int line, int[] demand) {

        int min = Integer.MAX_VALUE, i;

        for (i = 0; i < demand.length; i++) {
            if (cost[line][i] <= min && demand[i] != 0) {
                min = cost[line][i];
            }
        }
        for (i = 0; i < demand.length; i++) {
            if (cost[line][i] == min && demand[i] != 0) {
                break;
            }
        }

        return i;
    }

    public int arraySum(int[] arr) {

        int sum = 0;

        for (int i = 0; i < arr.length; i++)
            sum += arr[i];

        return sum;
    }

    /**
     * Method that checks if two arrays have the same sum of elements
     *
     * @param supply the supply array
     * @param demand the demand array
     * @return true if they have the same sum, false otherwise
     */
    public boolean checkIfSumOfArraysAreEquals(int[] supply, int[] demand) {
        return arraySum(supply) == arraySum(demand);
    }

    /**
     * The most important method of the program, which computes the minimize total cost of the transportation. I used my own idea for this one!
     *
     * @return the cost of the transportation
     * @throws Exception if the problem object was not instantiated, or if the supply and demand arrays doesnt have the same sum of elements.
     */
    public int computeCost() throws Exception {
        if (!problem.canBeSolved()) {
            throw new Exception("Please provide a problem to be solved");
        }
        if (!checkIfSumOfArraysAreEquals(problem.supply, problem.demand)) {
            throw new Exception("Supply and Demand sums are not equal");
        }

        int totalCost = 0;

        for (int i = 0; i < problem.supply.length; i++) {
            while (problem.supply[i] > 0) {
                int demandLine = lineOfMinElement(problem.cost, i, problem.demand);
                int temp = Math.min(problem.supply[i], problem.demand[demandLine]);

                totalCost += temp * problem.cost[i][demandLine];
                problem.supply[i] -= temp;
                problem.demand[demandLine] -= temp;
            }
        }
        return totalCost;
    }
}
