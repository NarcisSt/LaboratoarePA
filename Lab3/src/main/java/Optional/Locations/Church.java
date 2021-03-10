package Optional.Locations;

import Optional.Location;

import java.time.LocalTime;
import java.util.Map;

public class Church extends Location {
    private LocalTime openingTime, closingTime;

    public Church(String name, Map<Location, Integer> cost) {
        super(name, cost);
    }

    public Church() {
    }

    public void setOpeningTime(LocalTime openingTime) {
        this.openingTime = openingTime;
    }

    public void setClosingTime(LocalTime closingTime) {
        this.closingTime = closingTime;
    }

    @Override
    public String toString() {
        return "Church{" +
                "name=" + name +
                ", openingTime=" + openingTime +
                ", closingTime=" + closingTime +
                "}\n";
    }
}
