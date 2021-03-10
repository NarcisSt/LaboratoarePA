package Bonus;

public class Tourist {
    public int availableDays;
    public int minutesPerDay;
    public Location startLocation;
    public Location endLocation;

    public Tourist() {
    }

    public int getAvailableDays() {
        return availableDays;
    }

    public void setAvailableDays(int availableDays) {
        this.availableDays = availableDays;
    }

    public int getMinutesPerDay() {
        return minutesPerDay;
    }

    public void setMinutesPerDay(int minutesPerDay) {
        this.minutesPerDay = minutesPerDay;
    }

    public Location getStartLocation() {
        return startLocation;
    }

    public void setStartLocation(Location startLocation) {
        this.startLocation = startLocation;
    }

    public Location getEndLocation() {
        return endLocation;
    }

    public void setEndLocation(Location endLocation) {
        this.endLocation = endLocation;
    }

    public boolean isTripFinished (){
        return startLocation == endLocation;
    }
}
