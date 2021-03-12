package Bonus;

/**
 * Class Tourist represents a tourist which have a number of days to visit, a number of minutes per day, a starting point and a ending location (which must be the same).
 */
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

    /**
     * Function that check if the starting location coincide with the ending location.
     *
     * @return True if the starting location coincide with the ending location, False otherwise.
     */
    public boolean isTripFinished (){
        return startLocation == endLocation;
    }
}
