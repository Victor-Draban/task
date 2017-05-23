package homework.task2;

import java.util.*;

/**
 *  Object that encapsulate the input data
 */
public class Reader {

    private static final int MAX_TESTS = 10;
    private static final int MAX_CITIES = 10_000;

    private List<TestCase> testCases = new ArrayList<>();
    private Map<String, List<Path>> cities = new LinkedHashMap<>();
    private List<Path> paths;
    private Map<String, String> sourceDestination = new LinkedHashMap<>();

    private Scanner scanner = new Scanner(System.in);

    public Reader() {
        int countTests = scanner.nextInt();
        int countCities = scanner.nextInt();
        validate(countTests, countCities);

        for (int i = 0; i < countTests; i++) {                  // input count of tests
            for (int j = 0; j < countCities; j++) {             // input count of cities
                String nameCity = scanner.next();
                int countCityConnected = scanner.nextInt();     // input count neighbors each city
                paths = new ArrayList<>();
                for (int k = 0; k < countCityConnected; k++) {  // put into map costs of way between cities
                    paths.add(new Path(scanner.nextInt(), scanner.nextInt()));
                }
                cities.put(nameCity, paths);                    // put into map city's names and map of the cost ways
            }

            TestCase testCase = new TestCase();
            testCase.setCities(cities);
            int countSearch = scanner.nextInt();                // input count source --> destination that we must to find out
            for (int j = 0; j < countSearch; j++) {             // and put them into map
                sourceDestination.put(scanner.next(), scanner.next());
            }
            testCase.setSourceDestination(sourceDestination);
            testCases.add(testCase);
        }
    }

    public List<TestCase> getTestCases() {
        return testCases;
    }

    private void validate(int countTests, int countCities) {
        if (countTests > MAX_TESTS || countCities > MAX_CITIES) {
            throw new IllegalArgumentException("date isn't correct");
        }
    }
}