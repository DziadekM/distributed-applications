// Definition of the Endpoints
var express = require("express");
var app = express();
var fs = require("fs");

app.use(express.json());

// Find all passengers on a particular flight
app.get("/api/passengersOnFlight/:flight", function (req, res) {
  // First read existing users.
  fs.readFile(__dirname + "/" + "passenger.json", "utf8", function (err, data) {
    //get JSON Object
    var allPassengers = JSON.parse(data);
    //get flight from URL
    var flight = req.params.flight;
    //find all passengers by Flight
    var result = allPassengers.passengers.filter(
      (record) => record.flight === flight
    );
    res.end(JSON.stringify(result));
  });
});

// Find all passengers
app.get("/api/passengers", function (req, res) {
  fs.readFile(__dirname + "/" + "passenger.json", "utf8", function (err, data) {
    console.log(data);
    res.end(data);
  });
});
// Find all flights of a specific passenger on a particular airline
app.get("/api/passengers/:id/:airline", function (req, res) {
  // First read existing users.
  fs.readFile(__dirname + "/" + "passenger.json", "utf8", function (err, data) {
    var allPassengers = JSON.parse(data);

    const id = req.params.id;
    const airline = req.params.airline;

    //find all passengers by Flight
    var result = allPassengers.passengers.filter(
      (record) => record.id == id && record.airline == airline
    );
    res.end(JSON.stringify(result));
  });
});

//Book a flight for a passenger
app.post("/api/booking/:id", function (req, res) {
  fs.readFile(__dirname + "/" + "passenger.json", "utf8", function (err, data) {
    //get the JSON-Request from Postman and display it here --> no database implemented
    req.body;
    console.log(JSON.stringify(req.body));
    res.json(req.body);
  });
});

// cancel or delete a flight
app.delete("/api/cancelFlight/:flight", function (req, res) {
  fs.readFile(__dirname + "/" + "passenger.json", "utf8", function (err, data) {
    var allPassengers = JSON.parse(data);
    var flight = req.params.flight;

    var result = allPassengers.passengers.filter(
      (record) => record.flight !== flight
    );
    res.end(JSON.stringify(result));
  });
});

// reebook a passenger
app.post("/api/rebookPassenger/:id", function (req, res) {
  // First read existing users.
  fs.readFile(__dirname + "/" + "passenger.json", "utf8", function (err, data) {
    //get the JSON-Request from Postman and display it here --> no database implemented
    req.body;
    console.log(JSON.stringify(req.body));
    res.json(req.body);
  });
});

// Server Details
var server = app.listen(3000, "localhost", function () {
  server.on("listening", function () {});
  console.log("Express server started on localhost %s ", server.address().port);
});
