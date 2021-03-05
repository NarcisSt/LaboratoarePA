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