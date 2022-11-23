## Exercise 3

### Specify a REST web service to manage flights. It should be possible:

1. Find all passengers on a particular flight
2. Find all flights of a specific passenger on a particular airline
3. Book a flight for a passenger
4. To cancel a flight
5. To rebook a passenger
   Design a URL mapping for these REST web services. Please specify the HTTP method a client must use to invoke the web service.

### Endpoints

| URI                             | HTTP Method |   POST body | Details                                                          |
| ------------------------------- | :---------: | ----------: | ---------------------------------------------------------------- |
| /api/passengersOnFlight/:flight |     GET     |       empty | Find all passengers on a particular flight                       |
| /api/passengers/:id/:airline    |    POST     |         GET | Find all flights of a specific passenger on a particular airline |
| /api/booking/:id                |    POST     | JSON String | Book a flight for a passenger                                    |
| /api/cancelFlight/:flight       |   DELETE    |       empty | cancel a flight                                                  |

| /api/rebookPassenger/:id | POST | empty | rebook a passenger |
