package Bonus;

import Bonus.Interfaces.Visitable;
import Bonus.Locations.Church;
import Bonus.Locations.Hotel;
import Bonus.Locations.Museum;
import Bonus.Locations.Restaurant;

import java.time.LocalTime;

public class Main {
    public static void main(String[] args) {
        City city = new City();

        Hotel hotel1 = new Hotel();
        hotel1.setOpeningTime(LocalTime.of(7, 0));
        hotel1.setClosingTime(LocalTime.MIDNIGHT);
        hotel1.setName("International");
        hotel1.setRank(1);

        city.addLocation(hotel1);

        Museum museum1 = new Museum();
        museum1.setName("Art Museum");
        museum1.setOpeningTime(LocalTime.parse("09:30"));
        museum1.setClosingTime(LocalTime.parse("17:00"));
        museum1.setTicketPrice(20);

        city.addLocation(museum1);

        Museum museum2 = new Museum();
        museum2.setName("History Museum");
        museum2.setOpeningTime(LocalTime.parse("08:30"));
        museum2.setClosingTime(LocalTime.parse("18:00"));
        museum2.setTicketPrice(15);

        city.addLocation(museum2);

        Church church1 = new Church();
        church1.setName("St. George");
        church1.setOpeningTime(LocalTime.of(7, 0));
        church1.setClosingTime(LocalTime.MIDNIGHT);

        city.addLocation(church1);

        Church church2 = new Church();
        church2.setName("St. Anne");
        church2.setOpeningTime(LocalTime.of(5, 0));
        church2.setClosingTime(LocalTime.MIDNIGHT);

        city.addLocation(church2);

        Restaurant restaurant1 = new Restaurant();
        restaurant1.setName("Perl");
        restaurant1.setOpeningTime(LocalTime.of(9, 0));
        restaurant1.setClosingTime(LocalTime.of(22, 30));
        restaurant1.setRank(1);

        city.addLocation(restaurant1);

        hotel1.setCost(museum1, 10);
        hotel1.setCost(museum2, 50);
        museum1.setCost(museum2, 20);
        museum1.setCost(church1, 20);
        museum1.setCost(church2, 10);
        museum2.setCost(church1, 20);
        church1.setCost(church2, 30);
        church1.setCost(restaurant1, 10);
        church2.setCost(restaurant1, 20);

        System.out.println(Visitable.getVisitingDuration(museum2.getOpeningTime(), museum2.getClosingTime()));
        city.displayVisitableLocations();
    }
}
