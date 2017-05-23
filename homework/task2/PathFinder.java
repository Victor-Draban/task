package homework.task2;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PathFinder {
    private int [][] costsMatrix;
    private int [][] minimalCostsMatrix;
    private ArrayList<String> citiesNames;

    public PathFinder(Map<String, List<Path>> cities) {
        costsMatrix = new int[cities.size()][cities.size()];
        minimalCostsMatrix = new int [cities.size()][cities.size()];
        citiesNames = new ArrayList<>(cities.keySet());
        fillMatrix(cities);
        findMinCosts(cities);
    }

    public int findPathCost(String source, String destination) {
        int sourceId = citiesNames.indexOf(source);
        int destinationId = citiesNames.indexOf(destination);
        return minimalCostsMatrix[sourceId][destinationId];
    }

    /** Method calculate the minimal cost for all possible paths,
     * and write costs to matrix wish minimal costs of paths.
     *
     *@param cities: The input data
     */
    private void findMinCosts(Map<String, List<Path>> cities) {

        int bestCost;
        boolean [] mark = new boolean[cities.size()]; // array of labels
        int[] cost = new int[cities.size()]; // array of distances

        for (Map.Entry<String, List<Path>> entry : cities.entrySet()) {
            int sourceCity = citiesNames.indexOf(entry.getKey());
            fill(mark, cost, 200001);
            cost[sourceCity] = 0;

            while (true) {
                bestCost = 200001;
                int u = -1;
                for (int i = 0; i < citiesNames.size(); i++) {
                    if (!mark[i] && cost[i] < bestCost) {
                        u = i;
                        bestCost = cost[i];
                    }
                }

                if (bestCost == 200001) break;

                for (int i = 0; i < citiesNames.size(); i++) {
                    if (!mark[i] && costsMatrix[u][i] != -1) {
                        if (cost[i] > cost[u] + costsMatrix[u][i]) {
                            cost[i] = cost[u] + costsMatrix[u][i];
                        }
                    }
                }

                mark[u] = true;
                // write minimal costs to minimalCostsMatrix
                for (int i = 0; i < cities.size(); i++) {
                    minimalCostsMatrix[sourceCity][i]=cost[i];
                }
            }
        }
    }

    /**
     *  Expose the distance between cities maxCost
     * @param used
     * @param dist
     * @param maxCost
     */
    private void fill (boolean [] used, int [] dist, int maxCost) {
        for (int i = 0; i < dist.length; i++) {
            dist[i] = maxCost;
            used[i] = false;
        }
    }

    /**
     *  We fill the matrix with the cost of the paths between the cities that were introduced
     * @param cities
     */
    private void fillMatrix(Map<String, List<Path>> cities) {
        for (Map.Entry<String, List<Path>> entry : cities.entrySet()) {
            for (int i = 0; i < entry.getValue().size(); i++) {
                costsMatrix[citiesNames.indexOf(entry.getKey())][entry.getValue().get(i).getCityId() - 1] = entry.getValue().get(i).getCost();
            }
        }

        /**
         *  When cities do not have direct connections with each other, we establish cost == -1
          */
        for (int i = 0; i < cities.size(); i++) {
            for (int j = 0; j <cities.size(); j++) {
                if (costsMatrix[i][j] == 0) costsMatrix[i][j] = -1;
            }
        }
    }
}