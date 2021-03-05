package Compulsory;

import java.time.LocalTime;
import java.util.Map;

/**
 * Class Restaurant that extends the class Location and implements the Visitable and Classifiable interfaces, with constructors, getters and setters, and the methods from Object class.
 */
public class Restaurant extends Location implements Visitable, Classifiable{

    private LocalTime openingTime, closingTime;
    private double rank;

    public Restaurant(String name, Map<Location, Integer> cost) {
        super(name, cost);
    }

    public Restaurant() {

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
    public double getRank() {
        return rank;
    }

    public void setRank(double rank) {
        this.rank = rank;
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "name=" + name +
                ", openingTime=" + openingTime +
                ", closingTime=" + closingTime +
                ", rank=" + rank +
                "}\n";
    }
}
