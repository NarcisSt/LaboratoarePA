package Optional.Locations;

import Optional.Interfaces.Payable;
import Optional.Location;

import java.time.LocalTime;
import java.util.Map;

/**
 * Class Museum that extends the class Location and implements the Payable interface, with constructors, getters and setters, and the methods from Object class.
 */
public class Museum extends Location implements Payable {
    private LocalTime openingTime, closingTime;
    private double ticketPrice;

    public Museum() {
    }

    public Museum(String name, Map<Location, Integer> cost) {
        super(name, cost);
    }

    @Override
    public double getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(double ticketPrice) {
        this.ticketPrice = ticketPrice;
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
        return "Museum{" +
                "name=" + name +
                ", openingTime=" + openingTime +
                ", closingTime=" + closingTime +
                ", ticketPrice=" + ticketPrice +
                "}\n";
    }
}
