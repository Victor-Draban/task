package homework.task2;

import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        Reader reader = new Reader();
        for (TestCase testCase : reader.getTestCases()) {
            runTestCase(testCase.getCities(), testCase.getSourceDestination());
        }
    }

    private static void runTestCase(Map<String, List<Path>> cities, Map<String, String> sourceDestination) {
        PathFinder pathFinder = new PathFinder(cities);

        for(Map.Entry<String, String> entry : sourceDestination.entrySet()) {
            String source = entry.getKey();
            String destination = entry.getValue();
            int transportationCost = pathFinder.findPathCost(source, destination);
            System.out.println(transportationCost);
        }
    }
}
