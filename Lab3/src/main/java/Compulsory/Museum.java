package Compulsory;

import java.time.LocalTime;
import java.util.Map;

public class Museum extends Location implements Visitable, Payable{

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
