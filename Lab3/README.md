# PA Lab 3

Author: Barat Narcis Stefan

## Compulsory
 - &#9745; Create an object-oriented model of the problem. You should have at least the following classes City, Hotel, Museum, Church, Restaurant.
The natural ordering of their objects is given by their names.
 - &#9745; Create the interfaces Visitable, Payable, Classifiable. The classes above must implement these interfaces accordingly.
 - &#9745; The City class will contain a List of locations.
 - &#9745; Each location will contain a Map representing the times required to go from this location to others.
 - &#9745; Create all the objects given in the example.

The checkedboxes means that the problem was solved.

### Example
```bash
International->Art Museum:10
International->History Museum:50
Art Museum->St. Anne:10
Art Museum->St. George:20
Art Museum->History Museum:20
History Museum->St. George:20
St. George->St. Anne:30
St. George->Perl:10
St. Anne->Perl:20

City{nodes=
[Hotel{name=International, openingTime=07:00, closingTime=00:00, rank=1.0}
, Museum{name=Art Museum, openingTime=09:30, closingTime=17:00, ticketPrice=20.0}
, Museum{name=History Museum, openingTime=08:30, closingTime=18:00, ticketPrice=15.0}
, Church{name=St. George, openingTime=07:00, closingTime=00:00}
, Church{name=St. Anne, openingTime=07:00, closingTime=00:00}
, Restaurant{name=Perl, openingTime=09:00, closingTime=22:30, rank=1.0}
]}
```

## Optional

- &#9745; In the City class, create a method to display the locations that are visitable and are not payable, sorted by their opening hour.
- &#9745; Create default methods in the interface Visitable, with the opening hour 09:30 and the closing hour 20:00.
- &#9745; Create a static method getVisitingDuration,in the interface Visitable, that returns a Duration object, representing how long a location is opened during a day.
- &#9745; Create the class TravelPlan. An instance of this class will contain a city and the preferences regarding the visiting order.
- Implement an efficient agorithm to determine the shortest path between two given locations, conforming to the preferences.

The checkedboxes means that the problem was solved.

### Example
```bash
PT9H30M
International
Perl
St. George
St. Anne
```

## Bonus

- &#9745; Suppose that the tourist has a specific number of days available to visit the city and every day he (or she) has the same number of minutes available for visiting.
- &#9745; Suppose that there is a special start location (the hotel) - the tourist must start and end a daily trip in this location.
- Implement an algorithm that will create a plan (a trip for each day), such that the tourist visits as many locations as possible. 
- Test your algorithm using JUnit or other framework.