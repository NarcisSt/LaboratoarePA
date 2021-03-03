package Optional;

public class Solution {


    Problem problem = new Problem();

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

    public boolean checkData(int[] supply, int[] demand) {

        if (arraySum(supply) == arraySum(demand)) {

            return true;
        }

        return false;
    }

    public int computeCost() {

        int totalCost = 0;

        problem.readData();

        if (checkData(problem.supply, problem.demand)) {

            for (int i = 0; i < problem.supply.length; i++) {

                while (problem.supply[i] > 0) {

                    int demandLine = lineOfMinElement(problem.cost, i, problem.demand);
                    int temp = Math.min(problem.supply[i], problem.demand[demandLine]);

                    totalCost += temp * problem.cost[i][demandLine];
                    problem.supply[i] -= temp;
                    problem.demand[demandLine] -= temp;

                }
            }
        }

        return totalCost;
    }
}
