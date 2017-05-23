package homework.task2;

import java.util.List;
import java.util.Map;

/**
 *   Class for storing tests
 */
public class TestCase {
    private Map<String, List<Path>> cities;
    private Map<String, String> sourceDestination;

    public Map<String, List<Path>> getCities() {
        return cities;
    }

    public void setCities(Map<String, List<Path>> cities) {
        this.cities = cities;
    }

    public Map<String, String> getSourceDestination() {
        return sourceDestination;
    }

    public void setSourceDestination(Map<String, String> sourceDestination) {
        this.sourceDestination = sourceDestination;
    }
}
