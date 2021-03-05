package Compulsory;

import java.time.LocalTime;
import java.util.Map;

/**
 * Class Church that extends the class Location and implements the Visitable interface, with constructors, getters and setters, and the methods from Object class.
 */
public class Church extends Location implements Visitable{

    private LocalTime openingTime, closingTime;

    public Church(String name, Map<Location, Integer> cost) {
        super(name, cost);
    }

    public Church() {

    }

    @Override
    public LocalTime getOpeningTime() {
        return openingTime;
    }

    public void setOpeningTime(LocalTime openingTime) {
        this.openingTime = openingTime;
    }

    @Override
    public LocalTime getClosingTime() {
        return closingTime;
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
