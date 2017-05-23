package homework.task2;

/**
 *   Class for storing paths
 */
public class Path {

    private int cost;
    private int cityId;

    public Path(int cityId, int cost){
        setCityId(cityId);
        setCost(cost);
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }
}
