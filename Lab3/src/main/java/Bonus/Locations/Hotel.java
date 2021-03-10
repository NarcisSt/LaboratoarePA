package Bonus.Locations;


import Bonus.Interfaces.Classifiable;
import Bonus.Location;

import java.time.LocalTime;
import java.util.Map;

public class Hotel extends Location implements Classifiable {
    private LocalTime openingTime, closingTime;
    private double rank;

    public Hotel(String name, Map<Location, Integer> cost) {
        super(name, cost);
    }

    public Hotel() {
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
        return "Hotel{" +
                "name=" + name +
                ", openingTime=" + openingTime +
                ", closingTime=" + closingTime +
                ", rank=" + rank +
                "}\n";
    }
}
